package com.example.mystartwarsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CardView starshipsCardView;
    CardView peopleCardView;
    CardView planetsCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
        setOnClicks();
    }


    public void findViewsById() {
        starshipsCardView = findViewById(R.id.card_view_starships);
        peopleCardView = findViewById(R.id.card_view_people);
        planetsCardView = findViewById(R.id.card_view_planets);
    }

    public void setOnClicks(){
        starshipsCardView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StarshipsActivity.class);
            startActivity(intent);
        });

        peopleCardView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PeopleActivity.class);
            startActivity(intent);
        });

        planetsCardView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlanetsActivity.class);
            startActivity(intent);
        });

    }
}