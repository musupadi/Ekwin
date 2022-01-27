package com.ascendant.ekwin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ascendant.ekwin.API.ApiRequest;
import com.ascendant.ekwin.API.RetroServer;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.JamaahModel;
import com.ascendant.ekwin.R;
import com.ascendant.ekwin.SharedPreferance.DB_Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText Password,Username,Nama,Alamat,NoHP;
    ImageView eye;
    Boolean SeenPass=true;
    Button Login,Register;
    Musupadi musupadi = new Musupadi();
    DB_Helper dbHelper = new DB_Helper(this);
    Spinner Kategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Nama = findViewById(R.id.etNama);
        Alamat = findViewById(R.id.etAlamat);
        NoHP = findViewById(R.id.etNoHP);
        Kategori = findViewById(R.id.spKategori);
        eye = findViewById(R.id.ivEye);
        Login = findViewById(R.id.btnLogin);
        Register = findViewById(R.id.btnRegister);
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SeenPass){
                    SeenPass=false;
                    Password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    int pos = Password.getText().length();
                    Password.setSelection(pos);
                }else{
                    SeenPass=true;
                    Password.setInputType(129);
                    int pos = Password.getText().length();
                    Password.setSelection(pos);
                }
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logic();
            }
        });
    }
    private void Logic(){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Sedang Mencoba Register");
        pd.setCancelable(false);
        pd.show();
        musupadi = new Musupadi();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<JamaahModel> login = api.Register(musupadi.AUTH(),
                Nama.getText().toString(),
                NoHP.getText().toString(),
                Alamat.getText().toString(),
                Username.getText().toString(),
                Password.getText().toString(),
                Kategori.getSelectedItem().toString());
        login.enqueue(new Callback<JamaahModel>() {
            @Override
            public void onResponse(Call<JamaahModel> call, Response<JamaahModel> response) {
                pd.hide();
                try {
                    if (response.body().getData().equals("Success")){
                        Toast.makeText(RegisterActivity.this, "Jamaaah Berhasil Dibuat", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Jamaah                                                                                                                                Gagal dibuat", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }

                }catch (Exception e){
                    Toast.makeText(RegisterActivity.this, "Terjadi kesalahan "+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JamaahModel> call, Throwable t) {
                pd.hide();
                Toast.makeText(RegisterActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}