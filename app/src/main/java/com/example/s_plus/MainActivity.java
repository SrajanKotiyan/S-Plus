package com.example.s_plus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Toolbar main_toolbar;

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_toolbar=(Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);
        getSupportActionBar().setTitle("S-Plus");

        mAuth=FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();
        RootRef = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super. onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.main_search_option:
                break;
            case R.id.main_settings_option:
                SendUserToSettingsActivity();
                break;
            case R.id.main_logout_option:
                mAuth.signOut();
                SendUserToLoginActivity();
                break;
        }
        return true;
    }

    //Move from Main activity to Login activity
    private void SendUserToLoginActivity()
    {
        Intent  login= new Intent(MainActivity.this, LoginActivity.class);
        login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(login);
        finish();
    }

    //Move from Main activity to Settings activity
    private void SendUserToSettingsActivity()
    {
        Intent  settings= new Intent(MainActivity.this, SettingsActivity.class);
        settings.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settings);
        finish();
    }

}