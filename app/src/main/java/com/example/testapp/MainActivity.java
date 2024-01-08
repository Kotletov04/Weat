package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testapp.Adapter.Adapter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.testapp.Api.CreateApi;
import com.example.testapp.Fragments.HomePageFragment;
import com.example.testapp.Fragments.TempFragment;

import com.example.testapp.Model.FiveDays.Common.Sys;

import com.example.testapp.Other.Location;
import com.example.testapp.Other.Season;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {
    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    Season season = new Season();
    BottomNavigationView bottomNavigationView;

    HomePageFragment homePageFragment = new HomePageFragment();
    TempFragment tempFragment = new TempFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);




        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }



        pagerMain = findViewById(R.id.main_container);
        bottomNavigationView = findViewById(R.id.bottom_nav);

        fragmentArrayList.add(homePageFragment);
        fragmentArrayList.add(tempFragment);

        Adapter adapter = new Adapter(this, fragmentArrayList);

        pagerMain.setAdapter(adapter);

        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.home_button);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.temp_button);
                        break;

                }


                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home_button) {
                    pagerMain.setCurrentItem(0);
                } else if (itemId == R.id.temp_button) {
                    pagerMain.setCurrentItem(1);
                }
                return true;
            }
        });


    }

}