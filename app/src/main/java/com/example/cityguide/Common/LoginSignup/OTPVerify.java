package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguide.R;

public class OTPVerify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p_verify);
    }

    public void verifyClick (View view){
        startActivity(new Intent(getApplicationContext(),SetNewPassword.class));
        finish();
    }
}
