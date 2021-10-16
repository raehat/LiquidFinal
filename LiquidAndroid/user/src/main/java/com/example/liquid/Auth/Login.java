package com.example.liquid.Auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liquid.Networking.NetworkModels.LoginModel;
import com.example.liquid.Networking.NetworkUtils;
import com.example.liquid.Networking.networkAPI;
import com.example.liquid.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);

        buttonLogin = findViewById(R.id.button_login);

        Retrofit retrofit = NetworkUtils.retrofitInstance();

        networkAPI networkAPI = retrofit.create(com.example.liquid.Networking.networkAPI.class);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                LoginModel loginModel = new LoginModel(email,password);

                Call<String> call = networkAPI.loginAcc(loginModel);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "response code: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getApplicationContext(), "" + response.body(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "exception: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}