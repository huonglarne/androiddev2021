package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("here", "create");

        ForecastFragment fragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_weather);
        Log.i("here", "start");
    }

    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_weather);
        Log.i("here", "resume");
    }

    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_weather);
        Log.i("here", "pause");
    }

    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_weather);
        Log.i("here", "stop");
    }

    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_weather);
        Log.i("here", "destroy");
    }
}