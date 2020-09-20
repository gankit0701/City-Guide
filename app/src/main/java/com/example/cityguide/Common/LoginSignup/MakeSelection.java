package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class MakeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }
    public void msgClick(View view){
        startActivity(new Intent(getApplicationContext(),OTPVerify.class));
        finish();
    }
}
