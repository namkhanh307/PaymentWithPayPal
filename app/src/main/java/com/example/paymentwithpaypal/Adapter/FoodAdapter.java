package com.example.paymentwithpaypal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;

import com.example.paymentwithpaypal.Models.FoodItem;
import com.example.paymentwithpaypal.R;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<FoodItem> {

    public FoodAdapter(Context context, ArrayList<FoodItem> foodItems) {
        super(context, 0, foodItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_foods, parent, false);
        }

        FoodItem foodItem = getItem(position);

        TextView foodName = convertView.findViewById(R.id.foodName);
        TextView foodDescription = convertView.findViewById(R.id.foodDescription);
        TextView foodPrice = convertView.findViewById(R.id.foodPrice);
        ImageView foodImage = convertView.findViewById(R.id.imgFood);

        if (foodItem != null) {
            foodName.setText(foodItem.getName());
            foodDescription.setText(foodItem.getDescription());
            foodPrice.setText("$" + foodItem.getPrice());
            foodImage.setImageResource(foodItem.getImageResource());
        }

        return convertView;
    }
}
