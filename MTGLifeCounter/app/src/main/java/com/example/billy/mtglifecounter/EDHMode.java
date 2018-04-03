package com.example.billy.mtglifecounter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.opengl.Visibility;
import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import static com.example.billy.mtglifecounter.R.id.pTwoLife;

public class EDHMode extends AppCompatActivity {

    int pOneValue = 40;
    int pTwoValue = 40;
    int pThreeValue = 40;
    int pFourValue = 40;
    int poisonVal = 0;
    int energyVal = 0;
    int stormVal = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edh_mode);
        final TextView logText = (TextView) findViewById(R.id.log);
        logText.setMovementMethod(new ScrollingMovementMethod());

        final Button shopBtn = (Button) findViewById(R.id.shopBTN);
        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchShop();
            }
        });

        final Button backBtn = (Button) findViewById(R.id.backBTN);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchLifeCounter();
            }
        });

        final Button resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        final Button pOneUp = (Button) findViewById(R.id.pOnePlus);
        pOneUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pOneValue++;
                final TextView pOneLife = (TextView) findViewById(R.id.pOneLife);
                if (pOneValue == 20){
                    pOneLife.setTextColor(Color.BLACK);
                }
                logText.setText("Player 1 life + 1 (" + pOneValue + ")" + "\n" + logText.getText());

                pOneLife.setText(String.valueOf(pOneValue));

            }
        });

        final Button pOneDown = (Button) findViewById(R.id.pOneMinus);
        pOneDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pOneValue--;
                final TextView pOneLife = (TextView) findViewById(R.id.pOneLife);
                if (pOneValue < 20){
                    pOneLife.setTextColor(Color.RED);
                }
                logText.setText("Player 1 life - 1 (" + pOneValue + ")" + "\n" + logText.getText());

                pOneLife.setText(String.valueOf(pOneValue));

            }
        });

        final Button pTwoUp = (Button) findViewById(R.id.pTwoPlus);
        pTwoUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pTwoValue++;
                final TextView pTwoLife = (TextView) findViewById(R.id.pTwoLife);
                if (pTwoValue == 20){
                    pTwoLife.setTextColor(Color.BLACK);
                }
                logText.setText("Player 2 life + 1 (" + pTwoValue + ")" + "\n" + logText.getText());

                pTwoLife.setText(String.valueOf(pTwoValue));

            }
        });

        final Button pTwoDown = (Button) findViewById(R.id.pTwoMinus);
        pTwoDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pTwoValue--;
                final TextView pTwoLife = (TextView) findViewById(R.id.pTwoLife);
                if (pTwoValue < 20){
                    pTwoLife.setTextColor(Color.RED);
                }
                logText.setText("Player 2 life - 1 (" + pTwoValue + ")" + "\n" + logText.getText());

                pTwoLife.setText(String.valueOf(pTwoValue));

            }
        });

        final Button pThreeUp = (Button) findViewById(R.id.pThreePlus);
        pThreeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pThreeValue++;
                final TextView pThreeLife = (TextView) findViewById(R.id.pThreeLife);
                if (pThreeValue == 20){
                    pThreeLife.setTextColor(Color.BLACK);
                }
                logText.setText("Player 3 life + 1 (" + pThreeValue + ")" + "\n" + logText.getText());

                pThreeLife.setText(String.valueOf(pThreeValue));

            }
        });

        final Button pThreeDown = (Button) findViewById(R.id.pThreeMinus);
        pThreeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pThreeValue--;
                final TextView pThreeLife = (TextView) findViewById(R.id.pThreeLife);
                if (pThreeValue < 20){
                    pThreeLife.setTextColor(Color.RED);
                }
                logText.setText("Player 3 life - 1 (" + pThreeValue + ")" + "\n" + logText.getText());

                pThreeLife.setText(String.valueOf(pThreeValue));

            }
        });

        final Button pFourUp = (Button) findViewById(R.id.pFourPlus);
        pFourUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pFourValue++;
                final TextView pFourLife = (TextView) findViewById(R.id.pFourLife);
                if (pFourValue == 20){
                    pFourLife.setTextColor(Color.BLACK);
                }
                logText.setText("Player 4 life + 1 (" + pFourValue + ")" + "\n" + logText.getText());

                pFourLife.setText(String.valueOf(pFourValue));

            }
        });

        final Button pFourDown = (Button) findViewById(R.id.pFourMinus);
        pFourDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pFourValue--;
                final TextView pFourLife = (TextView) findViewById(R.id.pFourLife);
                if (pFourValue < 20){
                    pFourLife.setTextColor(Color.RED);
                }
                logText.setText("Player 4 life - 1 (" + pFourValue + ")" + "\n" + logText.getText());

                pFourLife.setText(String.valueOf(pFourValue));

            }
        });

    }
    private void launchShop() {

        Intent intent = new Intent(this, WebPackage.class);
        startActivity(intent);
    }
    private void launchLifeCounter() {

        Intent intent = new Intent(this, LifeCounter.class);
        startActivity(intent);
    }
}
