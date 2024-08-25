package com.example.s_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button login_button, regester_button;
    private EditText login_email, login_password;
    private TextView forgot_password;

    private FirebaseAuth mAuth;

    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_button = findViewById(R.id.login_button);
        regester_button = findViewById(R.id.regester_button);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        forgot_password = findViewById(R.id.forgot_password);

        mAuth = FirebaseAuth.getInstance();

        loadingBar = new ProgressDialog(this);

        //On clicking Regester button
        regester_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendUserToRegesterActivity();
            }
        });

        //On clicking Login button
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    //Move from Login activity to Main Activity
    private void SendUserToMainActivity()
    {
        Intent main = new Intent(LoginActivity.this, MainActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(main);
        finish();
    }

    //Move from Login activity to Regester Activity
    private void SendUserToRegesterActivity()
    {
        Intent regester = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(regester);
    }

}