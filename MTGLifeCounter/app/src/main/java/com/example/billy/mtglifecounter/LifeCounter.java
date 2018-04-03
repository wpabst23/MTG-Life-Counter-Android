/*************************************************************************
 *
 * COPYRIGHT CONFIDENTIAL
 * __________________
 *
 *  [2016] William Pabst
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of William Pabst. The intellectual and technical concepts contained
 * herein are proprietary, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained.
 */

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

public class LifeCounter extends AppCompatActivity {

    int pOneValue = 20;
    int pTwoValue = 20;
    int poisonVal = 0;
    int energyVal = 0;
    int stormVal = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_counter);
        final TextView poisonText = (TextView) findViewById(R.id.poisonText);
        final TextView energyText = (TextView) findViewById(R.id.energyText);
        final TextView stormText = (TextView) findViewById(R.id.stormText);
        final ImageView imageP = (ImageView) findViewById(R.id.imageP);
        final ImageView imageE = (ImageView) findViewById(R.id.imageE);
        final ImageView imageS = (ImageView) findViewById(R.id.imageS);
        final TextView logText = (TextView) findViewById(R.id.log);
        logText.setMovementMethod(new ScrollingMovementMethod());

        final Button shopBtn = (Button) findViewById(R.id.shopBTN);
        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchShop();
            }
        });

        final Button edhBtn = (Button) findViewById(R.id.edhBTN);
        edhBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchEDH();
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
                if (pOneValue == 10){
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
                if (pOneValue < 10){
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
                if (pTwoValue == 10){
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
                if (pTwoValue < 10){
                    pTwoLife.setTextColor(Color.RED);
                }
                logText.setText("Player 2 life - 1 (" + pTwoValue + ")" + "\n" + logText.getText());

                pTwoLife.setText(String.valueOf(pTwoValue));

            }
        });


        final Button recUp = (Button) findViewById(R.id.recPlus);
        recUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (poisonText.getVisibility() == View.VISIBLE){
                poisonVal++;
                    logText.setText("Poison + 1 (" + poisonVal + ")" + "\n" + logText.getText());
                poisonText.setText(String.valueOf(poisonVal));}

                if (energyText.getVisibility() == View.VISIBLE){
                energyVal++;
                    logText.setText("Energy + 1 (" + energyVal + ")" + "\n" + logText.getText());
                energyText.setText(String.valueOf(energyVal));}

                if (stormText.getVisibility() == View.VISIBLE){
                stormVal++;
                    logText.setText("Storm Count + 1 (" + stormVal + ")" + "\n" + logText.getText());
                stormText.setText(String.valueOf(stormVal));}

            }
        });

        final Button recDown = (Button) findViewById(R.id.recMinus);
        recDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (poisonText.getVisibility() == View.VISIBLE){
                poisonVal--;
                    if (poisonVal <= 0){ poisonVal = 0;}
                    logText.setText("Poison - 1 (" + poisonVal + ")" + "\n" + logText.getText());
                poisonText.setText(String.valueOf(poisonVal));}

                if (energyText.getVisibility() == View.VISIBLE){
                energyVal--;
                    if (energyVal <= 0){ energyVal = 0;}
                    logText.setText("Energy - 1 (" + energyVal + ")" + "\n" + logText.getText());
                energyText.setText(String.valueOf(energyVal));}

                if (stormText.getVisibility() == View.VISIBLE){
                stormVal--;
                    if (stormVal <= 0){ stormVal = 0;}
                    logText.setText("Storm Count - 1 (" + stormVal + ")" + "\n" + logText.getText());
                stormText.setText(String.valueOf(stormVal));}

            }
        });

        final ImageButton poisonButton = (ImageButton) findViewById(R.id.poisonButton);
        poisonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poisonText.setText(String.valueOf(poisonVal));
                poisonText.setVisibility(View.VISIBLE);
                imageP.setVisibility(View.VISIBLE);
                energyText.setVisibility(View.INVISIBLE);
                imageE.setVisibility(View.INVISIBLE);
                stormText.setVisibility(View.INVISIBLE);
                imageS.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton energyButton = (ImageButton) findViewById(R.id.energyButton);
        energyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poisonText.setText(String.valueOf(energyVal));
                poisonText.setVisibility(View.INVISIBLE);
                imageP.setVisibility(View.INVISIBLE);
                energyText.setVisibility(View.VISIBLE);
                imageE.setVisibility(View.VISIBLE);
                stormText.setVisibility(View.INVISIBLE);
                imageS.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton stormButton = (ImageButton) findViewById(R.id.stormButton);
        stormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poisonText.setText(String.valueOf(stormVal));
                poisonText.setVisibility(View.INVISIBLE);
                imageP.setVisibility(View.INVISIBLE);
                energyText.setVisibility(View.INVISIBLE);
                imageE.setVisibility(View.INVISIBLE);
                stormText.setVisibility(View.VISIBLE);
                imageS.setVisibility(View.VISIBLE);
            }
        });
    }
    private void launchShop() {

        Intent intent = new Intent(this, WebPackage.class);
        startActivity(intent);
    }
    private void launchEDH() {

        Intent intent = new Intent(this, EDHMode.class);
        startActivity(intent);
    }
}