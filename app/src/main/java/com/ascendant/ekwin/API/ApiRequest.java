package com.ascendant.ekwin.API;

import com.ascendant.ekwin.Model.ResponseArrayObject;
import com.ascendant.ekwin.Model.ResponseJamaah;
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

    @POST("pendeta")
    Call<ResponseArrayObject> Pendeta(@Header("Authorization") String authHeader);

    @POST("tema")
    Call<ResponseArrayObject> Tema(@Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("jamaah")
    Call<ResponseJamaah> Jamaah(@Header("Authorization") String authHeader,
                                @Field("kategori") String kategori);



    @FormUrlEncoded
    @POST("jadwal")
    Call<ResponseArrayObject> Search(@Header("Authorization") String authHeader,
                                @Field("id_pendeta") String id_pendeta,
                                @Field("id_tema") String id_tema,
                                @Field("kategori_waktu") String kategori_waktu);
}
