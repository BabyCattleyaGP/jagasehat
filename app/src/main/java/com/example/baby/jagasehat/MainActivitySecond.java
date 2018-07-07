package com.example.baby.jagasehat;

    import android.app.AlarmManager;
    import android.app.PendingIntent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.content.Intent;
    import android.view.View;
    import android.widget.LinearLayout;

    import com.getkeepsafe.taptargetview.TapTarget;
    import com.getkeepsafe.taptargetview.TapTargetView;

public class MainActivitySecond extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout hal1,hal2,hal3,hal4,kontak;
    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsecond);

        hal1 = (LinearLayout) findViewById(R.id.page1);
        hal2 = (LinearLayout) findViewById(R.id.page2);
        hal3 = (LinearLayout) findViewById(R.id.page3);
        hal4 = (LinearLayout) findViewById(R.id.page4);
        kontak = (LinearLayout) findViewById(R.id.contact);

        hal1.setOnClickListener(this);
        hal2.setOnClickListener(this);
        hal3.setOnClickListener(this);
        hal4.setOnClickListener(this);
        kontak.setOnClickListener(this);

        Boolean daftarFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("daftarFirstRun", true);

        if (daftarFirstRun) {
            TapTargetView.showFor(MainActivitySecond.this,
                    TapTarget.forView(findViewById(R.id.page1), "Yuk Mulai Bagian 1")
                            .outerCircleColor(R.color.colorPrimary)
                            .transparentTarget(true)
                            .textColor(R.color.black)
                            .cancelable(false),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);
                            startActivity(new Intent(MainActivitySecond.this,Page1.class));
                            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                        }
                    });
        }

    }


    @Override
    public void onDestroy() {
        Intent intent = new Intent(MainActivitySecond.this, Notif.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivitySecond.this, REQUEST_CODE, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // Change the intervalMillis to AlarmManager.INTERVAL_DAY*7 before publish
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), AlarmManager.INTERVAL_DAY * 7, pendingIntent);
    }

    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.page1 : startActivity(new Intent(MainActivitySecond.this,Page1.class));
                                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                                break;
            case R.id.page2 : startActivity(new Intent(MainActivitySecond.this,Page2.class));
                                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                                break;
            case R.id.page3 : startActivity(new Intent(MainActivitySecond.this,Page3.class));
                                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                                break;
            case R.id.page4 : startActivity(new Intent(MainActivitySecond.this,Page4.class));
                                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                                break;
            case R.id.contact : startActivity(new Intent(MainActivitySecond.this,Contact.class));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                                break;

            default:break;
        }
    }

}