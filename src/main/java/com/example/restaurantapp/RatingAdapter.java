package com.example.restaurantapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RatingAdapter extends RecyclerView.Adapter {
    private ArrayList<String> RaitingData;

    public RatingAdapter(ArrayList<Restaurant> names, RatingListActivity ratingListActivity) {
    }

    private View.OnClickListener mOnClickListener;

    public class RatingViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewRestraunt;
        public TextView textViewRestrauntName;
        public View rating;

        public RatingViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRestrauntName = itemView.findViewById(R.id.restaurantName);
            textViewRestraunt = itemView.findViewById(R.id.mealName);
            rating = itemView.findViewById(R.id.mealRating);
            itemView.setOnClickListener(mOnClickListener);
        }

        public TextView getRestrauntTextView() {
            return textViewRestraunt;
        }
    }

    public RatingAdapter (ArrayList<String> arrayList) {
        RaitingData = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RatingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RatingViewHolder rvh = (RatingViewHolder) holder;
        rvh.getRestrauntTextView().setText(RaitingData.get(position));
    }

    @Override
    public int getItemCount() {
        return RaitingData.size();
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener){
       mOnClickListener = itemClickListener;
    }

}
