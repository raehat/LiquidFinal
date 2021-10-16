package com.example.admin;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.admin.HomePageFragments.AddDaysRange;
import com.example.admin.HomePageFragments.Analysis;
import com.example.admin.HomePageFragments.AddCompany;
import com.example.admin.HomePageFragments.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new Analysis()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_analysis:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                            new Analysis()).commit();
                        break;
                    case R.id.item_company:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                new AddCompany()).commit();
                        break;
                    case R.id.item_settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                new Settings()).commit();
                    case R.id.item_days_range:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                new AddDaysRange()).commit();
                }
                return false;
            }
        });

    }
}