package com.example.statislab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Mean,measures_of_spread,Median,Quartiles,Deciles,Percentile;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mean = findViewById(R.id.Mean);
        measures_of_spread = findViewById(R.id.MeasuresOfSpread);
        Median = findViewById(R.id.Median);
        Quartiles = findViewById(R.id.Quartiles);
        Deciles = findViewById(R.id.Deciles);
        Percentile = findViewById(R.id.Percentile);

        Mean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MeanActivity.class);
                startActivity(intent);
            }
        });
        measures_of_spread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SkewedDistributionActivity.class);
                startActivity(intent);
            }
        });
        Median.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MeanActivity.class);
                startActivity(intent);
            }
        });
        Quartiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MeanActivity.class);
                startActivity(intent);
            }
        });
        Deciles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MeanActivity.class);
                startActivity(intent);
            }
        });
        Percentile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MeanActivity.class);
                startActivity(intent);
            }
        });

    }
}