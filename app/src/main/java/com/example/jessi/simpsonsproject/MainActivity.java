package com.example.jessi.simpsonsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.jessi.simpsonsproject.retrofitflavor.RetrofitActivity;
import com.example.jessi.simpsonsproject.utils.AppController;
import com.example.jessi.simpsonsproject.volleyflavor.JSonActivity;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //private final static String jSonUrl = "http://api.duckduckgo.com/?q=simpsons+characters&format=json";

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    Button btnJSon;
    Button btnRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        btnJSon = findViewById(R.id.btn_json);
        btnRetrofit = findViewById(R.id.btn_retrofit);

        if(BuildConfig.FLAVOR.equals("volley")) {


            btnRetrofit.setEnabled(false);
            btnRetrofit.setText("Disabled");

            btnJSon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, JSonActivity.class);
                    startActivity(intent);
                }
            });
        }else if(BuildConfig.FLAVOR.equals("retrofit")) {
            btnJSon.setEnabled(false);
            btnJSon.setText("Disabled");
            btnRetrofit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, RetrofitActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
