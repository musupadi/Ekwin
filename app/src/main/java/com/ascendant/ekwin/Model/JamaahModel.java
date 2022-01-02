package com.ascendant.ekwin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JamaahModel {
    @SerializedName("nama_jamaah")
    @Expose
    String nama_jamaah;

    @SerializedName("no_hp")
    @Expose
    String no_hp;

    @SerializedName("status_jamaah")
    @Expose
    String status_jamaah;

    @SerializedName("kategori")
    @Expose
    String kategori;

    @SerializedName("email")
    @Expose
    String email;

    public String getNama_jamaah() {
        return nama_jamaah;
    }

    public void setNama_jamaah(String nama_jamaah) {
        this.nama_jamaah = nama_jamaah;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getStatus_jamaah() {
        return status_jamaah;
    }

    public void setStatus_jamaah(String status_jamaah) {
        this.status_jamaah = status_jamaah;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
