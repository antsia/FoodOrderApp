package com.antasexample.loginapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BackgroundTask().execute();

        setTitle("Sveiki!");

        final Button bOrder = (Button) findViewById(R.id.bOrder);
        final Button bEdit = (Button) findViewById(R.id.bEdit);
        final Button bLogout = (Button) findViewById(R.id.bLogout);





        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserAreaActivity.class);
                MainActivity.this.startActivity(intent);
            }
    });
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActvity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        onBackPressed();    //kai spaudziamas back mygtukas, neleidziama grizt i loginActivity, isskyrus paspaudus atsijungti

}
    @Override
    public void onBackPressed() {
    // super.onBackPressed(); commented this line in order to disable back press
    //Write your code here
        //Toast.makeText(getApplicationContext(), "Išeiti negalima!", Toast.LENGTH_SHORT).show();
    }

    public void getJSON(View view){



    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
            json_url = "http://antsia.stud.if.ktu.lt/users/categories.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((JSON_STRING = bufferedReader.readLine())!= null){

                    stringBuilder.append(JSON_STRING+ "\n");

                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {


            json_string = result;
        }
    }


    public void parseJSON(View view){

        new BackgroundTask().execute();

        if (json_string == null){
            Toast.makeText(getApplicationContext(), "First Get JSON", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, DisplayListView.class);
            intent.putExtra("json_data", json_string);
            startActivity(intent);
        }
    }
}

