package com.example.asus.mobilodev1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    EditText isim;
    EditText soy_isim;
    EditText tc;
    EditText tel;
    EditText dogum_yeri;
    EditText dogum_tarihi;
    EditText mail;
    Button resim_ekle;
    ImageView imageView;
    Uri imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        imageView = findViewById(R.id.resim);
        resim_ekle = findViewById(R.id.resim_ekle);
        isim = findViewById(R.id.ad);
        soy_isim = findViewById(R.id.soyad);
        tc = findViewById(R.id.tc);
        tel = findViewById(R.id.tel);
        dogum_yeri = findViewById(R.id.d_yeri);
        dogum_tarihi = findViewById(R.id.d_tarihi);
        mail = findViewById(R.id.mail);
        resim_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override       // onActivityResult ONEMLİ BUNUN NELER ALDIĞINI NE YAPTIĞINI BİL
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUrl = data.getData();
            imageView.setImageURI(imageUrl);
        }
    }

    public void gonder(View view) {
        Intent intent = new Intent(this,intentActivity.class);
        intent.putExtra("isim",isim.getText().toString());
        intent.putExtra("soy_isim",soy_isim.getText().toString());
        intent.putExtra("tc",tc.getText().toString());
        intent.putExtra("tel",tel.getText().toString());
        intent.putExtra("dogum_yeri",dogum_yeri.getText().toString());
        intent.putExtra("dogum_tarihi",dogum_tarihi.getText().toString());
        intent.putExtra("mail",mail.getText().toString());
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap image = imageView.getDrawingCache();
        intent.putExtra("photo",image);
        startActivity(intent);
        // INTENT TIPLERİ PENDİNG, EXCLUSİVE FALAN
        // VIEWS RECYCLER VIEW, CARD VIEW
        //ınflater
    }

    public void temizle(View view) {
        isim.setText("");
        soy_isim.setText("");
        tc.setText("");
        tel.setText("");
        dogum_yeri.setText("");
        dogum_tarihi.setText("");
        mail.setText("");
    }
}
