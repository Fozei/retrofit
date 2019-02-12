package com.example;

import com.google.gson.Gson;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {
        String jsonString = getJsonString();

        Dispatcher dispatcher = new Dispatcher(Executors.newFixedThreadPool(20));
        dispatcher.setMaxRequests(20);
        dispatcher.setMaxRequestsPerHost(1);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String s) {
                System.out.println(s);
            }
        });

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .dispatcher(dispatcher)
                .connectionPool(new ConnectionPool(100, 30, TimeUnit.SECONDS))
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl("http://www.baidu.com")
                .client(okHttpClient)
//                .addCallAdapterFactory(DefaultCallAdapterFr)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        IRequestApi iRequestApi = retrofit.create(IRequestApi.class);

        Call<String> call = iRequestApi.get(jsonString);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(call);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(call);
            }
        });
        Call<String> call2 = iRequestApi.get2("3333");
        call2.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(call);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(call);
            }
        });

    }

    private static String getJsonString() {
        Main.class.getDeclaredMethods();
        TestBean bean = new TestBean();
        Gson gson = new Gson();
        return gson.toJson(bean);
    }


    static class TestBean {
        private String name = "zhangsan";
    }


}
