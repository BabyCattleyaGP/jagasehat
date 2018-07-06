package com.example.baby.jagasehat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FirstRun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            // show FormActivity
            Intent intent = new Intent(FirstRun.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            startActivity(new Intent(FirstRun.this, SplashActivity.class));
            finish();
        }
    }
}