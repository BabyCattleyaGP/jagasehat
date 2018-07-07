package com.example.baby.jagasehat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wenchao.cardstack.CardStack;

import static android.app.Activity.*;

/**
 * Created by FZulfikar on 6/2/2018.
 */

public class Page1 extends AppCompatActivity implements CardStack.CardEventListener {

    private CardStack card_stack;
    private CardAdapter card_adapter;

    ImageView finishButton;
    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        initImages();

        card_stack = (CardStack)findViewById(R.id.card_stack);
        card_stack.setContentResource(R.layout.card_layout);
        card_stack.setStackMargin(20);
        card_stack.setAdapter(card_adapter);

        card_stack.setListener(this);

        finishButton = (ImageView) findViewById(R.id.finish_chapter);

        finishButton.setVisibility(View.VISIBLE); //OR Gone

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("daftarFirstRun", false).apply();

    }

    public void finish_chapter(View view) {

        Intent intent = new Intent(Page1.this, Notif.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Page1.this, REQUEST_CODE, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//            alarmManager.set(alarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        // Change the intervalMillis to AlarmManager.INTERVAL_DAY*7 before publish
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_DAY * 7, pendingIntent);


        finish(); // Close the Activity
        overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_down); // Override transition animation
    }

    private void initImages(){
        card_adapter = new CardAdapter(getApplicationContext(),0);
        card_adapter.add(R.drawable.capture);
        card_adapter.add(R.drawable.frontelephant);
        card_adapter.add(R.drawable.frontbird);
        card_adapter.add(R.drawable.card_bird);
        card_adapter.add(R.drawable.card_tree);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Page1.this, Notif.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Page1.this, REQUEST_CODE, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // Change the intervalMillis to AlarmManager.INTERVAL_DAY*7 before publish
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_DAY * 7, pendingIntent);

        super.onBackPressed();
        overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_down);
    }

    @Override
    public boolean swipeEnd(int i, float v) {
        return (v>300)?true:false;
    }

    @Override
    public boolean swipeStart(int i, float v) {
        return false;
    }

    @Override
    public boolean swipeContinue(int i, float v, float v1) {
        return false;
    }

    @Override
    public void discarded(int i, int i1) {

    }

    @Override
    public void topCardTapped() {

    }
}
