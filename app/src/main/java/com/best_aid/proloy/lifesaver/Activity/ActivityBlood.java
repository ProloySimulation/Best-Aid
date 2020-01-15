package com.best_aid.proloy.lifesaver.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.best_aid.proloy.lifesaver.Adapter.BloodDonorAdapter;
import com.best_aid.proloy.lifesaver.Fragment.SingleChoiceDialogFragment;
import com.best_aid.proloy.lifesaver.Model.Donor;
import com.best_aid.proloy.lifesaver.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityBlood extends AppCompatActivity implements SingleChoiceDialogFragment.SingleChoiceListener {

    Button btnBloodGroup ;
    TextView tvSelect , tvName , tvBlood;
    String key = "give_him_the_all_donor";
    String key1 = "give_him_donor_of_blood_group";


    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Donor> donorList;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);

        btnBloodGroup = findViewById(R.id.btnBloodGroup);
        tvSelect = findViewById(R.id.tvSelect);
        tvName = findViewById(R.id.tvName);
        //  tvBlood = findViewById(R.id.bloodGroup);

        mList = findViewById(R.id.rvDonor);

        donorList = new ArrayList<>();
        adapter = new BloodDonorAdapter(getApplicationContext(),donorList);

        linearLayoutManager = new LinearLayoutManager(ActivityBlood.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);


        bloodDonor();
        btnBloodGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment singleChoiceDialog = new SingleChoiceDialogFragment();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
                donorList.clear();
                adapter.notifyDataSetChanged();

            }
        });
    }

    private void bloodDonor() {

      /*  Intent intent = getIntent();
        final String tokeRecieve = intent.getStringExtra(ActivityLogin.tokenPass);
        final String idRecieve = intent.getStringExtra(ActivityLogin.idPass);*/

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        final String tokeRecieve = sharedPreferences.getString("token", null);
        final String idRecieve = sharedPreferences.getString("id", null);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://bestaidbd.com/app/API/get_blood_donor.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray dataArray = jsonObject.getJSONArray("blood_donor");
                            for (int i = 0; i < dataArray.length(); i++) {

                                JSONObject dataobj = dataArray.getJSONObject(i);

                                String name = dataobj.getString("user_Name");
                                String blood = dataobj.getString("user_profile_blood_group");
                                String number = dataobj.getString("user_PhoneNo");
                                Donor donor = new Donor(name,blood,number);

                                donorList.add(donor);

                                //       name = dataobj.getString("user_Name");
                                //      blood = dataobj.getString("user_profile_blood_group");
                                Toast.makeText(ActivityBlood.this, blood, Toast.LENGTH_SHORT).show();
                                //    hobby = dataobj.getString("hobby");
                            }

                            //                          tvName.setText(name);
                            //                          tvBlood.setText(blood);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter.notifyDataSetChanged();
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("user_id", idRecieve);
                params.put("token", tokeRecieve);
                params.put("get_blood_donor", key);
                //   params.put("questions_description",question);

                return params;
            }
        };

        //  Volley.newRequestQueue(this).add(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        adapter.notifyItemRemoved(position);
        tvSelect.setText( list[position]+" "+"রক্তদাতাদের লিস্ট");
        String group = list[position];
        selectedBloodGroup(group);
    }

    private void selectedBloodGroup(final String group) {

        /*Intent intent = getIntent();
        final String tokeRecieve = "77503b76e60b919d0d4d40223fd63a5d6f862d51";
        final String idRecieve = "3";*/

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        final String tokeRecieve = sharedPreferences.getString("token", null);
        final String idRecieve = sharedPreferences.getString("id", null);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://bestaidbd.com/app/API/get_blood_donor.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray dataArray = jsonObject.getJSONArray("blood_donor");
                            for (int i = 0; i < dataArray.length(); i++) {

                                JSONObject dataobj = dataArray.getJSONObject(i);

                                String name = dataobj.getString("user_Name");
                                String blood = dataobj.getString("user_profile_blood_group");
                                String number = dataobj.getString("user_PhoneNo");
                                Donor donor = new Donor(name,blood,number);

                                donorList.add(donor);

                                //       name = dataobj.getString("user_Name");
                                //      blood = dataobj.getString("user_profile_blood_group");
                                Toast.makeText(ActivityBlood.this, blood, Toast.LENGTH_SHORT).show();
                                //    hobby = dataobj.getString("hobby");
                            }

                            //                          tvName.setText(name);
                            //                          tvBlood.setText(blood);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter.notifyDataSetChanged();
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("user_id", idRecieve);
                params.put("token", tokeRecieve);
                params.put("get_blood_donor", key1);
                params.put("blood_group",group);
                //   params.put("questions_description",question);

                return params;
            }
        };

        //  Volley.newRequestQueue(this).add(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onNegativeButtonClicked() {
        tvSelect.setText("Dialog cancel");
    }
}
