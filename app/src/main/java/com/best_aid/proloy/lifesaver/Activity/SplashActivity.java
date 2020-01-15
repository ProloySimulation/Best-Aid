package com.best_aid.proloy.lifesaver.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.best_aid.proloy.lifesaver.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    String tokeRecieve = "";

    Animation topAnim ;
    ImageView imvLogo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imvLogo = findViewById(R.id.imvLogo);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.fromtop);

        imvLogo.setAnimation(topAnim);
        final SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        tokeRecieve = sharedPreferences.getString("token", null);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                Intent homeIntent = new Intent(SplashActivity.this, ActivityLogin.class);
                startActivity(homeIntent);
                finish();

            /*    if(sharedPreferences.contains("token"))
                {
                        Intent homeIntent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                        finish();

                }

                else {
                    Intent homeIntent = new Intent(SplashActivity.this, ActivityLogin.class);
                    startActivity(homeIntent);
                    finish();
                }*/

            }
        },SPLASH_TIME_OUT);
    }
}
