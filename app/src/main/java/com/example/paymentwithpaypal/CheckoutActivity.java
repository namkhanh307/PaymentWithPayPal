package com.example.paymentwithpaypal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.paymentwithpaypal.Models.CartItem;

import java.util.ArrayList;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {
    private TextView totalPriceText;
    private Button confirmButton, cancelButton;
    private ArrayList<CartItem> cartItems;
    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        totalPriceText = findViewById(R.id.totalPrice);
        confirmButton = findViewById(R.id.confirmButton);
        cancelButton = findViewById(R.id.cancelButton);

        cartItems = CartManager.getInstance().getCartItems();

        if (cartItems == null) {
            cartItems = new ArrayList<>(); // Prevent null crashes
        }

        updateTotalPrice();

        // Confirm purchase
        confirmButton.setOnClickListener(v -> {
            if (cartItems.isEmpty()) {
                showErrorDialog("Your cart is empty!");
            } else {
                showConfirmationDialog();
            }
        });

        // Cancel checkout and go back to cart
        cancelButton.setOnClickListener(v -> {
            Intent intent = new Intent(CheckoutActivity.this, CartActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void updateTotalPrice() {
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        totalPriceText.setText(String.format(Locale.US, "Total: $%.2f", total));
    }

    private void showConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Purchase")
                .setMessage("Are you sure you want to complete your purchase?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Clear cart after purchase
                    CartManager.getInstance().clearCart();
                    Intent intent = new Intent(this, PayActivity.class);
                    intent.putExtra("PAY_AMOUNT", total);
                    startActivity(intent);                })
                .setNegativeButton("No", null)
                .show();
    }

    private void showSuccessMessage() {
        new AlertDialog.Builder(this)
                .setTitle("Success!")
                .setMessage("Your order has been placed successfully.")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Navigate back to home or menu screen
                    Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                })
                .show();
    }

    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
