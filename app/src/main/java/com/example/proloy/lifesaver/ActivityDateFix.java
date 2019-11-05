package com.example.proloy.lifesaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ActivityDateFix extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CardView cdSerial ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_fix);

        Spinner spinner=findViewById(R.id.spinner);
        Spinner spinnerT = findViewById(R.id.spinnerTime);
        cdSerial = findViewById(R.id.cvSerial);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.chembers,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterTime = ArrayAdapter.createFromResource(this,R.array.Time,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(adapterTime);
        spinnerT.setOnItemSelectedListener(this);

        cdSerial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityReceipt.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
