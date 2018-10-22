package com.example.jessi.simpsonsproject.volleyflavor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jessi.simpsonsproject.CharacterActivity;
import com.example.jessi.simpsonsproject.R;
import com.example.jessi.simpsonsproject.data.DBHelper;
import com.example.jessi.simpsonsproject.models.CharacterItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomArrayAdapter extends RecyclerView.Adapter<CustomArrayAdapter.MyViewHolder> {
    private static final String TAG = "CustomArrayAdapter";
    DBHelper dbHelper;
    private Context context;
    private List<CharacterItem> characterItemList;

    public CustomArrayAdapter(Context context, List<CharacterItem> characterItems) {
        this.context = context;
        this.characterItemList = characterItems;
        this.characterItemList.get(0).setFavorite(true);
    }



    @NonNull
    @Override //CREATS VIEWHOLDER
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.listitem, viewGroup, false);
        CustomArrayAdapter.MyViewHolder myViewHolder = new CustomArrayAdapter.MyViewHolder(view, this.context, this.characterItemList);
        return myViewHolder;
    }

    @Override //BINDS SERVER to-->JAVA OBJECT to--> XML ID
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int pos) {

        myViewHolder.tvCharacterName.setText(characterItemList.get(pos).getName());
        if (!characterItemList.get(pos).isFavorite()) {
            myViewHolder.ivStar.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else{
            myViewHolder.ivStar.setImageResource(R.drawable.ic_star_gold_24dp);
        }

        if(!characterItemList.get(pos).getImageUrl().isEmpty())
        {
            Picasso.get().load(characterItemList.get(pos).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(myViewHolder.ivThumbNail);

        }else{
            myViewHolder.ivThumbNail.setImageResource(R.drawable.ic_launcher_background);
        }

        myViewHolder.tvCharacterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(context, CharacterActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("Name", characterItemList.get(pos).getName());
                mBundle.putString("Description", characterItemList.get(pos).getDescription());
                mBundle.putString("ImageURL", characterItemList.get(pos).getImageUrl());
                mIntent.putExtras(mBundle);
                context.startActivity(mIntent);
            }
        });

        myViewHolder.ivStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (characterItemList.get(pos).isFavorite())
                {
                    characterItemList.get(pos).setFavorite(false);
                    myViewHolder.ivStar.setImageResource(R.drawable.ic_star_black_24dp);
                }

                else
                {
                    characterItemList.get(pos).setFavorite(true);
                    myViewHolder.ivStar.setImageResource(R.drawable.ic_star_gold_24dp);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return characterItemList.size();
    }

    //CONNECTS THE XML IDs TO THE JAVA CLASS OBJECT
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbNail;
        TextView tvCharacterName;
        ImageView ivStar;

        List<CharacterItem > characterItems;
        Context context;

        public MyViewHolder(@NonNull View itemView, Context context, List<CharacterItem> characterItems) {
            super(itemView);
            this.context = context;
            this.characterItems = characterItems;
            this.ivThumbNail = itemView.findViewById(R.id.iv_thumbnail);
            this.tvCharacterName = itemView.findViewById(R.id.tv_character);
            this.ivStar = itemView.findViewById(R.id.iv_star);
        }
    }
}
