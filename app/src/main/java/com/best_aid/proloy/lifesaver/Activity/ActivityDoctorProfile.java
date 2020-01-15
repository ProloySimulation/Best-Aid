package com.best_aid.proloy.lifesaver.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.best_aid.proloy.lifesaver.R;

public class ActivityDoctorProfile extends AppCompatActivity {

    CardView cardViewDoctor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile);

        cardViewDoctor = findViewById(R.id.cardBtnSerial);

        cardViewDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityDateFix.class);
                startActivity(intent);
            }
        });
    }
}
