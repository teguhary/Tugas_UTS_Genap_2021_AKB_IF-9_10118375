package com.example.catatanharian.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
Tanggal pengetjaan  : 3 Juni 2021
NIM                 : 10118375
Nama                : Teguh Ary Erdiansyah
Kelas               : IF-9
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "notes.db";
    private static final String TABLE = "notes";
    private static final String COL_1 = "id";
    private static final String COL_2 = "judul";
    private static final String COL_3 = "kategori";
    private static final String COL_4 = "isi";
    private static final String COL_5 = "tanggal";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT, " +
                COL_5 + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return  db.rawQuery("SELECT * FROM " + TABLE, null);
    }

    public boolean insertData(String judul, String kategori, String isi, String tanggal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_2, judul);
        values.put(COL_3, kategori);
        values.put(COL_4, isi);
        values.put(COL_5, tanggal);

        long results = db.insert(TABLE, null, values);

        return results != -1;
    }

    public boolean updateData(String id, String judul, String kategori, String isi, String tanggal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, judul);
        contentValues.put(COL_3, kategori);
        contentValues.put(COL_4, isi);
        contentValues.put(COL_5, tanggal);

        long results = db.update(TABLE, contentValues, COL_1 + " = ? ", new String[]{id});

        return results != -1;
    }

    public Integer deteleData(String id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE, COL_1 + " = ? ", new String[]{id});
    }
}
