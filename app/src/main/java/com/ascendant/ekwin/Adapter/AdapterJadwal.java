package com.ascendant.ekwin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.ekwin.Activity.ui.Home.Jadwal.JadwalActivity;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterJadwal extends RecyclerView.Adapter<AdapterJadwal.HolderData> {
    private List<DataModel> mList;

    private List<DataModel> DataMateri,DataKategori;
    private Context ctx;
    Musupadi ascendant;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    public AdapterJadwal(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_jadwal,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        ascendant = new Musupadi();
        holderData.Tanggal.setText(dm.getTgl_jadwal());

        mManager = new GridLayoutManager(ctx,1);
        holderData.Materi.setLayoutManager(mManager);
        DataMateri=mList.get(posistion).getIsi();
        mAdapter = new AdapterMateri2(ctx,DataMateri);
        holderData.Materi.setAdapter(mAdapter);



        mManager = new GridLayoutManager(ctx,3);
        holderData.Kategori.setLayoutManager(mManager);
        DataKategori=mList.get(posistion).getKategori();
        mAdapter = new AdapterKategori(ctx,DataKategori);
        holderData.Kategori.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView Tanggal;
        LinearLayout card;
        RecyclerView Kategori,Materi;
        public HolderData(View v) {
            super(v);
            Tanggal = v.findViewById(R.id.tvTanggal);
            card = v.findViewById(R.id.card);
            Kategori = v.findViewById(R.id.recyclerCategory);
            Materi = v.findViewById(R.id.recyclerMateri);
        }
    }
}
