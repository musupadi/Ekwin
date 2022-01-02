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
import com.ascendant.ekwin.R;

import java.util.List;

public class AdapterPendeta extends RecyclerView.Adapter<AdapterPendeta.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Musupadi ascendant;
    public AdapterPendeta(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
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
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        LinearLayout card;
        TextView Nama,Status,ID;

        public HolderData(View v) {
            super(v);
            ID = v.findViewById(R.id.tvId);
            card = v.findViewById(R.id.linearCard);
            Nama = v.findViewById(R.id.tvNama);
            Status = v.findViewById(R.id.tvStatus);
        }
    }
}
