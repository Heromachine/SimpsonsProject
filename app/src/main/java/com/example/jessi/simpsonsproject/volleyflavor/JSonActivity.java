package com.example.jessi.simpsonsproject.volleyflavor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.simpsonsproject.BuildConfig;
import com.example.jessi.simpsonsproject.data.DBHelper;
import com.example.jessi.simpsonsproject.utils.AppController;
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

    Button btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_characters);
        btnFavorite = findViewById(R.id.btn_favorite);
        volleyCall(FINAL_URL);
//        btnFavorite.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(JSonActivity.this, FavoritesActivity.class);
////                startActivity(intent);
////                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
////            }
////        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all_characters, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.btn_fav)
        {
            Intent intent = new Intent(JSonActivity.this, FavoritesActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
        }
        return super.onOptionsItemSelected(item);
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
//                                            R.layout.list_item_all,
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
