package com.myapplicationdev.android.tniyurl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editText);
        bt = findViewById(R.id.btnChange);
        tv = findViewById(R.id.tvShort);


    }

    @Override
    protected void onResume() {
        super.onResume();

        // Code for step 1 start
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String longurl = et.getText().toString().trim();
                String url = "http://tiny-url.info/api/v1/create?apikey=6AA47368501E60870ED3&provider=0l_ro&format=text&url="+longurl;
                HttpRequest request = new HttpRequest(url);
                request.setOnHttpResponseListener(mHttpResponseListener);
                request.setMethod("GET");
                request.execute();            }
        });

        // Code for step 1 end
    }

    // Code for step 2 start
    private HttpRequest.OnHttpResponseListener mHttpResponseListener =
            new HttpRequest.OnHttpResponseListener() {
                @Override
                public void onResponse(String response){

                    // process response here
                    try {
                        tv.setText(response);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                }
            };
}
