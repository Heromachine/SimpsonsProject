package com.example.jessi.simpsonsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CharacterActivity extends AppCompatActivity {

    TextView  characterName;
    TextView  characterDescription;
    ImageView characterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character);

        characterName = findViewById(R.id.tv_name);
        characterDescription = findViewById(R.id.tv_description);
        characterImage = findViewById(R.id.iv_character);

        characterName.setText(getIntent().getExtras().getString("Name"));
        characterDescription.setText(getIntent().getExtras().getString("Description"));

        if(!getIntent().getExtras().getString("ImageURL").isEmpty())
        {
            Picasso.get().load(getIntent().getExtras().getString("ImageURL")).into(characterImage);
        }
        else
        {
            characterImage.setImageResource(R.drawable.ic_launcher_background);
        }



    }
}
