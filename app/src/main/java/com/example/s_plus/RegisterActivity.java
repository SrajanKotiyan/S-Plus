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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

     private Button regester_button;
      private EditText regester_email,regester_password;
     private TextView already_have_account;

     private FirebaseAuth mAuth;
     private DatabaseReference RootRef;

     private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regester_button = findViewById(R.id.regester_button);
        regester_email = findViewById(R.id.regester_email);
        regester_password = findViewById(R.id.regester_password);
        already_have_account = findViewById(R.id.already_have_account);

        mAuth = FirebaseAuth.getInstance();
        RootRef = FirebaseDatabase.getInstance().getReference();

        loadingBar = new ProgressDialog(this);

        //Clicking already have an account
        already_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendUserToLoginActivity();
            }
        });

        //On clicking register button
        regester_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    //Moving from Register activity to Login activity
    private void SendUserToLoginActivity()
    {
        Intent  login= new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(login);
    }

    //Moving from Register activity to Main activity
    private void SendUserToMainActivity()
    {
        Intent main = new Intent(RegisterActivity.this, MainActivity.class);
        main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(main);
        finish();
    }

}

