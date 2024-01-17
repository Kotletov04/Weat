package com.example.testapp.Other;

import com.example.testapp.Req.Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateApi {
    public static Retrofit retrofit;
    public static Interface inter;
    private static CreateApi instance;



    private CreateApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CreateApi getInstance() {
        if (instance == null) {
            instance = new CreateApi();
        }
        return instance;
    }

    public Interface getApi() {

        return retrofit.create(Interface.class);
    }


}