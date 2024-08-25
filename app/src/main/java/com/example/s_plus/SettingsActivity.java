package com.example.s_plus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    private Button save_button;
    private EditText user_name;

    private ImageView user_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        save_button = (Button ) findViewById(R.id.save_button);
        user_name = (EditText)findViewById(R.id.user_name);
        user_image=(ImageView)findViewById(R.id.user_image);

        //On clicking save button
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_user_name=user_name.getText().toString();
                if(TextUtils.isEmpty(str_user_name))
                {
                    Toast.makeText(SettingsActivity.this,"Please Enter Your Username",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }

            }
        });

    }

}