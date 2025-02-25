package com.example.paymentwithpaypal;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paymentwithpaypal.Adapter.DrinkAdapter;
import com.example.paymentwithpaypal.Models.DrinkItem;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<DrinkItem> drinkList;
    private DrinkAdapter drinkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

        listView = findViewById(R.id.drinkListView);

        // Initialize drink list with descriptions
        drinkList = new ArrayList<>();
        drinkList.add(new DrinkItem("Coca Cola", "Refreshing carbonated soft drink with classic cola flavor.", 1.99, R.drawable.coca_cola));
        drinkList.add(new DrinkItem("Orange Juice", "Freshly squeezed orange juice packed with vitamin C.", 2.99, R.drawable.orange_juice));
        drinkList.add(new DrinkItem("Coffee", "Hot brewed coffee made from premium Arabica beans.", 2.49, R.drawable.coffee));
        drinkList.add(new DrinkItem("Milkshake", "Creamy vanilla milkshake topped with whipped cream.", 3.99, R.drawable.milkshake));
        drinkList.add(new DrinkItem("Iced Tea", "Chilled black tea with a hint of lemon and honey.", 2.29, R.drawable.iced_tea));

        // Set up adapter
        drinkAdapter = new DrinkAdapter(this, drinkList);
        listView.setAdapter(drinkAdapter);

        // Handle item click to open details screen
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DrinkItem selectedDrink = drinkList.get(position);
                Intent intent = new Intent(DrinksActivity.this, DrinkDetailActivity.class);
                intent.putExtra("drinkName", selectedDrink.getName());
                intent.putExtra("drinkDescription", selectedDrink.getDescription());
                intent.putExtra("drinkPrice", selectedDrink.getPrice());
                intent.putExtra("drinkImage", selectedDrink.getImageResource());
                startActivity(intent);
            }
        });
    }
}
