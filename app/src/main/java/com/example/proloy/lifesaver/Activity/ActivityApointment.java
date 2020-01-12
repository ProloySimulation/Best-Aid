package com.example.proloy.lifesaver.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.proloy.lifesaver.Model.Doctor;
import com.example.proloy.lifesaver.R;

import java.util.List;

public class ActivityApointment extends AppCompatActivity {

    //a list to store all the products
    List<Doctor> doctor;
    Button btnDeatil ;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apointment);

        btnDeatil = findViewById(R.id.btnDetail);

        btnDeatil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityDoctorProfile.class);
                startActivity(intent);
            }
        });

   /*     recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        doctor = new ArrayList<>();


        //adding some items to our list
        doctor.add(
                new Doctor(
                        1,
                        "ডাঃ ঊবায়দুল কাদির উজ্জ্বল",
                        "কিডনী রোগ বিশেষজ্ঞ",
                        1000,
                        R.drawable.doc));

        doctor.add(
                new Doctor(
                        1,
                        "ডাঃ ঊবায়দুল কাদির উজ্জ্বল",
                        "কিডনী রোগ বিশেষজ্ঞ",
                        1000,
                        R.drawable.doc));

        doctor.add(
                new Doctor(
                        1,
                        "ডাঃ ঊবায়দুল কাদির উজ্জ্বল",
                        "কিডনী রোগ বিশেষজ্ঞ",
                        1000,
                        R.drawable.doc));

        //creating recyclerview adapter
        DoctorAdapter doctorAdapter = new DoctorAdapter(this, doctor);

        //setting adapter to recyclerview
        recyclerView.setAdapter(doctorAdapter); */
    }
}
