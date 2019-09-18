package com.example.weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Common.Common;
import com.example.weather.Model.WeatherForecastResults;
import com.example.weather.R;
import com.squareup.picasso.Picasso;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder> {

    Context context;
    WeatherForecastResults weatherForecastResults;

    public WeatherForecastAdapter(Context context, WeatherForecastResults weatherForecastResults) {
        this.context = context;
        this.weatherForecastResults = weatherForecastResults;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/wn/")
                .append(weatherForecastResults.list.get(position).weather.get(0).getIcon()).append(".png").toString()).into(holder.img_weather);

        holder.txt_date.setText(new StringBuilder(Common.convertUnixToDate(weatherForecastResults.list.get(position).dt)));
        holder.txt_description.setText(new StringBuilder(weatherForecastResults.list.get(position).weather.get(0).getDescription()));
        holder.txt_temp.setText(new StringBuilder(String.valueOf(weatherForecastResults.list.get(position).main.getTemp())).append(" °C"));

    }

    @Override
    public int getItemCount() {
        return weatherForecastResults.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_date, txt_description, txt_temp;
        ImageView img_weather;
        public MyViewHolder (View itemView) {
            super(itemView);

            img_weather = (ImageView) itemView.findViewById(R.id.img_weather);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_description = (TextView) itemView.findViewById(R.id.txt_description);
            txt_temp = (TextView) itemView.findViewById(R.id.txt_temp);


        }

    }
}
