package com.ascendant.ekwin.Activity.ui.Home.Umur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ascendant.ekwin.R;

public class UmurActivity extends AppCompatActivity {
    LinearLayout Back;
    Button TK,Remaja,Dewasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umur);
        Back = findViewById(R.id.linearBack);
        TK = findViewById(R.id.btnTK);
        Remaja = findViewById(R.id.btnRemaja);
        Dewasa = findViewById(R.id.btnDewasa);

        TK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UmurActivity.this,JamaahActivity.class);
                i.putExtra("KATEGORI", "TK");
                startActivity(i);
            }
        });
        Remaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UmurActivity.this,JamaahActivity.class);
                i.putExtra("KATEGORI", "REMAJA");
                startActivity(i);
            }
        });
        Dewasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UmurActivity.this,JamaahActivity.class);
                i.putExtra("KATEGORI", "DEWASA");
                startActivity(i);
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}