package com.example.paymentwithpaypal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity extends AppCompatActivity {

    private TextView foodName, foodDescription, foodPrice, tvQuantity;
    private ImageView foodImage; // Changed from int to ImageView
    private Button btnMinus, btnPlus, btnAddToCart;
    private int quantity = 1;
    private double pricePerItem;
    private int imageResource; // Added to store image resource ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_food_details);

        foodName = findViewById(R.id.foodNameDetail);
        foodDescription = findViewById(R.id.foodDescriptionDetail);
        foodPrice = findViewById(R.id.foodPriceDetail);
        foodImage = findViewById(R.id.foodImage); // Fixed to ImageView
        tvQuantity = findViewById(R.id.foodQuantity);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        // Get data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            foodName.setText(extras.getString("foodName"));
            foodDescription.setText(extras.getString("foodDescription"));
            pricePerItem = extras.getDouble("foodPrice");
            imageResource = extras.getInt("foodImage"); // Store image resource ID
            foodImage.setImageResource(imageResource); // Set image
            foodPrice.setText("Price: " + pricePerItem * quantity + " VNĐ");
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
                    foodName.getText().toString(),
                    imageResource,
                    pricePerItem,
                    quantity,
                    "Food"
            );

            Toast.makeText(FoodDetailActivity.this, quantity + " item(s) added to cart", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void updatePrice() {
        tvQuantity.setText(String.valueOf(quantity));
        foodPrice.setText("Price: " + (pricePerItem * quantity) + " VNĐ");
    }
}
