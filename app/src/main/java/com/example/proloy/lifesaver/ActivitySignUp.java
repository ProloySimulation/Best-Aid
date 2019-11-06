package com.example.proloy.lifesaver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivitySignUp extends AppCompatActivity {

    Button btnSignUp ;
    EditText etEmail,etPassword,etLocation,etMobile ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = findViewById(R.id.etEmailSign);
        etPassword = findViewById(R.id.etPasswordSign);
        etLocation = findViewById(R.id.etLocation);
        etMobile = findViewById(R.id.etMobile);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityLogin.class);
                startActivity(intent);
            }
        });
    }
}
