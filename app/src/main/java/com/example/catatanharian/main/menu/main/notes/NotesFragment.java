package com.example.catatanharian.main.menu.main.notes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.catatanharian.R;
import com.example.catatanharian.crud.create.CreateNote;
import com.example.catatanharian.db.DBHelper;
import com.example.catatanharian.model.model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class NotesFragment extends Fragment {

    private FloatingActionButton btnFab;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private ArrayList<model> notesList = new ArrayList<>();
    private DBHelper helper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_notes, container, false);

        btnFab = v.findViewById(R.id.fab);
        listView = v.findViewById(R.id.listView);

        helper = new DBHelper(this.getActivity());

        btnFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CreateNote.class));
            }
        });

        showAllData();

        return v;
    }

    public void showAllData(){
        notesList.clear();

        Cursor res = helper.getAllData();
        while (res.moveToNext()){
            String id = res.getString(0);
            String judul = res.getString(1);
            String kategori = res.getString(2);
            String tangal = res.getString(4);
            String isi = res.getString(3);

            notesList.add(new model(id, judul, kategori, tangal, isi));
        }

        listViewAdapter = new ListViewAdapter(notesList, getActivity());
        listView.setAdapter(listViewAdapter);
    }
}