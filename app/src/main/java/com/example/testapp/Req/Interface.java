package com.example.testapp.Req;


import com.example.testapp.Model.CurrentWeather.Post;
import com.example.testapp.Model.FiveDays.PostFiveDays;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {
    @GET("weather")
    Call<Post> getJson(@Query("q") String city,
                       @Query("units") String units,
                       @Query("appid") String key);

    @GET("forecast")
    Call<PostFiveDays> getJsonFiveDays(@Query("q") String city,
                                       @Query("units") String units,
                                       @Query("appid") String key);



}
