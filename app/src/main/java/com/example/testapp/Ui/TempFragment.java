package com.example.testapp.Ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testapp.Other.CreateApi;
import com.example.testapp.Model.FiveDays.PostFiveDays;
import com.example.testapp.Other.Constants;
import com.example.testapp.Other.Season;
import com.example.testapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TempFragment extends Fragment {



    public static void setViewNameDays(View view) {

        TextView date = view.findViewById(R.id.date);
        date.setText(Season.date(1));

        TextView date_two = view.findViewById(R.id.date_el_two);
        date_two.setText(Season.date(2));

        TextView date_three = view.findViewById(R.id.date_el_three);
        date_three.setText(Season.date(3));

    }


    public static void getTempFiveDays(View view) {

        CreateApi.getInstance().getApi().getJsonFiveDays(
                "Nizhniy Novgorod",
                "metric",
                Constants.KEY).enqueue(new Callback<PostFiveDays>() {
            @Override
            public void onResponse(Call<PostFiveDays> call, Response<PostFiveDays> response) {


                List<Double> list_firstday = new ArrayList<>();
                List<Double> list_secondday = new ArrayList<>();
                List<Double> list_threeday = new ArrayList<>();

                PostFiveDays posts = response.body();

                long east_time = posts.getCity().getSunrise();
                long west_time = posts.getCity().getSunset();


                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                for (int i = 0; i < posts.getCnt(); i++) {
                    String dateInString = posts.getList().get(i).getDtTxt();
                    double temp = posts.getList().get(i).getMain().getTemp();

                    try {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(Calendar.DATE, 1);
                        int zavtra = calendar.get(Calendar.DAY_OF_MONTH);

                        calendar.add(Calendar.DATE, 1);
                        int polsezavtra = calendar.get(Calendar.DAY_OF_MONTH);

                        calendar.add(Calendar.DATE, 1);
                        int potom = calendar.get(Calendar.DAY_OF_MONTH);

                        Date date = formatter.parse(dateInString);
                        calendar.setTime(date);

                        if (calendar.get(Calendar.DAY_OF_MONTH) == zavtra) {
                            list_firstday.add(temp);
                        }

                        else if (calendar.get(Calendar.DAY_OF_MONTH) == polsezavtra) {
                            list_secondday.add(temp);
                        }

                        else if (calendar.get(Calendar.DAY_OF_MONTH) == potom) {
                            list_threeday.add(temp);
                        }

                    }
                    catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }

                TextView temp_two = view.findViewById(R.id.temp_two);
                temp_two.setText(String.valueOf(Math.round(list_firstday.get(7))) + "°");
                TextView temp_one = view.findViewById(R.id.temp_one);
                temp_one.setText(String.valueOf(Math.round(list_firstday.get(5))) + "°");
                TextView temp_zero = view.findViewById(R.id.temp_zero);
                temp_zero.setText(String.valueOf(Math.round(list_firstday.get(3))) + "°");


                TextView temp_zero_el_two = view.findViewById(R.id.temp_two_el_two);
                temp_zero_el_two.setText(String.valueOf(Math.round(list_secondday.get(7))) + "°");
                TextView temp_one_el_two = view.findViewById(R.id.temp_one_el_two);
                temp_one_el_two.setText(String.valueOf(Math.round(list_secondday.get(6))) + "°");
                TextView temp_two_el_two = view.findViewById(R.id.temp_zero_el_two);
                temp_two_el_two.setText(String.valueOf(Math.round(list_secondday.get(3))) + "°");



                TextView temp_zero_el_three = view.findViewById(R.id.temp_two_el_three);
                temp_zero_el_three.setText(String.valueOf(Math.round(list_threeday.get(7))) + "°");
                TextView temp_one_el_three = view.findViewById(R.id.temp_one_el_three);
                temp_one_el_three.setText(String.valueOf(Math.round(list_threeday.get(6))) + "°");
                TextView temp_two_el_three = view.findViewById(R.id.temp_zero_el_three);
                temp_two_el_three.setText(String.valueOf(Math.round(list_threeday.get(3))) + "°");



            }

            @Override
            public void onFailure(Call<PostFiveDays> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        setViewNameDays(view);
        getTempFiveDays(view);



        return view;
    }
}