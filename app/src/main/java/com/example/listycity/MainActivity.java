package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // UI components
    private EditText inputCity;
    private Button addCityButton;
    private ListView citiesListView;

    // Data components
    private ArrayList<String> citiesArray;
    private ArrayAdapter<String> citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use the activity_main XML layout
        setContentView(R.layout.activity_main);

        // Initialize UI components
        inputCity = findViewById(R.id.editText1);
        addCityButton = findViewById(R.id.button1);
        citiesListView = findViewById(R.id.city_list);

        // Initialize data structures
        citiesArray = new ArrayList<>();
        citiesAdapter = new ArrayAdapter<>(this, R.layout.content, citiesArray);

        // Attach the adapter to the ListView
        citiesListView.setAdapter(citiesAdapter);

        // Set up a button click listener for adding new cities
        addCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from input and add to our array list
                String cityName = inputCity.getText().toString();
                if (!cityName.isEmpty()) {
                    citiesArray.add(cityName);
                    citiesAdapter.notifyDataSetChanged();
                }
            }
        });

        // Set an item click listener for removing a city on tap
        citiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Remove item at the tapped position
                citiesArray.remove(position);
                // Notify the adapter about the change
                citiesAdapter.notifyDataSetChanged();
            }
        });
    }
}
