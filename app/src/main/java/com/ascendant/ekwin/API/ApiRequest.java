package com.ascendant.ekwin.API;

import com.ascendant.ekwin.Model.ResponseArrayObject;
import com.ascendant.ekwin.Model.ResponseObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiRequest {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseObject> Login(@Header("Authorization") String authHeader,
                               @Field("email") String email,
                               @Field("password") String password);

    @POST("jadwal")
    Call<ResponseArrayObject> Jadwal(@Header("Authorization") String authHeader);

    @POST("materi")
    Call<ResponseArrayObject> Materi(@Header("Authorization") String authHeader);
}