package com.mohammadsamandari.lordtactoe;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int turn, winner, count;
    String message = "";
    int[] gamePlaying = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn = 1;
        count = 0;

    }

    public void boardClick(View view) {
        ImageView imageView = findViewById(view.getId());
        imageView.setEnabled(false);
        int tagClicked = Integer.parseInt(imageView.getTag().toString());
        if (turn == 1) {
            imageView.setImageResource(R.drawable.yellow);
            gamePlaying[tagClicked] = turn;
            turn = 2;
        } else {
            imageView.setImageResource(R.drawable.red);
            gamePlaying[tagClicked] = turn;
            turn = 1;
        }
        count++;
        checkWinner();
    }

    private void gameOver() {
        LinearLayout mainLayout1 = findViewById(R.id.mainLayout1);
        for (int i = 0; i < mainLayout1.getChildCount(); i++) {
            View view = mainLayout1.getChildAt(i);
            view.setEnabled(false);
        }
        LinearLayout mainLayout2 = findViewById(R.id.mainLayout2);
        for (int i = 0; i < mainLayout2.getChildCount(); i++) {
            View view = mainLayout2.getChildAt(i);
            view.setEnabled(false);
        }
        LinearLayout mainLayout3 = findViewById(R.id.mainLayout3);
        for (int i = 0; i < mainLayout3.getChildCount(); i++) {
            View view = mainLayout3.getChildAt(i);
            view.setEnabled(false);
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void checkWinner() {
        if (count == 9) {
            winner = 3;

        }
        if (gamePlaying[0] == gamePlaying[1] && gamePlaying[0] == gamePlaying[2]) {
            winner = gamePlaying[0];

        } else if (gamePlaying[3] == gamePlaying[4] && gamePlaying[3] == gamePlaying[5]) {
            winner = gamePlaying[3];


        } else if (gamePlaying[6] == gamePlaying[7] && gamePlaying[6] == gamePlaying[8]) {
            winner = gamePlaying[6];


        } else if (gamePlaying[0] == gamePlaying[3] && gamePlaying[0] == gamePlaying[6]) {
            winner = gamePlaying[0];


        } else if (gamePlaying[1] == gamePlaying[4] && gamePlaying[1] == gamePlaying[7]) {
            winner = gamePlaying[1];


        } else if (gamePlaying[2] == gamePlaying[5] && gamePlaying[2] == gamePlaying[8]) {
            winner = gamePlaying[2];


        } else if (gamePlaying[0] == gamePlaying[4] && gamePlaying[0] == gamePlaying[8]) {
            winner = gamePlaying[0];


        } else if (gamePlaying[2] == gamePlaying[4] && gamePlaying[2] == gamePlaying[6]) {
            winner = gamePlaying[2];

        } else {
            winner = 0;
            return;
        }

        if (winner == 1) {
            message = "Yellow Wins!";
            gameOver();

        } else if (winner == 2) {
            message = "Red Wins";
            gameOver();

        } else if (winner == 3) {
            message = "Game is A Tie";
            gameOver();

        }

    }
}
