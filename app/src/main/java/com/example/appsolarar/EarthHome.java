package com.example.appsolarar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.appsolarar.CategoryFragments.ApolloFragment;
import com.example.appsolarar.CategoryFragments.CitiesFragment;
import com.example.appsolarar.CategoryFragments.ClimateFragment;
import com.example.appsolarar.CategoryFragments.CovidFragment;
import com.example.appsolarar.CategoryFragments.NasaOverView;
import com.example.appsolarar.CategoryFragments.NatureFragment;
import com.example.appsolarar.CategoryFragments.SpaceFragment;
import com.example.appsolarar.CategoryFragments.VoidFragment;
import com.example.appsolarar.CategoryFragments.WondersFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EarthHome extends AppCompatActivity  {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private RecyclerView HorizSerRV;
    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_home);
        viewPager =findViewById(R.id.home_viewPager);
        tabLayout = findViewById(R.id.home_tabL);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        sliderPager=(ViewPager)findViewById(R.id.Slider_Pager);
        lstSlides=new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.earth2));
        lstSlides.add(new Slide(R.drawable.earth_select));
        lstSlides.add(new Slide(R.drawable.earth_sp));
        lstSlides.add(new Slide(R.drawable.moon));
        lstSlides.add(new Slide(R.drawable.gal));
        lstSlides.add(new Slide(R.drawable.sun2));
        lstSlides.add(new Slide(R.drawable.venus1));
        lstSlides.add(new Slide(R.drawable.image6venus3));
        SliderPagerAdapter sliderPagerAdapter=new SliderPagerAdapter(this,lstSlides);
        sliderPager.setAdapter(sliderPagerAdapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new EarthHome.SliderTimer(),1000,2000);
    }
    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            EarthHome.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < lstSlides.size() - 1) {
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem() + 1);
                    } else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NatureFragment(), "Nature");
        adapter.addFragment(new ClimateFragment(), "Climate");
        adapter.addFragment(new WondersFragment(), "Wonders Of World");
        adapter.addFragment(new ApolloFragment(), "Apollo");
        adapter.addFragment(new VoidFragment(), "The void");
        adapter.addFragment(new NasaOverView(), "Nasa Overview");
        adapter.addFragment(new SpaceFragment(), "Space");
        adapter.addFragment(new CitiesFragment(), "Famous Cities");
        viewPager.setAdapter(adapter);
    }
}