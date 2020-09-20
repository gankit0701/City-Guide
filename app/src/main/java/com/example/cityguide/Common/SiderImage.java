package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguide.HelperClass.ImageHelper;
import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class SiderImage extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLinear;

    ImageHelper imageHelper;
    TextView[] dots;
    Button letsStarted;
    Animation animation;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sider_image);

        //Hooks
        viewPager = findViewById(R.id.slider_image);
        dotsLinear = findViewById(R.id.dots);
        letsStarted = findViewById(R.id.getStarted_button);

        //Call Adapter

        imageHelper = new ImageHelper(this);

        viewPager.setAdapter(imageHelper);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }

    private void addDots(int position) {
        dots = new TextView[5];
        dotsLinear.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLinear.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public void skipClick(View view){
        Intent intent=new Intent(this, UserDashboard.class);
        startActivity(intent);
        finish();

    }

    public void nextClick(View view){

        viewPager.setCurrentItem(currentPosition+1);


    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition=position;
            if (position == 0) {
                letsStarted.setVisibility(View.INVISIBLE);

            } else if (position == 1) {
                letsStarted.setVisibility(View.INVISIBLE);

            } else if (position == 2) {
                letsStarted.setVisibility(View.INVISIBLE);

            } else if (position == 3) {
                letsStarted.setVisibility(View.INVISIBLE);

            } else {
                animation= AnimationUtils.loadAnimation(SiderImage.this,R.anim.side_anim);
                letsStarted.setAnimation(animation);
                letsStarted.setVisibility(View.VISIBLE);


            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
