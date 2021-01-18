package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.util.Log;

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