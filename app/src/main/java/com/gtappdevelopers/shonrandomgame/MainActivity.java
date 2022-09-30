package com.gtappdevelopers.shonrandomgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.widget.TextView;
import android.os.Bundle;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int guessCount;
    private int numRange;
    private int rndNum;
    private Editable currentGuess;
    private int con50;
    private int con100;
    //    private int conMenu;
    private int con10;
    private int conNew;
    private int gameStarted;
    private String saveGuess;
    public static final String EXTRA_MESSAGE = "com.example.myriads.MESSAGE";


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView aboutMe = findViewById(R.id.aboutmetext);
        aboutMe.setVisibility(View.INVISIBLE);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        TextView HighLow = findViewById(R.id.highlow1);
        HighLow.setText("Choose Mode");

        TextView con = findViewById(R.id.pressAgain);
        con.setVisibility(View.INVISIBLE);


        this.gameStarted=0;
        this.guessCount=0;
        this.numRange=100;
        this.rndNum=0;
        this.saveGuess="0";

        this.con50=0;
        this.con100=0;
        this.con10=0;
        this.conNew=0;



        final EditText edittext = (EditText) findViewById(R.id.edittext);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                currentGuess = edittext.getText();
                return true;
            }

        });
        restartGame();
        HighLow.setText("Choose Mode");



    };




    public void submitAnswer(View v) {
        if(gameStarted>0) {
            hideCon();
            resetCons();
            final EditText edittext = (EditText) findViewById(R.id.edittext);

            currentGuess = edittext.getText();
            String temp = String.valueOf(currentGuess);

            boolean allNumbers = true;
            for (int i = 0; i < temp.length(); i++) {
                char temp1 = temp.charAt(i);
                if ((int) temp1 < 48 || (int) temp1 > 57)
                    allNumbers = false;
            }

            if (allNumbers == true) {
                saveGuess = String.valueOf(currentGuess);
//                TextView ViewYourGuess = findViewById(R.id.yourguess1);
//                ViewYourGuess.setText("Your Guess: " + saveGuess);
                guessCount++;
                TextView GuessCount = findViewById(R.id.guessCounter);
                GuessCount.setText("Guess Counter: " + guessCount);

                //check if user won by guessing right number
                int userGuess = Integer.parseInt(saveGuess);
                if (userGuess == rndNum) {
                    winScreen();
                } else {

                    if (userGuess < rndNum)
                        Toast.makeText(getApplicationContext(), "The number is higher", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "The number is lower", Toast.LENGTH_SHORT).show();
                }


            }

        }





    }


    public void clicked10(View v)
    {

        if(this.con10==1) {
            hideCon();
            this.numRange = 10;
            restartGame();
            TextView HighLow = findViewById(R.id.highlow1);
            HighLow.setText("Enter Number 0-10");
            this.rndNum= makeRndNum(numRange);


            this.con10=0;
            this.gameStarted++;
        }
        else
        {

            resetCons();
            this.con10++;
            showCon();
        }


    }


    public void clicked50(View v)
    {

        if(this.con50==1) {
            hideCon();
            this.numRange = 50;
            restartGame();
            TextView HighLow = findViewById(R.id.highlow1);
            HighLow.setText("Enter Number 0-50");
            this.rndNum= makeRndNum(numRange);


            this.con50=0;
            this.gameStarted++;
        }
        else
        {

            resetCons();
            this.con50++;
            showCon();
        }


    }



    public void clicked100(View v)
    {

        if(this.con100==1) {
            hideCon();
            this.numRange = 100;
            restartGame();
            TextView HighLow = findViewById(R.id.highlow1);
            HighLow.setText("Enter Number 0-100");
            this.rndNum= makeRndNum(numRange);


            this.con100=0;
            this.gameStarted++;
        }
        else
        {

            resetCons();
            this.con100++;
            showCon();
        }


    }

    public int makeRndNum(int numRange)
    {
        int temp=0;
        Random rnd = new Random();
        temp=rnd.nextInt(numRange+1);
        return temp;
    }



    public void restartGame()
    {
        hideCon();
        this.guessCount = 0;
        this.rndNum = 0;
        this.saveGuess = "0";

        TextView HighLow = findViewById(R.id.highlow1);
        HighLow.setText("Enter Number");
        TextView GuessCount = findViewById(R.id.guessCounter);
        GuessCount.setText("Guess Counter: " + guessCount);
    }


    public void restartGameButton(View v)
    {

        if(this.conNew==1) {
            hideCon();
            this.gameStarted=0;
            this.guessCount = 0;
            this.numRange = 100;
            this.rndNum = 0;
            this.saveGuess = "0";

            TextView HighLow = findViewById(R.id.highlow1);
            HighLow.setText("Choose Mode");
            TextView GuessCount = findViewById(R.id.guessCounter);
            GuessCount.setText("Guess Counter: " + guessCount);
            this.conNew=0;
        }
        else
        {
            resetCons();
            this.conNew++;
            showCon();
        }

    }


//
//    public void menuButton(View v)
//    {
//
//        if(this.conMenu==1) {
//            //here i move to new activity
//          /*this command below makes this activity close right after i close the menu in exit button */
//            ActivityCompat.finishAffinity(this);
//            Intent intent = new Intent(this, menu.class);
//            startActivity(intent);
//
//
//        }
//        else
//        {
//            resetCons();
//            this.conMenu++;
//            showCon();
//        }
//
//    }



    public void winScreen()
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Well Done! You have won after " + guessCount + " tries!");
        ActivityCompat.finishAffinity(this);
        startActivity(intent);

    }

    public void showCon()
    {
        TextView aboutMe = findViewById(R.id.aboutmetext);
        aboutMe.setVisibility(View.INVISIBLE);

        TextView con = findViewById(R.id.pressAgain);
        con.setVisibility(View.VISIBLE);
    }

    public void hideCon()
    {
        TextView aboutMe = findViewById(R.id.aboutmetext);
        aboutMe.setVisibility(View.INVISIBLE);

        TextView con = findViewById(R.id.pressAgain);
        con.setVisibility(View.INVISIBLE);
    }




    public void resetCons()
    {

        this.con50=0;
        this.con100=0;
        this.con10=0;
        this.conNew=0;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.itemExit)
        {
            finish();
            return true;
        }
        if(item.getItemId() == R.id.itemAbout)
        {
            TextView aboutMe = findViewById(R.id.aboutmetext);
            aboutMe.setVisibility(View.VISIBLE);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }











}


