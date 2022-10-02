package com.gtappdevelopers.shonrandomgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private int confirm;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        this.confirm = 0;


        TextView con = findViewById(R.id.pressAgain);
        con.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.youwon);
        textView.setText("You have won after " + message + " tries!");


        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        int total = sharedPreferences.getInt("total", -1);

        TextView textView1 = findViewById(R.id.totalGuess);
        textView1.setText("Total Guesses: " + total);


    }


    public void switch1(View v) {
        if (this.confirm == 1) {
            Intent intent = new Intent(this, MainActivity.class);
            ActivityCompat.finishAffinity(this);
            startActivity(intent);
        } else {

            TextView con = findViewById(R.id.pressAgain);
            con.setVisibility(View.VISIBLE);
            this.confirm++;
        }


    }


}