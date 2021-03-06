package com.example.catatanharian.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.catatanharian.R;
import com.example.catatanharian.main.MainActivity;

/*
Tanggal pengetjaan  : 2 Juni 2021
NIM                 : 10118375
Nama                : Teguh Ary Erdiansyah
Kelas               : IF-9
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent panggil = new Intent(Splash.this, MainActivity.class);
                startActivity(panggil);
                finish();
            }
        }, 5000);
    }
}