package com.example.asus.mobilodev1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class intentActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    Button ders;
    TextView isim_al;
    TextView soy_isim_al;
    TextView tc_al;
    TextView tel_al;
    TextView dogum_yeri_al;
    TextView dogum_tarihi_al;
    TextView mail_al;
    ImageView resim_al;
    ImageView imageCall;
    ImageView send_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        this.getSupportActionBar().hide();

        isim_al= findViewById(R.id.ad);
        soy_isim_al= findViewById(R.id.soyad);
        tc_al= findViewById(R.id.tc);
        tel_al= findViewById(R.id.tel);
        dogum_yeri_al = findViewById(R.id.d_yeri);
        dogum_tarihi_al = findViewById(R.id.d_tarihi);
        imageCall = findViewById(R.id.image_call);
        resim_al = findViewById(R.id.resim_yeri);
        mail_al = findViewById(R.id.mail);
        ders = findViewById(R.id.ders);
        send_mail = findViewById(R.id.send_mail);

        ders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),intentActivity2.class);
                startActivity(intent);
            }
        });

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        Intent intent = getIntent();

        String isim = intent.getStringExtra("isim");
        String soy_isim = intent.getStringExtra("soy_isim");
        String tc = intent.getStringExtra("tc");
        String tel = intent.getStringExtra("tel");
        String dogum_yeri = intent.getStringExtra("dogum_yeri");
        String dogum_tarihi = intent.getStringExtra("dogum_tarihi");
        String mail = intent.getStringExtra("mail");
        Bitmap resim = intent.getParcelableExtra("photo");

        resim_al.setImageBitmap(resim);
        isim_al.setText(isim);
        soy_isim_al.setText(soy_isim);
        tc_al.setText(tc);
        tel_al.setText(tel);
        dogum_yeri_al.setText(dogum_yeri);
        dogum_tarihi_al.setText(dogum_tarihi);
        mail_al.setText(mail);
    }
    private void makePhoneCall(){
        String number = tel_al.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission( intentActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(intentActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
            }
        }else{
            Toast.makeText(intentActivity.this,"Bu nasıl telefon numarası?",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendMail(){
       String recipient = mail_al.getText().toString();
       Intent intent = new Intent(Intent.ACTION_SEND);
       intent.putExtra(Intent.EXTRA_EMAIL, recipient);
       intent.setType("message/rfc822");
       startActivity(Intent.createChooser(intent,"Hangi uygulama ile mail göndermek istiyorsunuz?"));
    }
}
