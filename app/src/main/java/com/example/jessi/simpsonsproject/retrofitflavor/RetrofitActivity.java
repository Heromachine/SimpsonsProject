package com.example.jessi.simpsonsproject.retrofitflavor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jessi.simpsonsproject.CharacterActivity;
import com.example.jessi.simpsonsproject.R;
import com.example.jessi.simpsonsproject.models.AllCharacters;
import com.example.jessi.simpsonsproject.models.CharacterItem;
import com.example.jessi.simpsonsproject.models.Simpsons;
import com.example.jessi.simpsonsproject.retrofit.ApiService;
import com.example.jessi.simpsonsproject.retrofit.RetrofitInstance;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final static String jSonUrl = "http://api.duckduckgo.com/?q=simpsons+characters&format=json";
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    ImageView ivStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ivStart = findViewById(R.id.iv_star);

        retrofitCall();
    }

    private void retrofitCall(){
        Log.d(TAG, "retrofitCall: ");
        ApiService apiService = RetrofitInstance.getRetrofitInstance()
                .create(ApiService.class);
        Call<Simpsons> simpsonsCall = apiService.getRelatedTopics();
        simpsonsCall.enqueue(new Callback<Simpsons>() {
            @Override
            public void onResponse(Call<Simpsons> call, retrofit2.Response<Simpsons> response) {
                final List<String> names = new ArrayList<String>();
                final AllCharacters allCharacters = new AllCharacters();
                Log.d(TAG, "onResponse: " + response.body().getRelatedTopicsList().toString());
                Simpsons simpsons = response.body();
                for (int i = 0; i < simpsons.getRelatedTopicsList().size(); i++) {
                    Log.d(TAG, "onResponse: Simpsons" + simpsons.getRelatedTopicsList().get(0));

                    CharacterItem characterItem = new CharacterItem(
                            response.body().getRelatedTopicsList().get(i).getText(),
                            response.body().getRelatedTopicsList().get(i).getIcons().getURL());
                    names.add((i + 1) + ")" + characterItem.getName());
                    allCharacters.addCharacter(characterItem);
                }
                arrayAdapter = new ArrayAdapter<String>
                        (
                                RetrofitActivity.this,
                                R.layout.listitem,
                                R.id.tv_character,
                                names
                        );

                listView = findViewById(R.id.lv_names_retrofit);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent mIntent = new Intent(
                                RetrofitActivity.this,
                                CharacterActivity.class);
                        Bundle mBundle = new Bundle();
                        mBundle.putString(
                                "Name", allCharacters.getCharacterItemList().get(i).getName());
                        mBundle.putString(
                                "Description", allCharacters.getCharacterItemList().get(i).getDescription());
                        mBundle.putString(
                                "ImageURL", allCharacters.getCharacterItemList().get(i).getImageUrl());
                        mIntent.putExtras(mBundle);
                        startActivity(mIntent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Simpsons> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
