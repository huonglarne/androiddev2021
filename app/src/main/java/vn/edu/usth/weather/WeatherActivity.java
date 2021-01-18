package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("here", "create");

        ForecastFragment ff = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.forecast_frag, ff, null).commit();

        WeatherFragment wf = new WeatherFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.weather_frag, wf, null).commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("here", "start");
    }

    protected void onResume() {
        super.onResume();
        Log.i("here", "resume");
    }

    protected void onPause() {
        super.onPause();
        Log.i("here", "pause");
    }

    protected void onStop() {
        super.onStop();
        Log.i("here", "stop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("here", "destroy");
    }
}