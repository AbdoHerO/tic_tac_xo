package com.example.abdohero.tic_tac_xo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button again;

    private Button button[][] = new Button[3][3];
    private boolean visible = false;
    private TextView player1;
    private TextView player2;
    private int winX=0;
    private int winO=0;
    private int count=0;
    private int tour=0;
    private int i,j,z=0;
    private int x=0;
    private int o=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -------- Button ------
        button[0][0] = (Button) findViewById(R.id.b00);
        button[0][1] = (Button) findViewById(R.id.b01);
        button[0][2] = (Button) findViewById(R.id.b02);
        button[1][0] = (Button) findViewById(R.id.b10);
        button[1][1] = (Button) findViewById(R.id.b11);
        button[1][2] = (Button) findViewById(R.id.b12);
        button[2][0] = (Button) findViewById(R.id.b20);
        button[2][1] = (Button) findViewById(R.id.b21);
        button[2][2] = (Button) findViewById(R.id.b22);
        again = (Button) findViewById(R.id.again);
        //---------
        //-------- TextView------------
        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);

        //-------Listeners----------
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                button[i][j].setOnClickListener(this);
            }
        };
        again.setOnClickListener(this);





    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.again:

                for (Button[] button1 : button) {
                    for (Button button : button1) {
                            button.setClickable(true);
                            button.setText("");
                    }
                }

                //--------------------- pour tour de X---------------
                if(tour==0) {
                    for (Button[] button1 : button) {
                        for (Button button : button1) {
                            if (button.getId() == v.getId()) {
                                button.setClickable(true);
                                button.setText("");
                                if (count == 0) {
                                    button.setText("x");
                                    count += 1;
                                } else {
                                    button.setText("o");
                                    count--;
                                }
                                if (!button.getText().equals("")) {
                                    button.setClickable(false);
                                }
                            }
                        }


                    }
                    tour++;
                }

                //--------------------- pour tour de O---------------
                else {
                    for (Button[] button1 : button) {
                        for (Button button : button1) {
                            if (button.getId() == v.getId()) {
                                if (count == 0) {
                                    button.setText("o");
                                    count += 1;
                                } else {
                                    button.setText("x");
                                    count--;
                                }
                                if (!button.getText().equals("")) {
                                    button.setClickable(false);
                                }
                            }
                        }


                    }
                    tour--;
                }


        }

        //------------ Pour insertion --------------
        for (Button[] button1 : button) {
            for (Button button : button1) {
                if (button.getId() == v.getId()) {
                    if (count == 0) {
                        button.setText("x");
                        count += 1;
                    } else {
                        button.setText("o");
                        count--;
                    }
                    if (!button.getText().equals("")) {
                        button.setClickable(false);
                    }


                }
            }
        }
//-----------------------------------------------X----------------------------------------------

        // ---------- Pour les ligne X---------------
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if(button[i][j].getText().toString().equals("x")){
                    winX++;
                }
            }
            if (winX==3){
                x++;
                player1.setText(""+x);
                winX=0;
            }
            else {
                winX=0;
            }
        }


        //----------------- Pour les Colones X-----------------
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if(button[j][i].getText().toString().equals("x")){
                    winX++;
                }
            }
            if (winX==3){
                x++;
                player1.setText(""+x);
                winX=0;
            }
            else {
                winX=0;
            }
        }

//------------------------- Diagonal pour X  Droit-----------------------------------------------
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if(i==j) {
                    if (button[i][j].getText().toString().equals("x")) {
                        winX++;
                    }
                }
            }
            if(i==2){
                if (winX==3){
                    x++;
                    player1.setText(""+x);
                    winX=0;
                }
                else {
                    winX=0;
                }
            }
        }

//-------------------------- Diagonal pour X Rouch -----------------------------------------------

        if(button[2][0].getText().toString().equals("x") && button[1][1].getText().toString().equals(button[2][0].getText().toString()) && button[3][0].getText().toString().equals(button[0][2].getText().toString())){
            x++;
            player1.setText(""+x);
        }









//---------------------------------------------O------------------------------------------------


        // ---------- Pour les ligne O---------------
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if(button[i][j].getText().toString().equals("o")){
                    winO++;
                }
            }
            if (winO==3){
                o++;
                player2.setText(""+o);
                winO=0;
            }
            else {
                winO=0;
            }
        }


        //----------------- Pour les Colones O-----------------
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if(button[j][i].getText().toString().equals("o")){
                    winO++;
                }
            }
            if (winO==3){
                o++;
                player2.setText(""+o);
                winO=0;
            }
            else {
                winO=0;
            }
        }



        //------------------------- Diagonal pour O -----------------------------------------------
        for (i=0;i<3;i++){
            for (j=0;j<3;j++){
                if(i==j) {
                    if (button[i][j].getText().toString().equals("o")) {
                        winO++;
                    }
                }
            }
            if(i==2){
                if (winO==3){
                    o++;
                    player2.setText(""+o);
                    winO=0;
                }
                else {
                    winO=0;
                }
            }
        }

//---------------------------------------------------------------------------------------------



    }



}
