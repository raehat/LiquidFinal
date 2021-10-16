package com.example.liquid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.liquid.HomePageFragments.Buy;
import com.example.liquid.HomePageFragments.Sell;
import com.example.liquid.HomePageFragments.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new Buy()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.buy_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                            new Buy()).commit();
                        break;
                    case R.id.sell_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                new Sell()).commit();
                        break;
                    case R.id.settings_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                                new Settings()).commit();
                }
                return false;
            }
        });

    }
}