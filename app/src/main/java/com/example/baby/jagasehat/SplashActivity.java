package com.example.baby.jagasehat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SplashActivity extends AppCompatActivity {

    Button btnNext;

    RelativeLayout rellay1;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

        btnNext = (Button)findViewById(R.id.btnGo);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,MainActivitySecond.class));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }

}
