package com.ascendant.ekwin.Activity.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ascendant.ekwin.API.ApiRequest;
import com.ascendant.ekwin.API.RetroServer;
import com.ascendant.ekwin.Activity.ui.Home.Tema.TemaActivity;
import com.ascendant.ekwin.Adapter.AdapterPendetaSearch;
import com.ascendant.ekwin.Adapter.AdapterTema;
import com.ascendant.ekwin.Adapter.AdapterTemaSearch;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.Model.ResponseArrayObject;
import com.ascendant.ekwin.R;
import com.ascendant.ekwin.SharedPreferance.DB_Helper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReportFragment extends Fragment {
    ImageView Logout;
    DB_Helper dbHelper;
    private List<DataModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    RecyclerView rvTema,rvPendeta,rv;
    CardView Stage1,Stage2,cardPendeta;
    TextView TemaNamaStage1,tvJadwal,tvNamaTema,idTema,idPendeta,NamaPendeta;
    LinearLayout LJadwal,cardTema2;
    Button btnPagi,btnSiang,btnSore;
    Musupadi musupadi = new Musupadi();
    String Waktu;
    LinearLayout LTema,LPendeta,LinearJadwal2;
    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper=new DB_Helper(getActivity());
        TemaNamaStage1 = view.findViewById(R.id.tvNama);
        idTema = view.findViewById(R.id.tvIdTema);
        idPendeta = view.findViewById(R.id.tvIdPendeta);
        Stage1 = view.findViewById(R.id.cardStage1);
        Stage2 = view.findViewById(R.id.cardStage2);
        Logout = view.findViewById(R.id.ivLogout);
        rvTema = view.findViewById(R.id.recyclerTema);
        LJadwal = view.findViewById(R.id.linearJadwal);
        btnPagi = view.findViewById(R.id.btnPagi);
        btnSiang = view.findViewById(R.id.btnSiang);
        btnSore = view.findViewById(R.id.btnSore);
        tvJadwal = view.findViewById(R.id.tvJadwal);
        tvNamaTema = view.findViewById(R.id.tvNamaTema);
        rvPendeta = view.findViewById(R.id.recyclerPendeta);
        LTema = view.findViewById(R.id.linearTema);
        LPendeta = view.findViewById(R.id.linearPendeta);
        rv = view.findViewById(R.id.recycler);
        cardPendeta = view.findViewById(R.id.cardPendeta);
        NamaPendeta = view.findViewById(R.id.tvNamaPendeta);
        LinearJadwal2 = view.findViewById(R.id.linearJadwal2);
        cardTema2 = view.findViewById(R.id.cardNamaTema2);
        rvTema.setVisibility(View.VISIBLE);
        rvPendeta.setVisibility(View.GONE);
        LPendeta.setVisibility(View.GONE);
        TemaData();
        PendetaData();
        cardPendeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LJadwal.setVisibility(View.GONE);
                rv.setVisibility(View.GONE);
                LPendeta.setVisibility(View.VISIBLE);
                rvPendeta.setVisibility(View.VISIBLE);
            }
        });
        LinearJadwal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LJadwal.setVisibility(View.VISIBLE);
            }
        });
        cardTema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stage2.setVisibility(View.GONE);
                LTema.setVisibility(View.VISIBLE);
                rvTema.setVisibility(View.VISIBLE);
                TemaData();
                LPendeta.setVisibility(View.GONE);
                LJadwal.setVisibility(View.GONE);

            }
        });
        btnPagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stage1.setVisibility(View.GONE);
                LJadwal.setVisibility(View.GONE);
                tvJadwal.setText("Pagi");
                Stage2.setVisibility(View.VISIBLE);
                tvNamaTema.setText(TemaNamaStage1.getText());
                rvPendeta.setVisibility(View.VISIBLE);
                Waktu = "PAGI";
                LPendeta.setVisibility(View.VISIBLE);
            }
        });
        btnSiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stage1.setVisibility(View.GONE);
                LJadwal.setVisibility(View.GONE);
                tvJadwal.setText("Siang");
                Stage2.setVisibility(View.VISIBLE);
                tvNamaTema.setText(TemaNamaStage1.getText());
                rvPendeta.setVisibility(View.VISIBLE);
                Waktu = "SIANG";
                LPendeta.setVisibility(View.VISIBLE);
            }
        });
        btnSore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stage1.setVisibility(View.GONE);
                LJadwal.setVisibility(View.GONE);
                tvJadwal.setText("Sore");
                Stage2.setVisibility(View.VISIBLE);
                tvNamaTema.setText(TemaNamaStage1.getText());
                rvPendeta.setVisibility(View.VISIBLE);
                Waktu = "SORE";
                LPendeta.setVisibility(View.VISIBLE);
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                // Set a title for alert dialog
                builder.setTitle("Pemberitahuan");

                // Ask the final question
                builder.setMessage("Apakah Anda Yakin Ingin Logout ? ");

                // Set the alert dialog yes button click listener
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when user clicked the Yes button
                        // Set the TextView visibility GONE
                        dbHelper.userLogout(getActivity());
                    }
                });

                // Set the alert dialog no button click listener
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when No button clicked
                    }
                });

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();

            }
        });
    }

    private void TemaData(){
        mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rvTema.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.Tema(musupadi.AUTH());
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    mItems=response.body().getData();
                    mAdapter = new AdapterTemaSearch(getActivity(),mItems,rvTema,Stage1,TemaNamaStage1,LJadwal,idTema,LTema);
                    rvTema.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void PendetaData(){
        mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rvPendeta.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.Pendeta(musupadi.AUTH());
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    mItems=response.body().getData();
                    mAdapter = new AdapterPendetaSearch(getActivity(),mItems,rvPendeta,idPendeta,idTema,rv,Waktu,LPendeta,NamaPendeta,cardPendeta);
                    rvPendeta.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {
                try {
                    Toast.makeText(getActivity(), "Koneksi Gagal", Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });
    }

}