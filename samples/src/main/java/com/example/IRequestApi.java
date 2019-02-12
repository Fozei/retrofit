package com.example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRequestApi {
    @GET("hello")
    Call<String> get(@Query("param") String url);

    @GET("hello")
    Call<String> get2(@Query("param") String url);

    @GET("hello")
    Call<String> get3(@Query("param") String url);
}
