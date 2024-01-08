package com.example.testapp.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testapp.Api.CreateApi;
import com.example.testapp.Model.CurrentWeather.Post;
import com.example.testapp.Other.Constants;

import com.example.testapp.Other.Location;
import com.example.testapp.R;

import retrofit2.Call;
import retrofit2.Callback;

public class HomePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home_page, container, false);


        CreateApi.getInstance().getApi().getJson(
                "Nizhniy Novgorod",
                "metric",
                Constants.KEY).enqueue(new Callback<Post>() {


            @Override
            public void onResponse(Call<Post> call, retrofit2.Response<com.example.testapp.Model.CurrentWeather.Post> response) {
                com.example.testapp.Model.CurrentWeather.Post posts = response.body();
                String TEMP = String.valueOf(Math.round(posts.getMain().getTemp()));
                String WIND = String.valueOf(posts.getWind().getSpeed());
                String BAR = String.valueOf(posts.getMain().getPressure());
                String WATER = String.valueOf(posts.getMain().getHumidity());
                String ICON = posts.getWeather().get(0).getIcon().substring(0, 2);

                Resources res = getResources();


                String wind_name = getResources().getString(R.string.name_wend);
                String davl_name = getResources().getString(R.string.name_davl);


                TextView temp_view = view.findViewById(R.id.temp);
                temp_view.setText(TEMP + "°");

                TextView wind_view = view.findViewById(R.id.wind);
                wind_view.setText(WIND + " " + wind_name);

                TextView water_view = view.findViewById(R.id.water);
                water_view.setText(WATER + "%");

                TextView bar_view = view.findViewById(R.id.barometer);
                bar_view.setText(BAR + " " + davl_name);


                Drawable drawable_sun = ResourcesCompat.getDrawable(res, R.drawable.sun_01, null);
                Drawable drawable_cloudy_02 = ResourcesCompat.getDrawable(res, R.drawable.cloudy_02, null);
                Drawable drawable_cloud_03 = ResourcesCompat.getDrawable(res, R.drawable.cloud_03, null);
                Drawable drawable_cloudy_04 = ResourcesCompat.getDrawable(res, R.drawable.cloudy_04, null);
                Drawable drawable_rain_09 = ResourcesCompat.getDrawable(res, R.drawable.rain_09, null);
                Drawable drawable_rain_10 = ResourcesCompat.getDrawable(res, R.drawable.rain_10, null);
                Drawable drawable_storm_11 = ResourcesCompat.getDrawable(res, R.drawable.storm_11, null);
                Drawable drawable_snow_13 = ResourcesCompat.getDrawable(res, R.drawable.snow_13, null);
                Drawable drawable_mist_50 = ResourcesCompat.getDrawable(res, R.drawable.mist_50, null);

                ImageView icon_view_weather = view.findViewById(R.id.icon_weather);
                switch (ICON) {

                    case "01":
                        icon_view_weather.setImageDrawable(drawable_sun);
                        break;
                    case "02":
                        icon_view_weather.setImageDrawable(drawable_cloudy_02);
                        break;
                    case "03":
                        icon_view_weather.setImageDrawable(drawable_cloud_03);
                        break;
                    case "04":
                        icon_view_weather.setImageDrawable(drawable_cloudy_04);
                        break;
                    case "09":
                        icon_view_weather.setImageDrawable(drawable_rain_09);
                        break;
                    case "10":
                        icon_view_weather.setImageDrawable(drawable_rain_10);
                        break;
                    case "11":
                        icon_view_weather.setImageDrawable(drawable_storm_11);
                        break;
                    case "13":
                        icon_view_weather.setImageDrawable(drawable_snow_13);
                        break;
                    case "50":
                        icon_view_weather.setImageDrawable(drawable_mist_50);
                        break;

                }

            }

            @Override
            public void onFailure(Call<com.example.testapp.Model.CurrentWeather.Post> call, Throwable throwable) {
                System.out.println("huy");
            }

        });
        
        Context mContext = getActivity().getApplicationContext();



        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;


        locationManager = (LocationManager) mContext.getSystemService(context);

        String provider = LocationManager.GPS_PROVIDER;

        @SuppressLint("MissingPermission")
        android.location.Location location = locationManager.getLastKnownLocation(provider);
        System.out.println(location.getLongitude());
        return view;
    }
}