package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Animation sideAnim;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);

        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);

        imageView.setAnimation(sideAnim);
        textView.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirst= onBoardingScreen.getBoolean("firstTime",true);

                if (isFirst) {
                    SharedPreferences.Editor editor=onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), SiderImage.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent =new Intent(getApplicationContext(), UserDashboard.class);
                    startActivity(intent);
                    finish();

                }

            }
        },1500);


    }
}
