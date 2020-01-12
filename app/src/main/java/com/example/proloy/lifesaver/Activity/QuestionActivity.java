package com.example.proloy.lifesaver.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.proloy.lifesaver.Adapter.QuestionAdapter;
import com.example.proloy.lifesaver.Model.Question;
import com.example.proloy.lifesaver.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity {

    private RecyclerView mList;
    String postN = "post_question";
    TextView tvClick ;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Question> questionList;
    private RecyclerView.Adapter adapter;


    private TextView tvQuestions;
    private EditText etQuestion ;
    Button btnSubmit;
    String type = "give_him_the_fuck_of_all";
    String qu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mList = findViewById(R.id.rvQuestion);
        etQuestion = findViewById(R.id.etNewQuestion);
        btnSubmit = findViewById(R.id.btnSubmit);

        questionList = new ArrayList<>();
        adapter = new QuestionAdapter(getApplicationContext(),questionList);

        linearLayoutManager = new LinearLayoutManager(QuestionActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        seeQuestions();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postQuestion();
            }
        });

    }

    private void postQuestion() {
/*
        Intent intent = getIntent();
        final String tokeRecieve = intent.getStringExtra(ActivityLogin.tokenPass);
        final String idRecieve = intent.getStringExtra(ActivityLogin.idPass);*/
        final String question = etQuestion.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        final String tokeRecieve = sharedPreferences.getString("token",null);
        final String idRecieve = sharedPreferences.getString("id",null);


        StringRequest request = new StringRequest(Request.Method.POST, "https://bestaidbd.com/app/API/post_question.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");

                            if (status.equals("1"))
                            {
                                Toast.makeText(QuestionActivity.this,"Question Uploaded Successfully",Toast.LENGTH_SHORT).show();

                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            //    Toast.makeText(ActivityRegistration.this,"Error" + e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //    Toast.makeText(ActivityRegistration.this,"Register Error" + error.toString(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("user_id",idRecieve);
                params.put("token",tokeRecieve);
                params.put("post",postN);
                params.put("question",question);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    private void seeQuestions() {

       /* Intent intent = getIntent();
        final String tokeRecieve = intent.getStringExtra(ActivityLogin.tokenPass);
        final String idRecieve = intent.getStringExtra(ActivityLogin.idPass);*/

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        final String tokeRecieve = sharedPreferences.getString("token", null);
        final String idRecieve = sharedPreferences.getString("id", null);

        //      final String question = etWriteQuestion.toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://bestaidbd.com/app/API/get_questions.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //     Toast.makeText(QuestionActivity.this, "Question Upload Successfully", Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray dataArray = jsonObject.getJSONArray("questions");
                            for (int i = 0; i < dataArray.length(); i++) {

                                JSONObject dataobj = dataArray.getJSONObject(i);

                                String questions = dataobj.getString("questions_description");
                                //    hobby = dataobj.getString("hobby");
                                Question question = new Question(questions);
                                questionList.add(question);
                            }



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
                params.put("get_questions", type);
                params.put("user_id",idRecieve);
                params.put("token",tokeRecieve);
                //   params.put("questions_description",question);

                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
