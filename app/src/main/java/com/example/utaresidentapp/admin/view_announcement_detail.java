package com.example.utaresidentapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;

public class view_announcement_detail extends AppCompatActivity {
    int acmnt_id=0;
    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_announcement_detail);

        final TextView pon =(TextView) findViewById(R.id.p_on);
        final TextView pby =(TextView) findViewById(R.id.p_by);
        final TextView ptitle =(TextView) findViewById(R.id.p_title);
        final TextView pdesc =(TextView)findViewById(R.id.p_desc);


        //fetch apt_id from intent that is getting transferred from view_apt page with apt_id string key.
        acmnt_id= getIntent().getIntExtra("acmnt_id",0);
        Log.d("sara_updApt", "acmnt_id from detail_ancmt " + acmnt_id);
        //if apt_id is equal to
        if(acmnt_id!=0){
            Log.d("sara_updApt", "acmnt_id from detail_ancmt before passing to table " + acmnt_id);
            Cursor cursor= db.getAnnouncementsById(String.valueOf(acmnt_id));
            if(cursor.moveToFirst()){
                String acmnt_id=cursor.getString(0);
                String acmnt_topic=cursor.getString(1);
                String acmnt_desc=cursor.getString(2);
                String acmnt_date=cursor.getString(3);
                String acmnt_time=cursor.getString(4);
                String acmnt_by=cursor.getString(5);

                pon.setText(acmnt_date);
                ptitle.setText(acmnt_topic);
                pdesc.setText(acmnt_desc);
                pby.setText(acmnt_by);
            }
        }
    }
}
