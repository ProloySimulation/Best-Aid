package com.best_aid.proloy.lifesaver.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.best_aid.proloy.lifesaver.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ActivityLogin extends AppCompatActivity {

    Button btnLogin ;
    TextView tvSignUp ;
    EditText etLoginEmail , etLoginPassword ;
    String key = "authenticate";
    //String email ;//= "arifat151151@bscse.uiu.ac.bd";
    //String password ;//= "accessdenied";

    public static final String tokenPass = "blabla";
    public static final String  idPass = "yo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login();

            }
        });

    }

    // Login Using Volley

    private void login() {

        final String email = etLoginEmail.getText().toString().trim();
        final String password = etLoginPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://bestaidbd.com/app/API/user_authenticate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String token = jsonObject.getString("token");
                            JSONArray dataArray = jsonObject.getJSONArray("user_authenticate");

                            if (status.equals("1")) {

                                for (int i = 0; i < dataArray.length(); i++) {

                                    JSONObject dataobj = dataArray.getJSONObject(i);

                                    String id = dataobj.getString("user_id");
                                    //              String token = dataobj.getString("token");

                                    SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
                                    sharedPreferences.edit().putString("token", token).putString("id", id).apply();


                                    Toast.makeText(getApplicationContext(),"id :"+token,Toast.LENGTH_SHORT).show();

                             //       tvShow.setText(id);
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                  /*  intent.putExtra(tokenPass,token);
                                    intent.putExtra(idPass,id);*/
                                    startActivity(intent);
/*

                                String name = dataobj.getString("user_Name");
                                String blood = dataobj.getString("user_profile_blood_group");
                                Donor donor = new Donor(name,blood);

                                donorList.add(donor);
*/

                                    //       name = dataobj.getString("user_Name");
                                    //      blood = dataobj.getString("user_profile_blood_group");
                                    //     Toast.makeText(ActivityBlood.this, "Question Upload Successfully", Toast.LENGTH_SHORT).show();
                                    //    hobby = dataobj.getString("hobby");
                                }

                                //                          tvName.setText(name);
                                //
                                //                          tvBlood.setText(blood);

                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //        adapter.notifyDataSetChanged();
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                params.put("login", key);
                //   params.put("questions_description",question);

                return params;
            }
        };

        //  Volley.newRequestQueue(this).add(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
