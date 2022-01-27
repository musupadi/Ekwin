package com.ascendant.ekwin.Activity.ui.Home.Data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ascendant.ekwin.API.ApiRequest;
import com.ascendant.ekwin.API.RetroServer;
import com.ascendant.ekwin.Activity.ui.Home.Umur.JamaahActivity;
import com.ascendant.ekwin.Adapter.AdapterJamah;
import com.ascendant.ekwin.Adapter.AdapterTema;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.DataModel;
import com.ascendant.ekwin.Model.ResponseArrayObject;
import com.ascendant.ekwin.Model.ResponseJamaah;
import com.ascendant.ekwin.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity {
    LinearLayout Back;
    Musupadi musupadi = new Musupadi();
    TextView Pendeta,Jadwal,Materi,Jamaah,Dewasa,Remaja,TK,Dewasa2,Remaja2,TK2;;
    DecimalFormat df = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Pendeta = findViewById(R.id.tvJumlahPendeta);
        Jadwal = findViewById(R.id.tvJadwal);
        Materi = findViewById(R.id.tvMateri);
        Jamaah = findViewById(R.id.tvJamaah);
        Dewasa = findViewById(R.id.tvDewasa);
        Remaja = findViewById(R.id.tvRemaja);
        TK = findViewById(R.id.tvTK);
        Dewasa2 = findViewById(R.id.tvDewasa2);
        Remaja2 = findViewById(R.id.tvRemaja2);
        TK2= findViewById(R.id.tvTK2);
        Back = findViewById(R.id.linearBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        GetJamaahDewasa();
        GetPendeta();
        GetMateri();
        GetJadwal();
    }
    private void GetPendeta(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.Pendeta(musupadi.AUTH());
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    Pendeta.setText("Jumlah Pendeta\n"+response.body().getData().toArray().length);
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(DataActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {

            }
        });
    }
    private void GetMateri(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.Materi(musupadi.AUTH());
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    Materi.setText("Jumlah Materi\n"+response.body().getData().toArray().length);
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(DataActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {

            }
        });
    }
    private void GetJadwal(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseArrayObject> data =api.Jadwal(musupadi.AUTH());
        data.enqueue(new Callback<ResponseArrayObject>() {
            @Override
            public void onResponse(Call<ResponseArrayObject> call, Response<ResponseArrayObject> response) {
                try {
                    Jadwal.setText("Jumlah Jadwal\n"+response.body().getData().toArray().length);
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(DataActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArrayObject> call, Throwable t) {

            }
        });
    }
    private void Percentage(){
        int dewasa = Integer.parseInt(Dewasa2.getText().toString());
        int remaja = Integer.parseInt(Remaja2.getText().toString());
        int tk = Integer.parseInt(TK2.getText().toString());
        int total = dewasa+remaja+tk;
        Jamaah.setText(String.valueOf("Jumlah Jamaah :\n"+total));
        double DewasaPercent = Double.parseDouble(String.valueOf(dewasa))/Double.parseDouble(String.valueOf(total))*100;
        double RemajaPercent = Double.parseDouble(String.valueOf(remaja))/Double.parseDouble(String.valueOf(total))*100;
        double TKPercent = Double.parseDouble(String.valueOf(tk))/Double.parseDouble(String.valueOf(total))*100;
        Dewasa.setText(String.valueOf(dewasa)+" ("+df.format(DewasaPercent)+"%)");
        Remaja.setText(String.valueOf(remaja)+" ("+df.format(RemajaPercent)+"%)");
        TK.setText(String.valueOf(tk)+" ("+df.format(TKPercent)+"%)");
    }
    private void GetJamaahDewasa(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseJamaah> data =api.Jamaah(musupadi.AUTH(),"DEWASA");
        data.enqueue(new Callback<ResponseJamaah>() {
            @Override
            public void onResponse(Call<ResponseJamaah> call, Response<ResponseJamaah> response) {
                try {
                    Dewasa.setText(String.valueOf(response.body().getData().toArray().length));
                    Dewasa2.setText(String.valueOf(response.body().getData().toArray().length));
                    GetJamaahRemaja();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(DataActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseJamaah> call, Throwable t) {

            }
        });
    }
    private void GetJamaahRemaja(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseJamaah> data =api.Jamaah(musupadi.AUTH(),"Remaja");
        data.enqueue(new Callback<ResponseJamaah>() {
            @Override
            public void onResponse(Call<ResponseJamaah> call, Response<ResponseJamaah> response) {
                try {
                    Remaja.setText(String.valueOf(response.body().getData().toArray().length));
                    Remaja2.setText(String.valueOf(response.body().getData().toArray().length));
                    GetJamaahTK();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(DataActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseJamaah> call, Throwable t) {

            }
        });
    }
    private void GetJamaahTK(){
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseJamaah> data =api.Jamaah(musupadi.AUTH(),"TK");
        data.enqueue(new Callback<ResponseJamaah>() {
            @Override
            public void onResponse(Call<ResponseJamaah> call, Response<ResponseJamaah> response) {
                try {
                    TK.setText(String.valueOf(response.body().getData().toArray().length));
                    TK2.setText(String.valueOf(response.body().getData().toArray().length));
                    Percentage();
                }catch (Exception e){
                    Log.d("ZYARGA : ",e.toString());
                    Toast.makeText(DataActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseJamaah> call, Throwable t) {

            }
        });
    }
}