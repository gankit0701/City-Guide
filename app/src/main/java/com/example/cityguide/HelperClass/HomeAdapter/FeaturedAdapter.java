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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {


    ArrayList<FeaturedHelperClass> featuredLocation;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout .featured_card_image,parent,false);
        FeaturedViewHolder featuredViewHolder= new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass=featuredLocation.get(position);

        holder.cardImage.setImageResource(featuredHelperClass.getImage());
        holder.cardTitle.setText(featuredHelperClass.getTitle());
        holder.cardDesc.setText(featuredHelperClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }


    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView cardImage;
        TextView cardTitle,cardDesc;


        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage=itemView.findViewById(R.id.card_image);
            cardTitle=itemView.findViewById(R.id.card_title);
            cardDesc=itemView.findViewById(R.id.card_desc);

        }
    }
}
