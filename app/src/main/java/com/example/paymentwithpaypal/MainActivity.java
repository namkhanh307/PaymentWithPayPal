package com.example.paymentwithpaypal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnDrinks = findViewById(R.id.btnDrinks);
        Button btnFood = findViewById(R.id.btnFood);
        Button btnCart = findViewById(R.id.btnCart);

        btnDrinks.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DrinksActivity.class)));
        btnFood.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FoodActivity.class)));
        btnCart.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }
}