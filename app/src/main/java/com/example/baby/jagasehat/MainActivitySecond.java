
package com.example.baby.jagasehat;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.content.Intent;
    import android.view.View;
    import android.widget.LinearLayout;


public class MainActivitySecond extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout hal1,hal2,hal3,hal4,kontak;
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