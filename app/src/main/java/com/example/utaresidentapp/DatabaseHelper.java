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

    private static String STRING2 = null;
    private static SQLiteDatabase sqliteDb;

    private static DatabaseHelper instance;

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME ="resident1.db";
    public static final String TABLE_NAME ="mainusers";
    public static final String TABLE_NAME2 ="mainaparatment";
    public static final String COL_1="utaid";
    public static final String COL_2="us_id";
    public static final String COL_3="pass_word";
    public static final String COL_4="userrole";
    public static final String COL_5="username";
    public static final String COL_6="phone";
    public static final String COL_7="aptblock";
    public static final String COL_8="emerphone";
    public static final String COL_9="aptno";
    public static final String COL_10="graddt";
    public static final String COL_11="apt_id";
    public static final String COL_12="apart_name";
    public static final String COL_13="apart_block";
    public static final String COL_14="apart_number";





    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE mainusers( us_id TEXT  , " +
                "username TEXT, " +
                "utaid INTEGER PRIMARY KEY, " +
                "phone INTEGER, " +
                "aptblock INTEGER, " +
                "emerphone INTEGER, " +
                "aptno INTEGER, " +
                "graddt INTEGER, " +
                "pass_word INTEGER, " +
                "userrole INTEGER)");
        Log.d("Sara_dbhelper", "tablecreated");


        /*sqLiteDatabase.execSQL("CREATE TABLE mainaparatment( apt_id INTEGER PRIMARY KEY AUTOINCREMENT  , " +
                "apart_name  TEXT, " +
                "apart_block INTEGER, " +
                "apart_number  INTEGER)");
        Log.d("Sara_dbhelper", "apartment table created");*/

        STRING2 = ("CREATE TABLE mainaparatment( apt_id INTEGER PRIMARY KEY AUTOINCREMENT  , " +
                "apart_name  TEXT, " +
                "apart_block INTEGER, " +
                "apart_number  INTEGER)");

        sqLiteDatabase.execSQL(STRING2);
        Log.d("Sara_dbhelper", "apartment table created");





    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(sqLiteDatabase);
        sqliteDb.execSQL(STRING2);

    }




    public long addUser(String s_id,
                        String s_username,
                        String s_utaid,
                        String s_phone,
                        String s_aptblock,
                        String s_emerphone,
                        String s_aptno,
                        String s_graddt,
                        String s_password,
                        String s_userrole)
                        {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("us_id", s_id);
        contentValues.put("username", s_username);
        contentValues.put("utaid", s_utaid);
        contentValues.put("phone",s_phone);
        contentValues.put("aptblock",s_aptblock);
        contentValues.put("emerphone",s_emerphone);
        contentValues.put("aptno",s_aptno);
        contentValues.put("graddt",s_graddt);
        contentValues.put("pass_word",s_password);
        contentValues.put("userrole",s_userrole);



        long res = db.insert("mainusers" , null, contentValues);
        Log.d(
                "querytag","sara created" + res

        );
        db.close();
        return res;
    }

    public long UpdateProfile(String s_id,
                        String s_username,
                        String s_utaid,
                        String s_phone,
                        String s_aptblock,
                        String s_emerphone,
                        String s_aptno,
                        String s_graddt,
                        String s_password,
                        String s_userrole)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("us_id", s_id);
        contentValues.put("username", s_username);
        contentValues.put("utaid", s_utaid);
        contentValues.put("phone",s_phone);
        contentValues.put("aptblock",s_aptblock);
        contentValues.put("emerphone",s_emerphone);
        contentValues.put("aptno",s_aptno);
        contentValues.put("graddt",s_graddt);
        contentValues.put("pass_word",s_password);
        contentValues.put("userrole",s_userrole);



        long res = db.update("mainusers" , contentValues, "us_id=?",new String[]{ s_id});
        Log.d(
                "querytag","Profile updated" + res

        );
        db.close();
        return res;
    }





    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2,null);
        return data;
    }


    public Cursor getProfile(String us_id){
        Log.d(
                "sara_login_session","Profile updated" + us_id

        );
        String[] columns ={ COL_1,COL_2,COL_3,COL_4,COL_5,COL_6,COL_7,COL_8,COL_9, COL_10 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?";
        String[] selectionArgs = {us_id};
        Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
        return cursor;
    }

    public Cursor modifyProfile(String utaid){
        String[] columns ={ COL_1,COL_2,COL_3,COL_4,COL_5,COL_6,COL_7,COL_8,COL_9, COL_10 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_1 + "=?";
        String[] selectionArgs = {utaid};
        Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
        return cursor;
    }

    public boolean checkUser(String username, String password){
        String[] columns ={ COL_1, COL_4 };
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




    public long addapart(String a_name,String a_block,String a_number)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       // contentValues.put("apt_id", apt_id);
        contentValues.put("apart_name", a_name);
        contentValues.put("apart_block", a_block);
        contentValues.put("apart_number", a_number);

        long aptres = db.insert("mainaparatment" , null, contentValues);
        Log.d(
                "querytag","sara created" + aptres

        );
        db.close();
        //return res;



        return aptres;
    }



}
