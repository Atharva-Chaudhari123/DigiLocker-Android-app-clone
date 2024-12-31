package com.example.digilocker_safest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button b  ;
    Context c ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = MainActivity.this ;

        // Find the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCards);

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Example data for cards
        List<String> cardTitles = Arrays.asList("Aadhaar Card","Covid Vaccine", "Driving License", "PAN Card");
        List<Integer> cardID = Arrays.asList(1,2,3,4  ) ;
        List<String> cardDescreptions = Arrays.asList("Unique Identification Authority of India(UIDAI)", "Ministry of Health & Welfare", "Ministry of Road transport and Highway", "Income Tax Department");
        List<Integer> cardImages = Arrays.asList(R.drawable.aadhar,R.drawable.ic_tigers, R.drawable.ic_tigers, R.drawable.ic_pancard);

        // Set Adapter
        CardAdapter adapter = new CardAdapter(MainActivity.this, cardTitles, cardDescreptions, cardImages, cardID);
        recyclerView.setAdapter(adapter);

        // Add SnapHelper for snapping effect
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


    }
}
