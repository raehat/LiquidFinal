package com.example.liquid.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.HomePage;
import com.example.liquid.Networking.NetworkModels.RegisterModel;
import com.example.liquid.Networking.NetworkUtils;
import com.example.liquid.Networking.networkAPI;
import com.example.liquid.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends AppCompatActivity {

    TextView textViewLogin;
    Button buttonSignUp;
    EditText editTextName, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewLogin = findViewById(R.id.button_login);

        buttonSignUp = findViewById(R.id.sign_up);

        editTextName = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);

        Retrofit retrofit = NetworkUtils.retrofitInstance();

        networkAPI networkAPI = retrofit.create(networkAPI.class);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                RegisterModel registerModel = new RegisterModel(name, email, password);

                Call<String> call = networkAPI.registerAcc(registerModel);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "" + response.code(), Toast.LENGTH_SHORT).show();
                        }
                        String body = response.body();
                        if (body.contains("Registration Successful!")) {
                            SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME",MODE_PRIVATE).edit();
                            editor.putString("email",email);
                            editor.apply();
                            startActivity(new Intent(getApplicationContext(), HomePage.class));
                        }
                        Toast.makeText(getApplicationContext(), "" + body, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}