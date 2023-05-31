package com.if4a.nicholasw.pokepedianicow.API;

import android.media.Image;

import com.if4a.nicholasw.pokepedianicow.Model.ModelResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ModelResponse> ardRetrieve();

    @FormUrlEncoded
    @POST("create.php")
    Call<ModelResponse> ardCreate(
            @Field("name") String name,
            @Field("entry") String entry,
            @Field("type") String type,
            @Field("ability") String ability,
            @Field("hp") String hp,
            @Field("atk") String atk,
            @Field("def") String def,
            @Field("spa") String spa,
            @Field("spd") String spd,
            @Field("spe") String spe,
            @Field("move1") String move1,
            @Field("move2") String move2,
            @Field("move3") String move3,
            @Field("move4") String move4,
            @Field("namaevo") String namaevo

    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ModelResponse> ardUpdate(
            @Field("id") String id,

            @Field("name") String name,
            @Field("entry") String entry,
            @Field("type") String type,
            @Field("ability") String ability,
            @Field("hp") String hp,
            @Field("atk") String atk,
            @Field("def") String def,
            @Field("spa") String spa,
            @Field("spd") String spd,
            @Field("spe") String spe,
            @Field("move1") String move1,
            @Field("move2") String move2,
            @Field("move3") String move3,
            @Field("move4") String move4,

            @Field("namaevo") String namaevo


    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ModelResponse> ardDelete(
            @Field("id") String id


    );
}

