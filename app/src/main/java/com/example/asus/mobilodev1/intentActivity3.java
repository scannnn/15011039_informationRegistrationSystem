package com.example.asus.mobilodev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class intentActivity3 extends AppCompatActivity {

    TextView ders_adi;
    TextView ders_notu;
    TextView dersi_alan_kisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent3);

        this.getSupportActionBar().hide();

        ders_adi = findViewById(R.id.ders_adi);
        ders_notu = findViewById(R.id.ders_notu);
        dersi_alan_kisi = findViewById(R.id.dersi_alan_kisi);

        Intent intent = getIntent();
        String ders_ad = intent.getStringExtra("course_name");
        String ders_not = intent.getStringExtra("grade");
        String ders_alan_kisi = intent.getStringExtra("number_of_student");

        ders_adi.setText(ders_ad);
        ders_notu.setText(ders_not);
        dersi_alan_kisi.setText(ders_alan_kisi);

    }
}
