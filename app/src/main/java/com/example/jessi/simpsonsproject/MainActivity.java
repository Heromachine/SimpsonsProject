package com.example.jessi.simpsonsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.simpsonsproject.models.AllCharacters;
import com.example.jessi.simpsonsproject.models.Character;
import com.example.jessi.simpsonsproject.models.RelatedTopics;
import com.example.jessi.simpsonsproject.models.Simpsons;
import com.example.jessi.simpsonsproject.retrofit.ApiService;
import com.example.jessi.simpsonsproject.retrofit.RetrofitInstance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private final static String jSonUrl = "http://api.duckduckgo.com/?q=simpsons+characters&format=json";
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

        btnJSon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JSonActivity.class);
                startActivity(intent);
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RetrofitActivity.class);
                startActivity(intent);

            }
        });

    }

//    private void init() {
//        Log.d(TAG, "init: ");
//        //jSonCall(jSonUrl);
//
//        retrofitCall02();
//    }

//    private void retrofitCall02(){
//
//        Log.d(TAG, "retrofitCall: ");
//        ApiService apiService = RetrofitInstance.getRetrofitInstance()
//                .create(ApiService.class);
//        Call<Simpsons> simpsonsCall = apiService.getRelatedTopics();
//        simpsonsCall.enqueue(new Callback<Simpsons>() {
//            @Override
//            public void onResponse(Call<Simpsons> call, retrofit2.Response<Simpsons> response) {
//                final List<String> names = new ArrayList<String>();
//                final AllCharacters allCharacters = new AllCharacters();
//                Log.d(TAG, "onResponse: " + response.body().getRelatedTopicsList().toString());
//                Simpsons simpsons = response.body();
//                for (int i = 0; i < simpsons.getRelatedTopicsList().size(); i++) {
//                    Log.d(TAG, "onResponse: Simpsons" + simpsons.getRelatedTopicsList().get(0));
//
//                    Character character = new Character(
//                            response.body().getRelatedTopicsList().get(i).getText(),
//                            response.body().getRelatedTopicsList().get(i).getIcons().getURL());
//                    names.add((i + 1) + ")" + character.getName());
//                    allCharacters.addCharacter(character);
//                }
//
//                arrayAdapter = new ArrayAdapter<String>
//                        (
//                                MainActivity.this,
//                                R.layout.listitem,
//                                R.id.tv_character,
//                                names
//                        );
//                listView = findViewById(R.id.lv_names);
//                listView.setAdapter(arrayAdapter);
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Intent mIntent = new Intent(
//                                MainActivity.this,
//                                CharacterActivity.class);
//                        Bundle mBundle = new Bundle();
//                        mBundle.putString(
//                                "Name", allCharacters.getCharacterList().get(i).getName());
//                        mBundle.putString(
//                                "Description", allCharacters.getCharacterList().get(i).getDescription());
//                        mBundle.putString(
//                                "ImageURL", allCharacters.getCharacterList().get(i).getImageUrl());
//                        mIntent.putExtras(mBundle);
//                        startActivity(mIntent);
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call<Simpsons> call, Throwable t) {
//                Log.d(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//    }
//
//    private void jSonCall(String url) {
//        Log.d(TAG, "jSonCall: ");
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
//                Request.Method.GET,
//                url,
//                null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, "onResponse: ");
//                        try {
//                            JSONArray jSonArrRelatedTopics = response.getJSONArray("RelatedTopics");
//                            final List<String> names = new ArrayList<String>();
//                            final AllCharacters allCharacters = new AllCharacters();
//                            for (int i = 0; i < jSonArrRelatedTopics.length(); i++) {
//                                JSONObject jsonObject1 = jSonArrRelatedTopics.getJSONObject(i);
//                                JSONObject jSonObjIcon = jSonArrRelatedTopics.getJSONObject(i).getJSONObject("Icon");
//                                String url = jSonObjIcon.getString("URL");
//                                Character character = new Character(jsonObject1.getString("Text"), url);
//                                names.add((i+1) +")"+character.getName());
//                                allCharacters.addCharacter(character);
//                                Log.d(TAG, "onResponse: Name: " +  character.getName());
//                            }
//                            arrayAdapter = new ArrayAdapter<String>
//                                    (
//                                            MainActivity.this,
//                                            R.layout.listitem,
//                                            R.id.tv_character,
//                                            names
//                                    );
//                            listView = findViewById(R.id.lv_names);
//                            listView.setAdapter(arrayAdapter);
//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    Intent mIntent = new Intent(MainActivity.this, CharacterActivity.class);
//                                    Bundle mBundle = new Bundle();
//                                    mBundle.putString("Name", allCharacters.getCharacterList().get(i).getName());
//                                    mBundle.putString("Description", allCharacters.getCharacterList().get(i).getDescription());
//                                    mBundle.putString("ImageURL", allCharacters.getCharacterList().get(i).getImageUrl());
//                                    mIntent.putExtras(mBundle);
//                                    startActivity(mIntent);
//                                }
//                            });
//
//                        } catch (JSONException e) {
//                            Log.d(TAG, "onResponse: Exception"+ e.getMessage());
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d(TAG, "onErrorResponse: Error" + error.getMessage());
//                error.printStackTrace();
//            }
//        });
//        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
//    }
}
