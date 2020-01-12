package com.example.proloy.lifesaver.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.proloy.lifesaver.R;
import com.jcminarro.roundkornerlayout.RoundKornerRelativeLayout;

public class ActivityCatagory extends AppCompatActivity {

    RoundKornerRelativeLayout cvCat1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        cvCat1 = findViewById(R.id.rlCat1);

        cvCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityApointment.class);
                startActivity(intent);
            }
        });
    }
}
