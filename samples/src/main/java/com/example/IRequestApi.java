package com.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface IRequestApi<P> {
    @GET("hello")
    Call<String> get(@Query("param") String url);

    @GET("hello")
    Call<String> get2(@Query("param") String url);

    @GET("hello")
    Call<String> get3(@Query("param") String url);

    @GET("hello4")
    Call<Map<String, String>> get4(@Query("param") String url);

    @GET("hello5")
    Call<Integer> get5(@Query("param") String url, @Query("param2") int index);

    @GET("hello5")
    Call<Integer> get6(@Query("param") String url, @Query("param2") P index);
}
