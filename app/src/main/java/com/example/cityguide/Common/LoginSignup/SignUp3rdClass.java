package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;

public class SignUp3rdClass extends AppCompatActivity {

    ImageView backButton;
    Button next,login;
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);

        //Hooks
        backButton=findViewById(R.id.signup_back_button);
        next=findViewById(R.id.signup_next_button);
        login=findViewById(R.id.signup_login_button);
        titleText=findViewById(R.id.signup_title_text);
    }

    public void signupnextcall(View view){
        Intent intent=new Intent(getApplicationContext(),OTPVerify.class);

        //Add trasition

        Pair[] pairs=new  Pair[4];

        pairs[0]=new Pair<View,String>(backButton,"transition_back_arrow_btn");
        pairs[1]=new Pair<View,String>(next,"transition_next_btn");
        pairs[2]=new Pair<View,String>(login,"transition_login_btn");
        pairs[3]=new Pair<View,String>(titleText,"transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this,pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }

    }
}
