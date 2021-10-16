package com.example.liquid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Appearance extends AppCompatActivity {

    RadioGroup radioGroupThemeChanger;
    RadioButton radioButtonSysDefault, radioButtonLightMode, radioButtonDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences.Editor editor = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE).edit();

        radioGroupThemeChanger = findViewById(R.id.radio_group_theme_changer);
        radioButtonSysDefault = findViewById(R.id.rb_sys_def);
        radioButtonLightMode = findViewById(R.id.rb_light_mode);
        radioButtonDarkMode = findViewById(R.id.rb_dark_mode);

        String themeChosen = getSharedPreferences("Appearance_shared_pref", MODE_PRIVATE)
                .getString("theme", "sys_def");
        radioButtonSysDefault.setChecked(true);
        if (themeChosen.equals("light"))
            radioButtonLightMode.setChecked(true);
        else if (themeChosen.equals("dark"))
            radioButtonDarkMode.setChecked(true);

        radioGroupThemeChanger.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_sys_def){
                    radioButtonSysDefault.setChecked(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    editor.putString("theme", "sys_def");
                    editor.apply();
                }
                else if (checkedId == R.id.rb_light_mode){
                    radioButtonLightMode.setChecked(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putString("theme", "light");
                    editor.apply();
                }
                else if (checkedId == R.id.rb_dark_mode){
                    radioButtonDarkMode.setChecked(true);
                    editor.putString("theme", "dark");
                    editor.apply();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });

    }
}