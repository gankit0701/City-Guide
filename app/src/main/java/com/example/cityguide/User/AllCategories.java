package com.example.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cityguide.R;

public class AllCategories extends AppCompatActivity {
    ImageView backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        backButton=findViewById(R.id.back_button_categories);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllCategories.super.onBackPressed();
            }
        });

    }
}
