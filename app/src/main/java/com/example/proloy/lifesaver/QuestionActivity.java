package com.example.proloy.lifesaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity {

    private Button btnSubmit;
    private EditText etWriteQuestion;
    private TextView tvQuestions;
    String type = "anonomious";
    String qu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        btnSubmit = findViewById(R.id.btnSubmit);
        etWriteQuestion = findViewById(R.id.etWriteQuestion);
        tvQuestions = findViewById(R.id.tvQuestions);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postQuestion();
            }
        });

    }

    private void postQuestion() {

        final String question = etWriteQuestion.toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://bestaidbd.com/app/API/get_questions.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(QuestionActivity.this, "Question Upload Successfully", Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                                JSONArray dataArray = jsonObject.getJSONArray("questions");
                                for (int i = 0; i < dataArray.length(); i++) {

                                    JSONObject dataobj = dataArray.getJSONObject(i);
                                //    firstName = dataobj.getString("name");
                                //    hobby = dataobj.getString("hobby");
                                }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


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
             //   params.put("questions_description",question);

                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
