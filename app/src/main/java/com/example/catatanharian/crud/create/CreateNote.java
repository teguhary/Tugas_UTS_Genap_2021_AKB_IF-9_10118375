package com.example.catatanharian.crud.create;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.catatanharian.R;
import com.example.catatanharian.db.DBHelper;
import com.example.catatanharian.main.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
Tanggal pengetjaan  : 4 Juni 2021
NIM                 : 10118375
Nama                : Teguh Ary Erdiansyah
Kelas               : IF-9
 */

public class CreateNote extends AppCompatActivity {

    private EditText create_judul, create_kategori, create_isi;
    private Date tanggal;
    private SimpleDateFormat tanggalformat;
    private Button create_btn;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        getSupportActionBar().hide();

        tanggal = Calendar.getInstance().getTime();
        tanggalformat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        create_judul = findViewById(R.id.judul);
        create_kategori = findViewById(R.id.kategori);
        create_isi = findViewById(R.id.isi);
        create_btn = findViewById(R.id.btn);

        helper = new DBHelper(this);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String judul = create_judul.getText().toString();
                String kategori = create_kategori.getText().toString();
                String isi = create_isi.getText().toString();
                String tanggal2 = tanggalformat.format(tanggal);

                if (TextUtils.isEmpty(judul)) {
                    create_judul.setError("Judul tidak boleh kosong");
                    create_judul.requestFocus();
                } else if (TextUtils.isEmpty(kategori)) {
                    create_kategori.setError("Kategori tidak boleh kosong");
                    create_kategori.requestFocus();
                } else if (TextUtils.isEmpty(isi)) {
                    create_isi.setError("Isi catatan tidak boleh kosong");
                    create_isi.requestFocus();
                } else {
                    boolean isSuccess = helper.insertData(judul, kategori, isi, tanggal2);

                    if (isSuccess) {
                        Toast.makeText(CreateNote.this, "Data berhasil ditambah", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(CreateNote.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(CreateNote.this, "Data gagal ditambah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}