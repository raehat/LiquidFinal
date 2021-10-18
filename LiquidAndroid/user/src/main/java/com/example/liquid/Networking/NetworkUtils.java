package com.example.liquid.Networking;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.liquid.Auth.FirstPage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    public static final String url = "http://192.168.1.35:3000/";

    public static Retrofit retrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
