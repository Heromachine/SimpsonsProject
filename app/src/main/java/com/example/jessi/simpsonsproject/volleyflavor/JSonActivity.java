package com.example.jessi.simpsonsproject.volleyflavor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.simpsonsproject.BuildConfig;
import com.example.jessi.simpsonsproject.data.DBHelper;
import com.example.jessi.simpsonsproject.utils.AppController;
import com.example.jessi.simpsonsproject.CharacterActivity;
import com.example.jessi.simpsonsproject.R;
import com.example.jessi.simpsonsproject.models.AllCharacters;
import com.example.jessi.simpsonsproject.models.CharacterItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSonActivity extends AppCompatActivity {

    private static final String TAG = "JSonActivity";
    private final static String FINAL_URL = BuildConfig.SERVER_URL_SIMP;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter customArrayAdapter;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_characters);
        dbHelper = new DBHelper(this);
        volleyCall(FINAL_URL);
    }


    private void addData(String newEntry){
        boolean insertData = dbHelper.addDATA(newEntry);
        if(insertData){
            Log.d(TAG, "addData: PASSED" );
        }
        else {
            Log.d(TAG, "addData: FAILED");
        }
    }
    private void initDataBase(AllCharacters allCharacters){
        for(int i = 0; i< allCharacters.getCharacterItemList().size(); i++){

            addData(allCharacters.getCharacterItemList().get(i).getName());
        }


    }

    private void volleyCall(String url) {
        Log.d(TAG, "volleyCall: ");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: ");
                        try {
                            JSONArray jSonArrRelatedTopics = response.getJSONArray("RelatedTopics");
                            final List<String> names = new ArrayList<String>();
                            final AllCharacters allCharacters = new AllCharacters();
                            for (int i = 0; i < jSonArrRelatedTopics.length(); i++) {
                                JSONObject jsonObject1 = jSonArrRelatedTopics.getJSONObject(i);
                                JSONObject jSonObjIcon = jSonArrRelatedTopics.getJSONObject(i).getJSONObject("Icon");
                                String url = jSonObjIcon.getString("URL");
                                CharacterItem characterItem = new CharacterItem(jsonObject1.getString("Text"), url);
                                names.add((i+1) +")"+ characterItem.getName());
                                allCharacters.addCharacter(characterItem);
                                Log.d(TAG, "onResponse: Name: " +  characterItem.getName());
                            }

                            initDataBase(allCharacters);
                            recyclerView = findViewById(R.id.rv_characters);
                            layoutManager = new LinearLayoutManager(JSonActivity.this);
                            recyclerView.setLayoutManager(layoutManager);
                            customArrayAdapter = new CustomArrayAdapter(JSonActivity.this, allCharacters.getCharacterItemList());
                            recyclerView.setAdapter(customArrayAdapter);


                        } catch (JSONException e) {
                            Log.d(TAG, "onResponse: Exception"+ e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: Error" + error.getMessage());
                error.printStackTrace();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }




//    private void volleyCall(String url) {
//        Log.d(TAG, "volleyCall: ");
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
//                                CharacterItem characterItem = new CharacterItem(jsonObject1.getString("Text"), url);
//                                names.add((i+1) +")"+ characterItem.getName());
//                                allCharacters.addCharacter(characterItem);
//                                Log.d(TAG, "onResponse: Name: " +  characterItem.getName());
//                            }
//                            arrayAdapter = new ArrayAdapter<String>
//                                    (
//                                            JSonActivity.this,
//                                            R.layout.listitem,
//                                            R.id.tv_character,
//                                            names
//                                    );
//
//                            listView = findViewById(R.id.lv_names_json);
//                            listView.setAdapter(arrayAdapter);
//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    Intent mIntent = new Intent(JSonActivity.this, CharacterActivity.class);
//                                    Bundle mBundle = new Bundle();
//                                    mBundle.putString("Name", allCharacters.getCharacterItemList().get(i).getName());
//                                    mBundle.putString("Description", allCharacters.getCharacterItemList().get(i).getDescription());
//                                    mBundle.putString("ImageURL", allCharacters.getCharacterItemList().get(i).getImageUrl());
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
