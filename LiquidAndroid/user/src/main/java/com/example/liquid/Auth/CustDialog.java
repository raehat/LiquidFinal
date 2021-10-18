package com.example.liquid.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.liquid.R;

public class CustDialog extends Dialog {

EditText editTextip;
Button buttonSubmit;

    public CustDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_dialog);

        editTextip = findViewById(R.id.edit_text_ip);
        buttonSubmit = findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip = editTextip.getText().toString();

                SharedPreferences.Editor editor = getContext().getSharedPreferences("MY_SHARED_PREF",Context.MODE_PRIVATE).edit();
                editor.putString("ip",ip);
                editor.apply();
                dismiss();
            }
        });

    }
}