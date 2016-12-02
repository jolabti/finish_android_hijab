package com.myhijab.myhijab;

/**
 * Created by Ramdhan on 9/15/2016.
 */


import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("masukkan.php")
    Call<PembelianResponse> serverCall(

            @Field("id_user") String iduser,
            @Field("kd_hijab") String kodhijab,
            @Field("pesanan") int pesanan,
            @Field("email") String Email,
            @Field("nama_lengkap") String namalengkap,
            @Field("alamat") String alamat,
            @Field("no_tlp") String telpon,
            @Field("total") int total
    );

}


