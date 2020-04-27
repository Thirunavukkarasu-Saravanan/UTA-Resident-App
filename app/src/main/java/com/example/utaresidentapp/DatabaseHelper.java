package com.example.utaresidentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String STRING2 = null;
    private static String STRING3 = null;
    private static String STRING4 = null;
    private static SQLiteDatabase sqliteDb;

    private static DatabaseHelper instance;

    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME ="utaresidentapp.db";
    public static final String TABLE_NAME ="mainusers";
    public static final String TABLE_NAME2 ="mainaparatment";
    public static final String TABLE_NAME3 = "mainannouncement";
    public static final String TABLE_NAME4 = "mainworkorder";
    //columns for mainusers
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
    //columns for mainaparatment
    public static final String COL_11="apt_id";
    public static final String COL_12="apart_name";
    public static final String COL_13="apart_block";
    public static final String COL_14="apart_number";
    //columns for mainannouncement
    public static final String COL_1_ANCMNT = "acmnt_id";
    public static final String COL_2_ANCMNT = "acmnt_topic";
    public static final String COL_3_ANCMNT = "acmnt_desc";
    public static final String COL_4_ANCMNT = "acmnt_date";
    public static final String COL_5_ANCMNT = "acmnt_time";
    public static final String COL_6_ANCMNT = "acmnt_by";
    //columns for mainworkorder
    public static final String COL_1_WORDER = "work_id";
    public static final String COL_2_WORDER = "work_requestby";
    public static final String COL_3_WORDER = "work_block";
    public static final String COL_4_WORDER = "work_no";
    public static final String COL_5_WORDER = "work_desc";
    public static final String COL_6_WORDER = "work_date";
    public static final String COL_7_WORDER = "work_time";
    public static final String COL_8_WORDER = "work_status";
    //public static final String COL_9_WORDER = "work_id";










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

        STRING3 = ("CREATE TABLE mainannouncement( acmnt_id INTEGER PRIMARY KEY AUTOINCREMENT  , " +
                "acmnt_topic  TEXT, " +
                "acmnt_desc TEXT, " +
                "acmnt_date TEXT, " +
                "acmnt_time TEXT, " +
                "acmnt_by  TEXT)");

        sqLiteDatabase.execSQL(STRING3);

        STRING4 = ("CREATE TABLE mainworkorder( work_id INTEGER PRIMARY KEY AUTOINCREMENT  , " +
                "work_requestby  TEXT, " +
                "work_block TEXT, " +
                "work_no TEXT, " +
                "work_desc TEXT, " +
                "work_date TEXT, " +
                "work_time TEXT, " +
                "work_status TEXT) ");
        sqLiteDatabase.execSQL(STRING4);





    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(sqLiteDatabase);
        sqliteDb.execSQL(STRING2);
        sqliteDb.execSQL(STRING3);
        sqliteDb.execSQL(STRING4);

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



    public Cursor getWorkOrder(String user_id){
        Log.d(
                "sara_login_session","getWorkOrderuserid :" + user_id

        );

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME4,null);
        return data;
    }




    public Cursor getWorkOrderRequest(String work_id){
//        Log.d(
//                "sara_login_session","Profile updated" + us_id
//
//        );
        String[] columns ={ COL_1_WORDER,COL_2_WORDER,COL_3_WORDER,COL_4_WORDER,COL_5_WORDER,COL_6_WORDER,COL_7_WORDER,COL_8_WORDER};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_1_WORDER + "=?";
        String[] selectionArgs = {work_id};
        Cursor cursor = db.query(TABLE_NAME4, columns,selection, selectionArgs, null,null,null);
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


    public Cursor checkRole(String username){
        String[] columns ={ COL_4 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
        return cursor;

    }

    public Cursor getaptdetails(String username){
        String[] columns ={ COL_7,COL_9 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(TABLE_NAME, columns,selection, selectionArgs, null,null,null);
        return cursor;

    }

    //Method to retrieve data for Update Apartment details for selected Item

    public Cursor getapt(int apart_id){
        String[] columns ={ COL_11,COL_12,COL_13,COL_14 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_11 + "=?";
        String[] selectionArgs = new String[]{String.valueOf(apart_id)};
        Cursor cursor = db.query(TABLE_NAME2, columns,selection, selectionArgs, null,null,null);
        return cursor;


    }

    //Method to update data for Update Apartment details for selected Item

    public int updapt(int apart_id, String upd_apt_name, String upd_apt_block , String upd_apt_num){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("apart_name", upd_apt_name);
        contentValues.put("apart_block", upd_apt_block);
        contentValues.put("apart_number", upd_apt_num);


        int cursor;
        cursor = db.update("mainaparatment" , contentValues, "apt_id=?",new String[]{String.valueOf(apart_id)});
        Log.d(
                "querytag","Profile updated" + cursor

        );
        db.close();
        return cursor;


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
        return aptres;
    }


    public long reqworkorder(String w_requestby,String w_block,String w_no,String w_desc,String w_date,String w_time,String w_status)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       // contentValues.put("work_id", w_id);
        contentValues.put("work_requestby", w_requestby);
        contentValues.put("work_block", w_block);
        contentValues.put("work_no", w_no);
        contentValues.put("work_desc", w_desc);
        contentValues.put("work_date", w_date);
        contentValues.put("work_time", w_time);
        contentValues.put("work_status", w_status);


        long workres = db.insert("mainworkorder" , null, contentValues);
        Log.d(
                "querytag","sara created" + workres

        );
        db.close();
        return workres;
    }

    public long postancmt(String acmt_topic,String acmt_desc,String acmt_date,String acmt_time,String acmt_by)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       // contentValues.put("acmnt_id ", acmt_id);
        contentValues.put("acmnt_topic", acmt_topic);
        contentValues.put("acmnt_desc", acmt_desc);
        contentValues.put("acmnt_date", acmt_date);
        contentValues.put("acmnt_time", acmt_time);
        contentValues.put("acmnt_by", acmt_by);

        long postancmtres = db.insert("mainannouncement" , null, contentValues);
        Log.d(
                "querytag","sara created" + postancmtres

        );
        db.close();
        //return res;
        return postancmtres;
    }

    public Cursor getAnnouncements(String user_id){
        Log.d(
                "sara_login_session","getAcmntuserid :" + user_id

        );

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME3,null);
        return data;
    }

    public Cursor getAnnouncementsById(String acmnt_id){
//        Log.d(
//                "sara_login_session","Profile updated" + us_id
//
//        );
        String[] columns ={ COL_1_ANCMNT,COL_2_ANCMNT,COL_3_ANCMNT,COL_4_ANCMNT,COL_5_ANCMNT,COL_6_ANCMNT};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_1_ANCMNT + "=?";
        String[] selectionArgs = {acmnt_id};
        Cursor cursor = db.query(TABLE_NAME3, columns,selection, selectionArgs, null,null,null);
        return cursor;
    }


}
