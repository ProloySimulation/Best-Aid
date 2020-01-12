package com.example.proloy.lifesaver.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proloy.lifesaver.Activity.ActivityReceipt;
import com.example.proloy.lifesaver.R;


public class ProfileFragment extends Fragment {

    TextView tvApointments ;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmentView1 = inflater.inflate(R.layout.fragment_profile, container, false);

        tvApointments = myFragmentView1.findViewById(R.id.tvApointments);

        tvApointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),ActivityReceipt.class);
                startActivity(intent);
            }
        });

        return myFragmentView1;
    }

}
