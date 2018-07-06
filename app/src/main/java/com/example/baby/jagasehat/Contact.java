package com.example.baby.jagasehat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by FZulfikar on 6/2/2018.
 */

public class Contact extends AppCompatActivity {
    ImageView img_share, img_call, img_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        img_call = (ImageView) findViewById(R.id.imageButton3);
        img_share = (ImageView) findViewById(R.id.imageButton4);
        img_menu = (ImageView) findViewById(R.id.imageButton5);


        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Saya menggunakan JagaSehat");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "Ayo gunakan aplikasi JagaSehat:http://github.com/BabyCattleyaGP/JagaSehat");
                startActivity(Intent.createChooser(i,"Bagikan"));

            }
        });

        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Contact.this,MainActivitySecond.class));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });

        img_call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:911"));

                if (ActivityCompat.checkSelfPermission(Contact.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

    }
}
