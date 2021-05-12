package com.kwan.midtermasm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kwan.midtermasm2.adapter.AccuWeatherDailyAdapter;
import com.kwan.midtermasm2.adapter.AccuWeatherHourlyAdapter;
import com.kwan.midtermasm2.api.AccuWeatherDailyFiveApi;
import com.kwan.midtermasm2.model.AccuWeatherDailyFive;
import com.kwan.midtermasm2.model.AccuWeatherHourlyTwelve;
import com.kwan.midtermasm2.model.DailyForecast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    AccuWeatherDailyFive data;
    List<AccuWeatherHourlyTwelve> hourlyData;
    List<DailyForecast> dailyData;

    RecyclerView rvAccuWeatherListHourly;
    RecyclerView rvAccuWeatherListDaily;
    AccuWeatherHourlyAdapter accuWeatherHourlyAdapter;
    AccuWeatherDailyAdapter accuWeatherDailyAdapter;
    TextView tvWeatherDescription;
    TextView tvAveTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_hour_list);

        // init text view
        tvWeatherDescription = findViewById(R.id.tvWeatherDescription);
        tvAveTemp = findViewById(R.id.tvAveTemp);

        // get data source
        getData();

        // adapter hourly
        hourlyData = new ArrayList<>();
        accuWeatherHourlyAdapter = new AccuWeatherHourlyAdapter(MainActivity.this, hourlyData);

        // adapter daily
        dailyData = new ArrayList<>();
        accuWeatherDailyAdapter = new AccuWeatherDailyAdapter(MainActivity.this, dailyData);

        // layout manager
        RecyclerView.LayoutManager layoutManagerHourly = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManagerDaily = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        // recycleView hourly
        rvAccuWeatherListHourly = findViewById(R.id.rvAccuWeatherListHourly);
        rvAccuWeatherListHourly.setLayoutManager(layoutManagerHourly);
        rvAccuWeatherListHourly.setAdapter(accuWeatherHourlyAdapter);

        // recycleView daily
        rvAccuWeatherListDaily = findViewById(R.id.rvAccuWeatherListDaily);
        rvAccuWeatherListDaily.setLayoutManager(layoutManagerDaily);
        rvAccuWeatherListDaily.setAdapter(accuWeatherDailyAdapter);
    }

    public void getData() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AccuWeatherDailyFiveApi.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AccuWeatherDailyFiveApi service = retrofit.create(AccuWeatherDailyFiveApi.class);

        service.getAccuWeatherDailyFive().enqueue(new Callback<AccuWeatherDailyFive>() {
            @Override
            public void onResponse(Call<AccuWeatherDailyFive> call, Response<AccuWeatherDailyFive> response) {
                if(response.body() != null) {
                    data = response.body();
                    accuWeatherDailyAdapter.reloadData(data.getDailyForecasts());
                }
            }

            @Override
            public void onFailure(Call<AccuWeatherDailyFive> call, Throwable t) {
                Log.d("WEATHER", "onFailure: " + t);
            }
        });

        service.getAccuWeatherHourlyTweleve().enqueue(new Callback<List<AccuWeatherHourlyTwelve>>() {
            @Override
            public void onResponse(Call<List<AccuWeatherHourlyTwelve>> call, Response<List<AccuWeatherHourlyTwelve>> response) {
                if(response.body() != null) {
                    hourlyData = response.body();

                    tvWeatherDescription.setText(hourlyData.get(0).getIconPhrase());

                    // set average temp
                    float ave = 0;
                    for(AccuWeatherHourlyTwelve accuWeatherHourlyTwelve: hourlyData) {
                        ave += accuWeatherHourlyTwelve.getTemperature().getValue()/hourlyData.size();
                    }

                    DecimalFormat df = new DecimalFormat("#.#");

                    tvAveTemp.setText(String.valueOf(df.format(ave)) + "°");

                    accuWeatherHourlyAdapter.reloadData(hourlyData);
                }
            }

            @Override
            public void onFailure(Call<List<AccuWeatherHourlyTwelve>> call, Throwable t) {
                Log.d("WEATHER", "onFailure: " + t);
            }
        });
    }
}