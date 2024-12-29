package com.example.digilocker_safest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCards);

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Example data for cards
        List<String> cardTitles = Arrays.asList("Aadhaar Card","Covid Vaccine", "Driving License", "PAN Card");
        List<String> cardDescreptions = Arrays.asList("Unique Identification Authority of India(UIDAI)", "Ministry of Health & Welfare", "Ministry of Road transport and Highway", "Income Tax Department");
        List<Integer> cardImages = Arrays.asList(R.drawable.aadhar,R.drawable.ic_tigers, R.drawable.ic_tigers, R.drawable.ic_pancard);

        // Set Adapter
        CardAdapter adapter = new CardAdapter(cardTitles, cardDescreptions, cardImages);
        recyclerView.setAdapter(adapter);

        // Add SnapHelper for snapping effect
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}