package com.example.paymentwithpaypal.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.paymentwithpaypal.Models.CartItem;
import com.example.paymentwithpaypal.R;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CartItem> cartItems;

    public CartAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        }

        CartItem item = cartItems.get(position);

        ImageView image = convertView.findViewById(R.id.cartItemImage);
        TextView name = convertView.findViewById(R.id.cartItemName);
        TextView price = convertView.findViewById(R.id.cartItemPrice);
        TextView quantity = convertView.findViewById(R.id.cartItemQuantity);
        TextView category = convertView.findViewById(R.id.cartItemCategory);
        Button removeButton = convertView.findViewById(R.id.removeFromCartButton);

        image.setImageResource(item.getImageResource());
        name.setText(item.getName());
        price.setText("$" + item.getPrice());
        quantity.setText("Quantity: " + item.getQuantity());
        category.setText("Category: " + item.getCategory());

        removeButton.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
