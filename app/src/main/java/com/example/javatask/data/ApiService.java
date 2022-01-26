package com.example.javatask.data;

import android.content.Context;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL = "https://api.github.com/";
    private static ApiInterface apiInterface ;

    public static ApiInterface getINSTANCE(Context context) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        if (apiInterface == null) {
            apiInterface = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build().create(ApiInterface.class);

        }
        return apiInterface;
    }
}
