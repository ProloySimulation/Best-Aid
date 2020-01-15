package com.best_aid.proloy.lifesaver.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.best_aid.proloy.lifesaver.Model.GeoLocation;
import com.best_aid.proloy.lifesaver.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ActivityRegistration extends AppCompatActivity {

    private EditText etRegEmail , etRegPassword ,etUsername , etBlood , etPhone ,etLang , etLong, etAdress , etArea;
    String date = "2012-12-12";
    String registration = "register_this_dumb";
    Button btnReg ;
    private String email , password , blood , adress , lat , longg , address , username , phpne ;
    private String regUrl = "http://bestaidbd.com/app/API/user_registration.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPassword);
        etUsername = findViewById(R.id.etUsername);
        etBlood = findViewById(R.id.etBlood);
        etPhone = findViewById(R.id.etPhone);
        etArea = findViewById(R.id.etArea);
        etAdress = findViewById(R.id.etAdress);
        btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
                getLatLong();
            }
        });

    }

    private void getLatLong()
    {
        String adress = etArea.getText().toString().trim();
        GeoLocation geoLocation = new GeoLocation();
    }

    private void register() {

        email = etRegEmail.getText().toString().trim() ;
        password = etRegPassword.getText().toString().trim();
        lat = etLang.getText().toString().trim();
        longg = etLong.getText().toString().trim();
        adress = etAdress.getText().toString().trim();
        username = etUsername.getText().toString().trim();
        blood = etBlood.getText().toString().trim();
        phpne = etPhone.getText().toString().trim();


        StringRequest request = new StringRequest(Request.Method.POST, regUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");

                            if (status.equals("1"))
                            {
                                Toast.makeText(ActivityRegistration.this,"Register Scucessfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),ActivityLogin.class);
                                startActivity(intent);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(ActivityRegistration.this,"Error" + e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityRegistration.this,"Register Error" + error.toString(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                params.put("username",username);
                params.put("phn_no",phpne);
                params.put("address",adress);
                params.put("blood_group",blood);
                params.put("lat",lat);
                params.put("long",longg);
                params.put("last_donation_date",date);
                params.put("registration",registration);


                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}
