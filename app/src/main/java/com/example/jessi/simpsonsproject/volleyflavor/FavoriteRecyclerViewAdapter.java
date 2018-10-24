package com.example.jessi.simpsonsproject.volleyflavor;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

public class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "CustomArrayAdapter";
    DBHelper dbHelper;
    private Context context;
    private List<CharacterItem> characterItemList;

    public FavoriteRecyclerViewAdapter(Context context, List<CharacterItem> characterItems) {
        this.context = context;
        dbHelper = new DBHelper(context);
        this.characterItemList = getCharacterQuantity(characterItems);
        //this.characterItemList.get(0).setFavorite(true);

    }

    private List<CharacterItem> getCharacterQuantity(List<CharacterItem> characterItems){
        Log.d(TAG, "getAllCharacterFavorite: ");
        Cursor cursor = dbHelper.getData();
        while(cursor.moveToNext()){
            Log.d(TAG, "\n\ngetCharacterFavorite: ============================================");
            Log.d(TAG, "getCharacterFavorite: Cursor ID: "+  cursor.getString(0));
            Log.d(TAG, "getCharacterFavorite: Cursor Name: "+  cursor.getString(1));

            for(int i = 0; i < characterItems.size(); i++){
                Log.d(TAG, "getCharacterFavorite: FOR i =" +i);
                Log.d(TAG, "getCharacterFavorite: name = " + characterItems.get(i).getName());
                if(cursor.getString(1).contentEquals(characterItems.get(i).getName())){
                    characterItems.get(i).setQuantity(cursor.getShort(3));
                }
            }

        }
        return characterItems;
    }

    @NonNull
    @Override //CREATS VIEWHOLDER
    public FavoriteRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.list_item_favorite, viewGroup, false);
        FavoriteRecyclerViewAdapter.MyViewHolder myViewHolder = new FavoriteRecyclerViewAdapter.MyViewHolder(view, this.context, this.characterItemList);
        return myViewHolder;
    }

    @Override //BINDS SERVER to-->JAVA OBJECT to--> XML ID
    public void onBindViewHolder(@NonNull final FavoriteRecyclerViewAdapter.MyViewHolder myViewHolder, final int pos) {

        myViewHolder.tvCharacterName.setText(characterItemList.get(pos).getName());
        myViewHolder.tvQuantity.setText( Integer.toString(characterItemList.get(pos).getQuantity()));
        myViewHolder.ivUpCheveron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(characterItemList.get(pos).getQuantity() < 10)
                {
                    characterItemList.get(pos).setQuantity(characterItemList.get(pos).getQuantity() + 1);
                    dbHelper.updateQuantity(characterItemList.get(pos).getName(), Integer.toString(characterItemList.get(pos).getQuantity()));
                }

                myViewHolder.tvQuantity.setText( Integer.toString(characterItemList.get(pos).getQuantity()));

            }
        });

        myViewHolder.ivDownCheveron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(characterItemList.get(pos).getQuantity() > 0)
                {
                    characterItemList.get(pos).setQuantity(characterItemList.get(pos).getQuantity() - 1);
                    dbHelper.updateQuantity(characterItemList.get(pos).getName(), Integer.toString(characterItemList.get(pos).getQuantity()));
                }

                myViewHolder.tvQuantity.setText( Integer.toString(characterItemList.get(pos).getQuantity()));
            }
        });

        if(!characterItemList.get(pos).getImageUrl().isEmpty())
        {
            Picasso.get().load(characterItemList.get(pos).getImageUrl())
                    .placeholder(R.drawable.default_image)
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


    }

    @Override
    public int getItemCount() {
        return characterItemList.size();
    }

    //CONNECTS THE XML IDs TO THE JAVA CLASS OBJECT
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbNail;
        TextView tvCharacterName;
        TextView tvQuantity;
        ImageView ivUpCheveron;
        ImageView ivDownCheveron;


        List<CharacterItem > characterItems;
        Context context;

        public MyViewHolder(@NonNull View itemView, Context context, List<CharacterItem> characterItems) {
            super(itemView);
            this.context = context;
            this.characterItems = characterItems;
            this.ivThumbNail = itemView.findViewById(R.id.iv_thumbnail_fav);
            this.tvCharacterName = itemView.findViewById(R.id.tv_character_fav);
            this.ivUpCheveron = itemView.findViewById(R.id.iv_up_chevron);
            this.ivDownCheveron = itemView.findViewById(R.id.iv_down_chevron);
            this.tvQuantity = itemView.findViewById(R.id.tv_quantity);
        }
    }
}
