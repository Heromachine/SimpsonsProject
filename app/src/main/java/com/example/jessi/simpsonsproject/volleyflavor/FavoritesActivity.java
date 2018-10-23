package com.example.jessi.simpsonsproject.volleyflavor;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jessi.simpsonsproject.R;
import com.example.jessi.simpsonsproject.data.DBHelper;
import com.example.jessi.simpsonsproject.models.AllCharacters;
import com.example.jessi.simpsonsproject.models.CharacterItem;

public class FavoritesActivity extends AppCompatActivity {

    private static final String TAG = "FavoritesActivity";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter customArrayAdapter;
    private  AllCharacters allCharacters;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        dbHelper = new DBHelper(this);
        allCharacters = new AllCharacters();

        recyclerView = findViewById(R.id.rv_favorite);
        layoutManager = new LinearLayoutManager(FavoritesActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        customArrayAdapter = new FavoriteRecyclerViewAdapter(
                FavoritesActivity
                        .this,
                getAllCharacterFavorite(allCharacters)
                        .getCharacterItemList());
        recyclerView.setAdapter(customArrayAdapter);

    }


    private AllCharacters getAllCharacterFavorite(AllCharacters allCharacters){
        Log.d(TAG, "getAllCharacterFavorite: ");
        Cursor cursor = dbHelper.getData();

        int i = 0;
        while(cursor.moveToNext()){

            CharacterItem characterItem = new CharacterItem();
            characterItem.setName(cursor.getString(1));
            characterItem.setImageUrl(cursor.getString(2));
            characterItem.setDescription(cursor.getString(4));
            allCharacters.getCharacterItemList().add(characterItem);

//            Log.d(TAG, "getAllCharacterFavorite: " + allCharacters.getCharacterItemList().get(i).getName());
//            i++;
        }
       return allCharacters;
    }

}
