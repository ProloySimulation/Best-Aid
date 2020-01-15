package com.example.proloy.lifesaver.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.proloy.lifesaver.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;

    Animation topAnim ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.fromtop);

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        final String tokeRecieve = sharedPreferences.getString("token", null);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                if(tokeRecieve.isEmpty()) {
                    Intent homeIntent = new Intent(SplashActivity.this, ActivityLogin.class);
                    startActivity(homeIntent);
                    finish();
                }

                else {
                    Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}
