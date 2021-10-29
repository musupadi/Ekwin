package com.ascendant.ekwin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("id_user")
    @Expose
    String id_user;

    @SerializedName("nama_user")
    @Expose
    String nama_user;

    //Jadwal
    @SerializedName("id_jadwal")
    @Expose
    String id_jadwal;

    @SerializedName("id_admin")
    @Expose
    String id_admin;

    @SerializedName("tgl_jadwal")
    @Expose
    String tgl_jadwal;

    @SerializedName("jam_jadwal")
    @Expose
    String jam_jadwal;

    @SerializedName("jadwal_kategori")
    @Expose
    String jadwal_kategori;

    @SerializedName("created_at")
    @Expose
    String created_at;

    //Materi
    @SerializedName("id_materi")
    @Expose
    String id_materi;

    @SerializedName("judul_materi")
    @Expose
    String judul_materi;

    @SerializedName("deskripsi_materi")
    @Expose
    String deskripsi_materi;

    @SerializedName("file_materi")
    @Expose
    String file_materi;

    @SerializedName("created_at_materi")
    @Expose
    String created_at_materi;

    @SerializedName("author")
    @Expose
    String author;

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String getTgl_jadwal() {
        return tgl_jadwal;
    }

    public void setTgl_jadwal(String tgl_jadwal) {
        this.tgl_jadwal = tgl_jadwal;
    }

    public String getJam_jadwal() {
        return jam_jadwal;
    }

    public void setJam_jadwal(String jam_jadwal) {
        this.jam_jadwal = jam_jadwal;
    }

    public String getJadwal_kategori() {
        return jadwal_kategori;
    }

    public void setJadwal_kategori(String jadwal_kategori) {
        this.jadwal_kategori = jadwal_kategori;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId_materi() {
        return id_materi;
    }

    public void setId_materi(String id_materi) {
        this.id_materi = id_materi;
    }

    public String getJudul_materi() {
        return judul_materi;
    }

    public void setJudul_materi(String judul_materi) {
        this.judul_materi = judul_materi;
    }

    public String getDeskripsi_materi() {
        return deskripsi_materi;
    }

    public void setDeskripsi_materi(String deskripsi_materi) {
        this.deskripsi_materi = deskripsi_materi;
    }

    public String getFile_materi() {
        return file_materi;
    }

    public void setFile_materi(String file_materi) {
        this.file_materi = file_materi;
    }

    public String getCreated_at_materi() {
        return created_at_materi;
    }

    public void setCreated_at_materi(String created_at_materi) {
        this.created_at_materi = created_at_materi;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
