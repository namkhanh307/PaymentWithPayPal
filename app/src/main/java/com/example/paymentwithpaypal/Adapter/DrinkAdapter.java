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

import com.example.paymentwithpaypal.Models.DrinkItem;
import com.example.paymentwithpaypal.R;

import java.util.ArrayList;
public class DrinkAdapter extends ArrayAdapter<DrinkItem> {

    public DrinkAdapter(Context context, ArrayList<DrinkItem> drinkItems) {
        super(context, 0, drinkItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_drinks, parent, false);
        }

        DrinkItem drinkItem = getItem(position);

        TextView drinkName = convertView.findViewById(R.id.drinkName);
        TextView drinkDescription = convertView.findViewById(R.id.drinkDescription);
        TextView drinkPrice = convertView.findViewById(R.id.drinkPrice);
        ImageView drinkImage = convertView.findViewById(R.id.drinkImage);

        if (drinkName == null || drinkDescription == null || drinkPrice == null || drinkImage == null) {
            throw new IllegalStateException("Missing views in item_drink layout");
        }

        if (drinkItem != null) {
            drinkName.setText(drinkItem.getName());
            drinkDescription.setText(drinkItem.getDescription());
            drinkPrice.setText("$" + drinkItem.getPrice());
            drinkImage.setImageResource(drinkItem.getImageResource());
        }

        return convertView;
    }
}


