package com.ascendant.ekwin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.R;

import java.util.List;

public class AdapterTemaSearch extends RecyclerView.Adapter<AdapterTemaSearch.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Musupadi ascendant;
    RecyclerView recyclerView;
    CardView cardView;
    TextView TemaNama,idTema;
    LinearLayout lJadwal;
    LinearLayout LTema;
    public AdapterTemaSearch(Context ctx, List<DataModel> mList,RecyclerView recyclerView,CardView cardView,TextView TemaNama,LinearLayout lJadwal,TextView idTema,LinearLayout LTema){
        this.ctx = ctx;
        this.mList = mList;
        this.recyclerView = recyclerView;
        this.cardView = cardView;
        this.TemaNama = TemaNama;
        this.lJadwal = lJadwal;
        this.idTema = idTema;
        this.LTema = LTema;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tema,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        ascendant = new Musupadi();
        holderData.Nama.setText(dm.getNama_tema());
        holderData.ID.setText(String.valueOf(posistion+1));
        holderData.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                TemaNama.setText(dm.getNama_tema());
                idTema.setText(dm.getId_tema());
                lJadwal.setVisibility(View.VISIBLE);
                LTema.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        CardView card;
        TextView Nama,ID;

        public HolderData(View v) {
            super(v);
            ID = v.findViewById(R.id.tvId);
            card = v.findViewById(R.id.cardTema);
            Nama = v.findViewById(R.id.tvNama);
        }
    }
}
