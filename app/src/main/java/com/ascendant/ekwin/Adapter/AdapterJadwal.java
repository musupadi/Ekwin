package com.ascendant.ekwin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterJadwal extends RecyclerView.Adapter<AdapterJadwal.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Musupadi ascendant;
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
        holderData.Jam.setText(dm.getJam_jadwal());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView Tanggal,Jam;
        LinearLayout card;
        public HolderData(View v) {
            super(v);
            Tanggal = v.findViewById(R.id.tvTanggal);
            Jam = v.findViewById(R.id.tvJam);
            card = v.findViewById(R.id.card);
        }
    }
}
