package com.example.jessi.simpsonsproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";

    private static final String TABLE_NAME = "favorite_characters02";

    private static final String COL_0 = "ID";
    private static final String COL_1 = "Name";
    private static final String COL_2 = "URL";
    private static final String COL_3 = "Quantity";
    private static final String COL_4 = "Description";



    public DBHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
        Log.d(TAG, "DBHelper: ");

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "onCreate: ");
        String createTable =
                "CREATE TABLE " + TABLE_NAME
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_1 + " TEXT,"
                + COL_2 + " TEXT,"
                + COL_3 + " TEXT,"
                + COL_4 + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        Log.d(TAG, "onUpgrade: ");
////        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
////        onCreate(sqLiteDatabase);
    }

    public boolean addCharacter(String name, String url, String description ){
        Log.d(TAG, "addName: ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, url);
        contentValues.put(COL_4, description);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean addName(String item){
        Log.d(TAG, "addName: ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, item);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean addURL(String item){
        Log.d(TAG, "addName: ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, item);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean deleteRow(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_1 + "= ?", new String[] {name}) > 0;
    }

    public void updateQuantity(String name, String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME
                + " SET "    + COL_3 + " = '"+ quantity
                + "' WHERE " + COL_1 + " = '"  + name + "'";
         db.execSQL(query);
    }

    public Cursor getData(){
        Log.d(TAG, "getData: ");
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
