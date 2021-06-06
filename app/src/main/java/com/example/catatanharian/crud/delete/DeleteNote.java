package com.example.catatanharian.crud.delete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.catatanharian.R;
import com.example.catatanharian.db.DBHelper;
import com.example.catatanharian.main.MainActivity;

/*
Tanggal pengetjaan  : 4 Juni 2021
NIM                 : 10118375
Nama                : Teguh Ary Erdiansyah
Kelas               : IF-9
 */

public class DeleteNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        getSupportActionBar().hide();

        Button btnYes = findViewById(R.id.btnDeleteYes);
        Button btnNo = findViewById(R.id.btnDeleteNo);

        DBHelper helper = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("Id");

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer isSuccess = helper.deteleData(id);

                if (isSuccess > 0){
                    Toast.makeText(DeleteNote.this,"Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DeleteNote.this, MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(DeleteNote.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeleteNote.this, MainActivity.class));
            }
        });
    }
}