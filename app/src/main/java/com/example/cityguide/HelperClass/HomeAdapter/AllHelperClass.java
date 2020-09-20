package com.example.cityguide.HelperClass.HomeAdapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;

public class AllHelperClass {
    int image;
    String title;
    RelativeLayout relativeLayout;
    GradientDrawable drawable;


    public AllHelperClass(int image, String title) {
        this.image = image;
        this.title = title;

    }

    public AllHelperClass(int image, String title,  GradientDrawable drawable) {
        this.image = image;
        this.title = title;
        this.drawable = drawable;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public GradientDrawable getDrawable() {
        return drawable;
    }
}
