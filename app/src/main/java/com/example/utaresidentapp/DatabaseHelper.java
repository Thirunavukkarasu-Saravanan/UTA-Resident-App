package com.example.utaresidentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static SQLiteDatabase sqliteDb;

    private static DatabaseHelper instance;

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME ="resdntapp.db";
    public static final String TABLE_NAME ="mainusers";
    public static final String COL_1="id";
    public static final String COL_2="username";
    public static final String COL_3="password ";


    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE mainusers( id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");
        Log.d("Sara_dbhelper", "tablecreated");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }




    public long addUser(int id, String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", id);
        contentValues.put("username", user);
        contentValues.put("password",password);

        long res = db.insert("mainusers" , null, contentValues);
        Log.d(
                "querytag","sara created"

        );
        db.close();
        return res;
    }


    public boolean checkUser(String username, String password){
        String[] columns ={ COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return  false;

    }
}
