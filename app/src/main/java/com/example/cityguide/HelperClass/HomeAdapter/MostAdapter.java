package com.example.cityguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class MostAdapter extends RecyclerView.Adapter<MostAdapter.MostViewedViewHolder> {

    ArrayList<MostHelperClass> mostViewedLocations;

    public MostAdapter(ArrayList<MostHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }


    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_card_image, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MostAdapter.MostViewedViewHolder holder, int position) {
        MostHelperClass helperClass = mostViewedLocations.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitle());


    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.most_image);
            textView=itemView.findViewById(R.id.most_title);
        }
    }
}
