package com.ascendant.ekwin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;

import com.ascendant.ekwin.R;
import com.ascendant.ekwin.SharedPreferance.DB_Helper;

public class SplashActivity extends AppCompatActivity {
    DB_Helper dbHelper;
    String ID,NAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler();
        dbHelper = new DB_Helper(this);
        Cursor cursor = dbHelper.checkSession();
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                ID = cursor.getString(0);
                NAME = cursor.getString(1);
            }
        }
        if (ID != null){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            handler.postDelayed(new Runnable() {
                public void run() {
                    changeActivity();
                }
            }, 3000); //3000 L = 3 detik
        }
    }
    private void changeActivity(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}