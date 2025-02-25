package com.example.paymentwithpaypal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.paymentwithpaypal.Adapter.FoodAdapter;
import com.example.paymentwithpaypal.Models.FoodItem;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<FoodItem> foodList;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        listView = findViewById(R.id.foodListView);

        // Initialize food list with descriptions
        foodList = new ArrayList<>();
        foodList.add(new FoodItem("Burger", "Juicy beef patty with lettuce, tomato, and cheese, served on a toasted bun.", 5.99, R.drawable.burger));
        foodList.add(new FoodItem("Pizza", "A classic pepperoni pizza with mozzarella cheese and tomato sauce.", 8.99, R.drawable.pizza));
        foodList.add(new FoodItem("Pasta", "Creamy Alfredo pasta with chicken and mushrooms, topped with Parmesan.", 7.49, R.drawable.pasta));
        foodList.add(new FoodItem("Sushi", "Fresh salmon, tuna, and avocado rolls served with soy sauce and wasabi.", 12.99, R.drawable.sushi));
        foodList.add(new FoodItem("Salad", "Healthy mixed greens with cherry tomatoes, cucumbers, and balsamic dressing.", 4.99, R.drawable.salad));

        // Set up adapter
        foodAdapter = new FoodAdapter(this, foodList);
        listView.setAdapter(foodAdapter);

        // Handle item click to open details screen
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodItem selectedFood = foodList.get(position);
                Intent intent = new Intent(FoodActivity.this, FoodDetailActivity.class);
                intent.putExtra("foodName", selectedFood.getName());
                intent.putExtra("foodDescription", selectedFood.getDescription());
                intent.putExtra("foodPrice", selectedFood.getPrice());
                intent.putExtra("foodImage", selectedFood.getImageResource());
                startActivity(intent);
            }
        });
    }
}