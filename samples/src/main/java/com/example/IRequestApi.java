package com.example;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface IRequestApi<P> {
    @GET(value = "hello")
    Call<String> get(@Query(value = "param") String url);

    @POST("hello")
    Call<String> post1(@Body RequestBody body);

    @FormUrlEncoded
    @POST("hello")
    Call<String> post2(@Field(value = "param", encoded = true) String param);

    @GET("hello")
    Call<String> get3(@Query("param") String url);

    @GET("hello4")
    Call<Map<String, String>> get4(@Query("param") String url);

    @GET("hello5")
    Call<Integer> get5(@Query("param") String url, @Query("param2") int index);

    @GET("hello5")
    Call<Integer> get6(@Query("param") String url, @Query("param2") P index);
}
