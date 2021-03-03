package com.example.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;





public class RatingListActivity extends AppCompatActivity {
    ArrayList<Restaurant> names;
    RatingAdapter restaurantsAdapter;

    private View.OnClickListener onItemClickListener = view -> {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
        int position = viewHolder.getAdapterPosition();
        int restaurantId = names.get(position).getRestaurantID();
        Intent intent = new Intent(RatingListActivity.this, MainActivity.class);
        intent.putExtra("restrauntId", restaurantId);
        startActivity(intent);
    };

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        RestaurantDataSource ds = new RestaurantDataSource(this);

        String sortBy = getSharedPreferences("MyRestrauntPreferences", Context.MODE_PRIVATE).getString("sortfield", "name");
        String sortOrder = getSharedPreferences("MyRestrauntPreferences", Context.MODE_PRIVATE).getString("sortorder", "ASC");


        try {
            ds.open();
            names = ds.getRestraunts(sortBy, sortOrder);
            RecyclerView restrauntList = findViewById(R.id.rvRestraunts);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            restrauntList.setLayoutManager(layoutManager);
            restaurantsAdapter = new RatingAdapter(names, this);
            restaurantsAdapter.setOnItemClickListener(onItemClickListener);
            restrauntList.setAdapter(restaurantsAdapter);
        }
            catch (Exception e) {
                Toast.makeText(this, "Error retrieving restraunts", Toast.LENGTH_LONG).show();
            }
    }
}
