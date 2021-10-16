package com.example.liquid.Networking;

import com.example.liquid.Networking.NetworkModels.LoginModel;
import com.example.liquid.Networking.NetworkModels.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface networkAPI {

    @POST("login")
    Call<String> loginAcc(@Body LoginModel loginModel);

    @POST("register")
    Call<String> registerAcc(@Body RegisterModel registerModel);

}
