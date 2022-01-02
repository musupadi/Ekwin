package com.ascendant.ekwin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseJamaah {
    @SerializedName("status")
    @Expose
    String status;

    @SerializedName("data")
    @Expose
    List<JamaahModel> data;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<JamaahModel> getData() {
        return data;
    }

    public void setData(List<JamaahModel> data) {
        this.data = data;
    }
}
