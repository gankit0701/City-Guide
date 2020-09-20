package com.example.cityguide.HelperClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cityguide.R;

public class ImageHelper extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ImageHelper(Context context) {
        this.context = context;
    }

    int image[]= {R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5};

    int heading[]= {R.string.image_heading_1,R.string.image_heading_2,R.string.image_heading_3,R.string.image_heading_4,R.string.image_heading_5};

    int desc[]= {R.string.image_desc_1,R.string.image_desc_2,R.string.image_desc_3,R.string.image_desc_4,R.string.image_desc_5};

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


        return view== (ConstraintLayout) object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView imageView=view.findViewById(R.id.sliderimage);
        TextView heading_image=view.findViewById(R.id.slider_heading);
        TextView desc_image=view.findViewById(R.id.slider_desc);

        imageView.setImageResource(image[position]);
        heading_image.setText(heading[position]);
        desc_image.setText(desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);

    }
}
