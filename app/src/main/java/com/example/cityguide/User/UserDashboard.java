package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguide.Common.LoginSignup.RetailerStart;
import com.example.cityguide.HelperClass.HomeAdapter.AllAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.AllHelperClass;
import com.example.cityguide.HelperClass.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClass.HomeAdapter.MostAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.MostHelperClass;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featuredRecycler,mostViewRecycler,categoryRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menu_icon;
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        mostViewRecycler=findViewById(R.id.mostview_recycler);
        categoryRecycler=findViewById(R.id.allview_recycler);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view_drawer);
        menu_icon=findViewById(R.id.menu_side_button);
        contentView=findViewById(R.id.content_linear);
        

        //Navigation Drawer

        
        navigationDrawer();


        featuredRecycler();
        mostViewedRecycler();
        categoryRecycler();



    }

    //Navigation Drawer

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home_menu);

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
       // drawerLayout.setScrimColor(getResources().getColor(R.color.orange));

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.all_categories_menu:
                Intent intent=new Intent(getApplicationContext(),AllCategories.class);
                startActivity(intent);
                break;
        }
        return true;

    }





    private void categoryRecycler() {
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<AllHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new AllHelperClass(R.drawable.image_1, "Education",gradient1));
        categoriesHelperClasses.add(new AllHelperClass(R.drawable.image_2, "Education",gradient2));
        categoriesHelperClasses.add(new AllHelperClass(R.drawable.image_3, "Education",gradient3));
        categoriesHelperClasses.add(new AllHelperClass(R.drawable.image_4, "Education",gradient4));


        categoryRecycler.setHasFixedSize(true);
        adapter = new AllAdapter(categoriesHelperClasses);
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryRecycler.setAdapter(adapter);


    }

    private void mostViewedRecycler() {

        mostViewRecycler.setHasFixedSize(true);
        mostViewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostHelperClass(R.drawable.image_1, "McDonald's"));
        mostViewedLocations.add(new MostHelperClass(R.drawable.image_2, "Edenrobe"));
        mostViewedLocations.add(new MostHelperClass(R.drawable.image_3, "J."));
        mostViewedLocations.add(new MostHelperClass(R.drawable.image_4, "Walmart"));

        adapter = new MostAdapter(mostViewedLocations);
        mostViewRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocation=new ArrayList<>();

        featuredLocation.add(new FeaturedHelperClass(R.drawable.image_1,"Taj Hotel","bhkbdhsadahdkjasdjkgdasd"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.image_2,"Taj Mahal","bhkbdhsadahdkjasdjkgdasd"));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.image_3,"Buddha","bhkbdhsadahdkjasdjkgdasd"));

        adapter= new FeaturedAdapter(featuredLocation);

        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradientDrawable=new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0x00ffeff400,0xffaff600});


    }


    //Retailer Screen

    public void retailerScreen(View view){
        startActivity(new Intent(getApplicationContext(), RetailerStart.class));
    }


}
