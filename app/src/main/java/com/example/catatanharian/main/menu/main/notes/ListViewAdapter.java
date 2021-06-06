package com.example.catatanharian.main.menu.main.notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.catatanharian.R;
import com.example.catatanharian.crud.delete.DeleteNote;
import com.example.catatanharian.crud.edit.EditNote;
import com.example.catatanharian.model.model;

import java.util.List;

/*
Tanggal pengetjaan  : 4 Juni 2021
NIM                 : 10118375
Nama                : Teguh Ary Erdiansyah
Kelas               : IF-9
 */

public class ListViewAdapter extends BaseAdapter {

    private List<model> notesList;
    private Context context;
    private TextView judul, kategori, isi, tanggal;
    private Button btnEdit, btnDelete;

    public ListViewAdapter(List<model> notesList, Context context){
        this.notesList = notesList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_view, null);

        judul = v.findViewById(R.id.view_judul);
        tanggal = v.findViewById(R.id.view_tanggal);
        kategori = v.findViewById(R.id.view_kategori);
        isi = v.findViewById(R.id.view_isi);
        btnEdit = v.findViewById(R.id.btnEdit);
        btnDelete = v.findViewById(R.id.btnDelete);

        judul.setText(notesList.get(i).getJudul());
        tanggal.setText(notesList.get(i).getTanggal());
        kategori.setText(notesList.get(i).getKategori());
        isi.setText(notesList.get(i).getIsi());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditNote.class);
                intent.putExtra("Id", notesList.get(i).getId());
                intent.putExtra("Judul", notesList.get(i).getJudul());
                intent.putExtra("Tanggal", notesList.get(i).getTanggal());
                intent.putExtra("Kategori", notesList.get(i).getKategori());
                intent.putExtra("Isi", notesList.get(i).getIsi());

                context.startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeleteNote.class);
                intent.putExtra("Id", notesList.get(i).getId());

                context.startActivity(intent);
            }
        });

        return v;
    }
}
