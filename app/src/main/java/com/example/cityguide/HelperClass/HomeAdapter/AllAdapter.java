package com.example.cityguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.AllCategoryViewHolder> {
    ArrayList<AllHelperClass> mostViewLocation;

    public AllAdapter(ArrayList<AllHelperClass> mostViewLocation) {
        this.mostViewLocation = mostViewLocation;
    }

    @NonNull
    @Override
    public AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card_image, parent, false);
        AllCategoryViewHolder lvh = new AllCategoryViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHolder holder, int position) {
        AllHelperClass helperClass=mostViewLocation.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitle());
        holder.relativeLayout.setBackground(helperClass.getDrawable());

    }

    @Override
    public int getItemCount() {
        return mostViewLocation.size();
    }

    public class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.category_relative);
            imageView=itemView.findViewById(R.id.category_image);
            textView=itemView.findViewById(R.id.category_heading);

        }
    }
}
