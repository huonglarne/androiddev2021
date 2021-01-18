package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        addTab(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.intro);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.refresh:
            {
                AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
                    @Override
                    protected Bitmap doInBackground(String... strings) {
                        try {
                            Thread.sleep(1311);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPreExecute() {

                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        Toast.makeText(getApplicationContext(), "here okay?", Toast.LENGTH_LONG).show();
                    }
                };
                task.execute("");
                return true;
            }

            case R.id.setting:
            {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addTab(ViewPager viewPager)
    {
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        vpa.addFragment(new WeatherAndForecastFragment(), "Hanoi");
        vpa.addFragment(new WeatherAndForecastFragment(), "Again Hanoi");
        vpa.addFragment(new WeatherAndForecastFragment(), "Also Hanoi");
        viewPager.setAdapter(vpa);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List mFragmentList = new ArrayList<>();
        private final List mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fman)
        {
            super(fman);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return (Fragment) mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return (CharSequence) mFragmentTitleList.get(position);
        }
    }
}