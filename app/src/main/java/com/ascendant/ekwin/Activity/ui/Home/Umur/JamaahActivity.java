package com.ascendant.ekwin.Activity.ui.Home.Umur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ascendant.ekwin.API.ApiRequest;
import com.ascendant.ekwin.API.RetroServer;
import com.ascendant.ekwin.Adapter.AdapterJamah;
import com.ascendant.ekwin.Adapter.AdapterTema;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.Model.JamaahModel;
import com.ascendant.ekwin.Model.ResponseArrayObject;
import com.ascendant.ekwin.Model.ResponseJamaah;
import com.ascendant.ekwin.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JamaahActivity extends AppCompatActivity {
    RecyclerView rv;
    private List<JamaahModel> mItems = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    Musupadi musupadi = new Musupadi();
    LinearLayout Back;
    TextView Jamaah;
    String KatJamaah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jamaah);

        rv = findViewById(R.id.recycler);
        Jamaah = findViewById(R.id.tvJamaah);
        Intent intent = getIntent();
        KatJamaah = intent.getExtras().getString("KATEGORI");
        Jamaah.setText("Kategori : "+KatJamaah);

        Back = findViewById(R.id.linearBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Logic();
    }

    private void Logic(){
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(mManager);
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseJamaah> data =api.Jamaah(musupadi.AUTH(),KatJamaah);
        data.enqueue(new Callback<ResponseJamaah>() {
            @Override
            public void onResponse(Call<ResponseJamaah> call, Response<ResponseJamaah> response) {
                try {
                    mItems=response.body().getData();
                    mAdapter = new AdapterJamah(JamaahActivity.this,mItems);
                    rv.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(JamaahActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseJamaah> call, Throwable t) {

            }
        });
    }
}