package com.example.proloy.lifesaver.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proloy.lifesaver.ActivityApointment;
import com.example.proloy.lifesaver.ActivityBlood;
import com.example.proloy.lifesaver.ActivityCatagory;
import com.example.proloy.lifesaver.QuestionActivity;
import com.example.proloy.lifesaver.R;


public class HomeFragment extends Fragment {

    Button btnDoctor ;
    Button btnBlood,btnQuetion ;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        btnDoctor = (Button) myFragmentView.findViewById(R.id.btn1);
        btnBlood =  (Button) myFragmentView.findViewById(R.id.btn2);
        btnQuetion = myFragmentView.findViewById(R.id.btn4);

        btnDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),ActivityCatagory.class);
                startActivity(intent);
            }
        });

        btnBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),ActivityBlood.class);
                startActivity(intent);
            }
        });

        btnQuetion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), QuestionActivity.class);
                startActivity(intent);
            }
        });

        return myFragmentView;

    }
}
