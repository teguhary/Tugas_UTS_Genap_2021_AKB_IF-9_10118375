package com.example.catatanharian.crud.edit;

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

public class EditNote extends AppCompatActivity {

    private EditText edit_judul, edit_kategori, edit_isi;
    private Date tanggal;
    private SimpleDateFormat tanggalformat;
    private Button btn;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();

        tanggal = Calendar.getInstance().getTime();;
        tanggalformat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        edit_judul = findViewById(R.id.judul);
        edit_kategori = findViewById(R.id.kategori);
        edit_isi = findViewById(R.id.isi);
        btn = findViewById(R.id.btn);

        edit_judul.setText(bundle.getString("Judul"));
        edit_kategori.setText(bundle.getString("Kategori"));
        edit_isi.setText(bundle.getString("Isi"));

        helper = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = bundle.getString("Id");
                String judul = edit_judul.getText().toString();
                String kategori = edit_kategori.getText().toString();
                String isi = edit_isi.getText().toString();
                String tanggal2 = tanggalformat.format(tanggal);

                if (TextUtils.isEmpty(judul)){
                    edit_judul.setError("Judul tidak boleh kosong");
                    edit_judul.requestFocus();
                }else if (TextUtils.isEmpty(kategori)){
                    edit_kategori.setError("Kategori tidak boleh kosong");
                    edit_kategori.requestFocus();
                }else if (TextUtils.isEmpty(isi)){
                    edit_isi.setError("Isi catatan tidak boleh kosong");
                    edit_isi.requestFocus();
                }else {
                    boolean isSuccess = helper.updateData(id, judul, kategori, isi, tanggal2);

                    if (isSuccess) {
                        Toast.makeText(EditNote.this, "Data berhasil diedit", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(EditNote.this, MainActivity.class));
                        finish();
                    }else  {
                        Toast.makeText(EditNote.this, "Data gagal diedit", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}