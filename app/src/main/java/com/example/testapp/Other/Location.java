package com.example.testapp.Other;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;

import androidx.core.app.ActivityCompat;

public class Location {

    private static String LON;
    private static String LAT;
    private static Context mContext;

    public static void Location() {

        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;


        locationManager = (LocationManager) mContext.getSystemService(context);

        String provider = LocationManager.GPS_PROVIDER;

        @SuppressLint("MissingPermission")
        android.location.Location location = locationManager.getLastKnownLocation(provider);



        setLON(String.valueOf(location.getLongitude()));
        setLAT(String.valueOf(location.getLatitude()));
    }

    public String getLON() {
        return LON;
    }

    public String getLAT() {
        return LAT;
    }

    public static void setLON(String lon) {
        Location.LON = LON;
    }

    public static void setLAT(String lat) {
        Location.LAT = LAT;
    }


}
