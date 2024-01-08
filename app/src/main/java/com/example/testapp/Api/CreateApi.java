package com.example.testapp.Api;

import com.example.testapp.Other.Constants;
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
    /*public static void main(String[] args) throws IOException {

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();


        inter = retrofit.create(Interface.class);


        inter.getJson("London", "metric", "230d16c7bb47e501c6495c9b41ec7680").enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post posts = response.body();
                System.out.println(posts.getMain().getTemp());
                *//*for (Post post : posts) {
                    Object content = post.getCoord();
                    System.out.println(content);
                }*//*


            }

            @Override
            public void onFailure(Call<Post> call, Throwable throwable) {
                System.out.println(":((  " + throwable.getMessage());
            }
        });

    }
    */



}