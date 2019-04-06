package com.example.asus.mobilodev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class girisSayfasi extends AppCompatActivity {
    EditText password;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_sayfasi);
        this.getSupportActionBar().hide();
        password = findViewById(R.id.password);
        id = findViewById(R.id.id);
    }

    public void giris(View view) {
        if (id.getText().toString().equals("admin") && password.getText().toString().equals("password")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Kullanıcı adı ya da şifre hatalı!",Toast.LENGTH_SHORT).show();
            id.setText("");
            password.setText("");
        }
    }
}
