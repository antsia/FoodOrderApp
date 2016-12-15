package com.antasexample.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {

    String json_string;

    JSONObject jsonObject;
    JSONArray jsonArray;

    CategoryAdapter categoryAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        listView = (ListView) findViewById(R.id.listview);

        categoryAdapter = new CategoryAdapter(this, R.layout.row_layout);
        listView.setAdapter(categoryAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("result");
            int count = 0;
            String id, name, description;
            while (count < jsonArray.length()){

                JSONObject JO = jsonArray.getJSONObject(count);
                    id = JO.getString("id");
                    name = JO.getString("name");
                    description = JO.getString("description");
                    Categories categories = new Categories(id, name, description);
                    categoryAdapter.add(categories);
                    count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
