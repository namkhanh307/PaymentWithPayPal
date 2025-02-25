package com.example.paymentwithpaypal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkDetailActivity extends AppCompatActivity {

    private TextView drinkName, drinkDescription, drinkPrice, tvQuantity;
    private ImageView drinkImage; // Changed from int to ImageView
    private Button btnMinus, btnPlus, btnAddToCart;
    private int quantity = 1;
    private double pricePerItem;
    private int imageResource; // Added to store image resource ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_drinks_details);

        drinkName = findViewById(R.id.drinkNameDetail);
        drinkDescription = findViewById(R.id.drinkDescriptionDetail);
        drinkPrice = findViewById(R.id.drinkPriceDetail);
        drinkImage = findViewById(R.id.drinkImage); // Fixed to ImageView
        tvQuantity = findViewById(R.id.drinkQuantity);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        // Get data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            drinkName.setText(extras.getString("drinkName"));
            drinkDescription.setText(extras.getString("drinkDescription"));
            pricePerItem = extras.getDouble("drinkPrice");
            imageResource = extras.getInt("drinkImage"); // Store image resource ID
            drinkImage.setImageResource(imageResource); // Set image
            drinkPrice.setText("Price: " + pricePerItem * quantity + " VNĐ");
        }

        // Increase quantity
        btnPlus.setOnClickListener(v -> {
            quantity++;
            updatePrice();
        });

        // Decrease quantity
        btnMinus.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                updatePrice();
            }
        });

        // Add to Cart
        btnAddToCart.setOnClickListener(v -> {
            CartManager.getInstance().addToCart(
                    drinkName.getText().toString(), // Fixed
                    imageResource, // Pass image resource ID
                    pricePerItem,
                    quantity,
                    "drink"
            );

            Toast.makeText(DrinkDetailActivity.this, quantity + " item(s) added to cart", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void updatePrice() {
        tvQuantity.setText(String.valueOf(quantity));
        drinkPrice.setText("Price: " + (pricePerItem * quantity) + " VNĐ");
    }
}
