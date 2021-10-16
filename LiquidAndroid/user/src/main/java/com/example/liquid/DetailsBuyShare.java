package com.example.liquid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailsBuyShare extends AppCompatActivity {

    Button buttonBuyOrSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_buy_share);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String buyOrSell = getIntent().getExtras().getString("BuyOrSell");
        Toast.makeText(this, "" + buyOrSell, Toast.LENGTH_SHORT).show();

        buttonBuyOrSell = findViewById(R.id.button_buy_now);

        if (getIntent().getExtras().getString("BuyOrSell").equals("1")) {
            buttonBuyOrSell.setText("SELL NOW");
        }

        buttonBuyOrSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyOrSell.equals("0")) {
                    buyFunc();
                } else {
                    sellFunc();
                }
            }
        });
    }

    private void sellFunc() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("ARE YOU SURE?")
                .setMessage("Do you want to sell this share?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("No", null).show();
    }

    private void buyFunc() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("ARE YOU SURE?")
                .setMessage("Do you want to buy this share?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setNegativeButton("No", null).show();
    }
}