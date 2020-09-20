package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.cityguide.R;

public class RetailerStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_start);
    }

    public void callloginScreen(View view){
        Intent intent=new Intent(getApplicationContext(),Login.class);

        Pair[] pairs=new Pair[1];

        pairs[0]=new Pair<View,String>(findViewById(R.id.retailer_login_button),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(RetailerStart.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else {
            startActivity(intent);
        }

    }

    public void callsignupScreen(View view){

        Intent intent=new Intent(getApplicationContext(),SignUp.class);

        Pair[] pairs=new Pair[1];

        pairs[0]=new Pair<View,String>(findViewById(R.id.retailer_login_button),"transition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(RetailerStart.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else {
            startActivity(intent);
        }

    }
}
