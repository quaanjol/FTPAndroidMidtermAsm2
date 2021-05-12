package com.kwan.midtermasm2.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kwan.midtermasm2.R;
import com.kwan.midtermasm2.model.AccuWeatherHourlyTwelve;
import com.kwan.midtermasm2.model.DailyForecast;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccuWeatherDailyAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<DailyForecast> list;

    public AccuWeatherDailyAdapter(Activity activity, List<DailyForecast> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<DailyForecast> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.weather_daily, parent, false);
        AccuWeatherDailyAdapter.AccuWeatherDailyHolder holder = new AccuWeatherDailyAdapter.AccuWeatherDailyHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AccuWeatherDailyAdapter.AccuWeatherDailyHolder hd = (AccuWeatherDailyAdapter.AccuWeatherDailyHolder) holder;
        DailyForecast model = list.get(position);
        hd.tvDateDaily.setText(convertTime(model.getDate()));

        DecimalFormat df = new DecimalFormat("#.#");
        hd.tvTempDay.setText(String.valueOf(df.format(model.getTemperature().getMaximum().getValue())));
        hd.tvTempNight.setText(String.valueOf(df.format(model.getTemperature().getMinimum().getValue())));
        if(model.getDay().getIconPhrase().toLowerCase().contains("nắng")) {
            Glide.with(activity).load("https://i.imgur.com/om38P0E.png").into(hd.ivIconDaily);
        } else if(model.getDay().getIconPhrase().toLowerCase().contains("mây")) {
            Glide.with(activity).load("https://i.imgur.com/oBhIIgx.png").into(hd.ivIconDaily);
        } else if(model.getDay().getIconPhrase().toLowerCase().contains("mưa")) {
            Glide.with(activity).load("https://i.imgur.com/5EDbRn8.png").into(hd.ivIconDaily);
        } else {
            Glide.with(activity).load("https://i.imgur.com/om38P0E.png").into(hd.ivIconDaily);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AccuWeatherDailyHolder extends RecyclerView.ViewHolder {
        TextView tvDateDaily, tvTempDay, tvTempNight;
        ImageView ivIconDaily;

        public AccuWeatherDailyHolder(@NonNull View itemView) {
            super(itemView);
            tvDateDaily = itemView.findViewById(R.id.tvDateDaily);
            tvTempDay = itemView.findViewById(R.id.tvTempDay);
            tvTempNight = itemView.findViewById(R.id.tvTempNight);
            ivIconDaily = itemView.findViewById(R.id.ivIconDaily);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String goal = outFormat.format(date);
        return goal;
    }
}
