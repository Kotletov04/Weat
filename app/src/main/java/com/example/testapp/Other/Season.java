package com.example.testapp.Other;


import static android.icu.lang.UCharacter.toUpperCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class Season {

    public static String main_name;
    public static String second_name;
    public static String last_name;

    public static String date(int add_days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, add_days);
        String month = calendar.getDisplayName(Calendar.MONTH,
                Calendar.LONG_FORMAT,
                Locale.forLanguageTag(toUpperCase(Locale.getDefault().getCountry())));
        int day = calendar.get(Calendar.DATE);

        return day + " " + month;
    }

    public static Season days_time() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        Integer[] utro = new Integer[]{4, 5, 6, 7, 8, 9, 10};
        Integer[] day = new Integer[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer[] soir = new Integer[]{21, 22, 23, 0, 1, 2, 3};

        List<Integer> utro_list = new ArrayList<>(Arrays.asList(utro));
        List<Integer> day_list = new ArrayList<>(Arrays.asList(day));
        List<Integer> soir_list = new ArrayList<>(Arrays.asList(soir));


        if (utro_list.contains(hour)) {
            Season.main_name = "УТРОМ";
            Season.second_name = "ДНЁМ";
            Season.last_name = "НОЧЬЮ";
        }
        else if (day_list.contains(hour)) {
            Season.main_name = "ДНЁМ";
            Season.second_name = "НОЧЬЮ";
            Season.last_name = "СЛ. УТРОМ";
        }
        else if (soir_list.contains(hour)) {
            Season.main_name = "НОЧЬЮ";
            Season.second_name = "СЛ. УТРОМ";
            Season.last_name = "СЛ. ДНЁМ";
        }
        return null;
    }

    public static String name_season() {
        Calendar calendar = Calendar.getInstance();

        int month = calendar.get(Calendar.MONTH);

        Integer[] winter = new Integer[]{11, 0, 1};
        Integer[] spring = new Integer[]{2, 3, 4};
        Integer[] summer = new Integer[]{5, 6, 7};
        Integer[] autumn = new Integer[]{8, 9, 10};

        List<Integer> winter_list = new ArrayList<>(Arrays.asList(winter));
        List<Integer> spring_list = new ArrayList<>(Arrays.asList(spring));
        List<Integer> summer_list = new ArrayList<>(Arrays.asList(summer));
        List<Integer> autumn_list = new ArrayList<>(Arrays.asList(autumn));

        if (winter_list.contains(month)) {
            return "winter";
        }

        else if (spring_list.contains(month)) {
            return "spring";
        }
        else if (summer_list.contains(month)) {
            return "summer";
        }
        else if (autumn_list.contains(month)) {
            return "autumn";
        }
        else {
            return null;
        }

    }




}


