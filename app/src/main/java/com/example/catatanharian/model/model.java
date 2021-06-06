package com.example.catatanharian.model;

public class model {
    private String id;
    private String judul;
    private String kategori;
    private String tanggal;
    private String isi;

    public model(String id, String judul, String kategori, String tanggal, String isi) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
