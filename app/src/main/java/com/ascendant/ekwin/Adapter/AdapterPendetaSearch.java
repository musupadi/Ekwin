package com.ascendant.ekwin.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.ekwin.API.ApiRequest;
import com.ascendant.ekwin.API.RetroServer;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.Model.ResponseArrayObject;
import com.ascendant.ekwin.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterPendetaSearch extends RecyclerView.Adapter<AdapterPendetaSearch.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Musupadi ascendant;
    RecyclerView rvPendeta,rv;
    TextView idPendeta,idTema,NamaPendeta;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    Musupadi musupadi = new Musupadi();
    String Waktu;
    LinearLayout LPendeta;
    CardView CardPendeta;
    public AdapterPendetaSearch(Context ctx, List<DataModel> mList,RecyclerView rvPendeta,TextView idPendeta,TextView idTema,RecyclerView rv,String Waktu,LinearLayout LPendeta,TextView NamaPendeta,CardView CardPendeta){
        this.ctx = ctx;
        this.mList = mList;
        this.rvPendeta = rvPendeta;
        this.idPendeta = idPendeta;
        this.idTema = idTema;
        this.rv = rv;
        this.Waktu = Waktu;
        this.LPendeta = LPendeta;
        this.NamaPendeta = NamaPendeta;
        this.CardPendeta = CardPendeta;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_pendeta,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        ascendant = new Musupadi();
        holderData.Status.setText(dm.getStatus_pendeta());
        holderData.Nama.setText(dm.getNama_pendeta());
        holderData.ID.setText(String.valueOf(posistion+1));
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardPendeta.setVisibility(View.VISIBLE);
                NamaPendeta.setText(dm.getNama_pendeta());
                idPendeta.setText(dm.getId_pendeta());
                rvPendeta.setVisibility(View.GONE);
                rv.setVisibility(View.VISIBLE);
                LPendeta.setVisibility(View.GONE);
                SearchData();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        CardView card;
        TextView Nama,Status,ID;

        public HolderData(View v) {
            super(v);
            ID = v.findViewById(R.id.tvId);
            card = v.findViewById(R.id.cardPendeta);
            Nama = v.findViewById(R.id.tvNama);
            Status = v.findViewById(R.id.tvStatus);
        }
    }

    private void SearchData(){
        mManager = new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.Search(musupadi.AUTH(),idPendeta.getText().toString(),idTema.getText().toString(),Waktu);
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    mItems=response.body().getData();
                    mAdapter = new AdapterJadwal(ctx,mItems);
                    rv.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(ctx, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                Toast.makeText(ctx, "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
