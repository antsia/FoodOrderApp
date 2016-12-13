package com.antasexample.loginapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.antasexample.loginapp.OrderRequest.JSON_ARRAY;

public class OrderActivity extends AppCompatActivity {

    private TextView tvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tvCategories = (TextView) findViewById(R.id.tvCategories);
        getData();

    }
    private void getData() {

        String url = OrderRequest.ORDER_REQUEST_URL.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(OrderActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void showJSON(String response){
        String id = "";
        String name = "";
        String description = "";

        try {


            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(JSON_ARRAY);

            JSONObject categoryData = result.getJSONObject(0);
            id = categoryData.getString(OrderRequest.ID);
            name = categoryData.getString(OrderRequest.NAME);
            description = categoryData.getString(OrderRequest.DESCRIPTION);


            Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //for(int j=0; j<count; j++)
        tvCategories.setText("ID:\t" + id + "\nKategorija:\t"+name+"\nAprašymas:\t" +description);
    }


}
