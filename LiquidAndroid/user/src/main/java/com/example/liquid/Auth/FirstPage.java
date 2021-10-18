package com.example.liquid.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.liquid.R;

public class FirstPage extends AppCompatActivity {

    Button buttonGetStared;
    ImageView imageViewSet;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        buttonGetStared = findViewById(R.id.get_started_button);
        imageViewSet = findViewById(R.id.settings_change_ip);
        editor = getSharedPreferences("MY_SHARED_PREF",MODE_PRIVATE).edit();

        imageViewSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustDialog custDialog = new CustDialog(FirstPage.this);
                custDialog.show();
            }
        });

        buttonGetStared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

    }
}