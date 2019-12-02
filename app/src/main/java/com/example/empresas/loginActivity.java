package com.example.empresas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    private TextView tvEmail, tvPassword;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPassword = (TextView) findViewById(R.id.tvPassword);



    }
}
