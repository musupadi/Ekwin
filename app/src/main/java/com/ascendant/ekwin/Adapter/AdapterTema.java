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

public class AdapterTema extends RecyclerView.Adapter<AdapterTema.HolderData> {
    private List<DataModel> mList;
    private Context ctx;
    Musupadi ascendant;
    public AdapterTema(Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
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
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        LinearLayout card;
        TextView Nama,ID;

        public HolderData(View v) {
            super(v);
            ID = v.findViewById(R.id.tvId);
            card = v.findViewById(R.id.linearCard);
            Nama = v.findViewById(R.id.tvNama);
        }
    }
}
