package com.ascendant.ekwin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.Model.JamaahModel;
import com.ascendant.ekwin.R;

import java.util.List;

public class AdapterJamah extends RecyclerView.Adapter<AdapterJamah.HolderData> {
    private List<JamaahModel> mList;
    private Context ctx;
    Musupadi ascendant;
    public AdapterJamah(Context ctx, List<JamaahModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_jamaah,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        final JamaahModel dm = mList.get(posistion);
        ascendant = new Musupadi();
        holderData.Kategori.setText(dm.getKategori());
        holderData.Status.setText(dm.getStatus_jamaah());
        holderData.Nama.setText(ascendant.SmallText(dm.getNama_jamaah()));
        holderData.ID.setText(String.valueOf(posistion+1));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        LinearLayout card;
        TextView Nama,Email,Kategori,Status,ID;

        public HolderData(View v) {
            super(v);
            card = v.findViewById(R.id.linearCard);
            Email = v.findViewById(R.id.tvEmail);
            Nama = v.findViewById(R.id.tvNama);
            ID = v.findViewById(R.id.tvId);
            Kategori = v.findViewById(R.id.tvKategori);
            Status = v.findViewById(R.id.tvStatus);
        }
    }
}
