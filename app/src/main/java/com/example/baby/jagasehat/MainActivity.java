package com.example.baby.jagasehat;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText age,mail;
    Spinner jk,tp,job;
    Button btnAdd;

    DatabaseReference databaseData;

    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseData = FirebaseDatabase.getInstance().getReference("user");

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

        age = (EditText)findViewById(R.id.usia);
        job = (Spinner) findViewById(R.id.kerja);
        mail = (EditText)findViewById(R.id.email);

        jk = (Spinner)findViewById(R.id.jk);
        tp = (Spinner)findViewById(R.id.tp);

        btnAdd = (Button) findViewById(R.id.btnadd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });

    }

    private void addData(){
        String usia = age.getText().toString().trim();
        String gender = jk.getSelectedItem().toString();
        String education = tp.getSelectedItem().toString();
        String kerja = job.getSelectedItem().toString();
        String email = mail.getText().toString().trim();

        if(!TextUtils.isEmpty(usia)&&!TextUtils.isEmpty(gender)&& !TextUtils.isEmpty(education)&& !TextUtils.isEmpty(kerja)&&!TextUtils.isEmpty(email)){
            String id = databaseData.push().getKey();
            Data user = new Data(id,gender,usia,education,kerja,email);
            databaseData.child(id).setValue(user);

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();

            Toast.makeText(this, "Data Telah Masuk", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,MainActivitySecond.class));
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            finish();

        }else {
            Toast.makeText(this, "Data Tidak Lengkap", Toast.LENGTH_LONG).show();
        }
    }
}
