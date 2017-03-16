package com.example.chegu.diethouse.network;

import android.util.TypedValue;

import com.google.gson.JsonElement;
import com.squareup.okhttp.RequestBody;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {


@POST("login")
    Call<JsonElement> doLogin(@Body HashMap<String,String> data);

    @Headers("Content-Type: application/json")
    @POST("signup")
    Call<JsonElement> doRegister(@Body HashMap<String,String> data);

   @Headers("Content-Type: application/json")
   @POST("user/get_account")
   Call<JsonElement> getAccount(@Body GetAccount account);


    @Headers("Content-Type: application/json")
    @POST("user/post_details")
    Call<JsonElement> updateBmr(@Body DataBMI dataBMI);
}