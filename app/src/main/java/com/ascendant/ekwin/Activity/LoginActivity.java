package com.ascendant.ekwin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ascendant.ekwin.API.ApiRequest;
import com.ascendant.ekwin.API.RetroServer;
import com.ascendant.ekwin.Method.Musupadi;
import com.ascendant.ekwin.Model.ResponseObject;
import com.ascendant.ekwin.R;
import com.ascendant.ekwin.SharedPreferance.DB_Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText Password,Username;
    ImageView eye;
    Boolean SeenPass=true;
    Button Login;
    Musupadi musupadi = new Musupadi();
    DB_Helper dbHelper = new DB_Helper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        eye = findViewById(R.id.ivEye);
        Login = findViewById(R.id.btnLogin);
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
                Logic();
            }
        });
    }
    private void Logic(){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Sedang Mencoba Login");
        pd.setCancelable(false);
        pd.show();
        musupadi = new Musupadi();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseObject> login = api.Login(musupadi.AUTH(),
                Username.getText().toString(),
                Password.getText().toString());
        login.enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                try {
                    if (response.body().getStatus().equals("true")){
                        dbHelper = new DB_Helper(LoginActivity.this);
                        dbHelper.saveSession(response.body().data.getId_user(),response.body().data.getNama_user());
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                    pd.hide();
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, "Terjadi kesalahan "+e.toString(), Toast.LENGTH_SHORT).show();
                    pd.hide();
                }
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {

            }
        });
    }
}