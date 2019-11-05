package com.example.proloy.lifesaver;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proloy.lifesaver.Fragment.SingleChoiceDialogFragment;

public class ActivityBlood extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {

    Button btnBloodGroup ;
    TextView tvSelect ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);

        btnBloodGroup = findViewById(R.id.btnBloodGroup);
        tvSelect = findViewById(R.id.tvSelect);

        btnBloodGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment singleChoiceDialog = new SingleChoiceDialogFragment();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
            }
        });
    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        tvSelect.setText( list[position]+" "+"রক্তদাতাদের লিস্ট");
    }

    @Override
    public void onNegativeButtonClicked() {
        tvSelect.setText("Dialog cancel");
    }
}
