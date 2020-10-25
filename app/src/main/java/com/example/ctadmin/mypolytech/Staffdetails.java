package com.example.ctadmin.mypolytech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Staffdetails extends AppCompatActivity {
    ArrayList<StaffData> StaffDataArrayList;
    private recycleAdapter rvAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    String branch;
    ImageView back,logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffdetails);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        back = (ImageView)  findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //data comes from staff_select.java
        Intent i= getIntent();
        Bundle b = i.getExtras();

        if(b!=null)
        {
             branch =(String) b.get("branch");
        }

        recyclerView = (RecyclerView) findViewById(R.id.or);
        fetchingJSON();
    }

    private void fetchingJSON(){

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_STAFF,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.d("Response : ",response);
                        try {
                            StaffDataArrayList = new ArrayList<>();

                                JSONArray array =  new JSONArray(response);

                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject obj = array.getJSONObject(i);

                                    StaffDataArrayList.add(new StaffData(
                                            obj.getString("id"),
                                            obj.getString("name"),
                                            obj.getString("dept"),
                                            obj.getString("charge"),
                                            obj.getString("mob"),
                                            obj.getString("image")
                                    ));

                               }
                            setupRecycler();

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("branch", branch);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
          //RequestQueue requestQueue = Volley.newRequestQueue(this);
          //requestQueue.add(stringRequest);
    }
    private void setupRecycler(){

        rvAdapter = new recycleAdapter(this, StaffDataArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

}
