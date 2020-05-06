package com.example.utaresidentapp.ra;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;

public class view_resident_detail extends AppCompatActivity {

    int ses_work_id=0;
    DatabaseHelper db = new DatabaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resident_detail);

        ses_work_id= getIntent().getIntExtra("utaid",0);

        final TextView userid =(TextView) findViewById(R.id.work_req_by);
        final TextView aptblock=(TextView) findViewById(R.id.apt_block);
        final TextView aptno =(TextView) findViewById(R.id.apt_no);
        final TextView name =(TextView) findViewById(R.id.req_on);
        final TextView uta_id =(TextView)findViewById(R.id.desc);
        final TextView usert =(TextView) findViewById(R.id.status);
        final TextView phn =(TextView) findViewById(R.id.statuss);
        final TextView emerphn =(TextView) findViewById(R.id.statusss);
        final TextView grad =(TextView) findViewById(R.id.statussss);


        if(ses_work_id!=0){
            Log.d("sara_updApt", "acmnt_id from detail_ancmt before passing to table " + ses_work_id);
            Cursor cursor= db.getProfilebyutaid(String.valueOf(ses_work_id));
            if(cursor.moveToFirst()){
                String Userid=cursor.getString(1);
                String UserName=cursor.getString(4);
                String utaa_id=cursor.getString(0);
                String phone=cursor.getString(5);
                String apt_block=cursor.getString(6);
                String emergency_phone=cursor.getString(7);
                String apt_no=cursor.getString(8);
                String grad_date=cursor.getString(9);
                String password=cursor.getString(2);
                String user_role=cursor.getString(3);
                
                 userid.setText(Userid);
                 aptblock.setText(apt_block);
                aptno.setText(apt_no);
                 name.setText(UserName);
                 uta_id.setText(utaa_id);
                 usert.setText(user_role);
                 phn.setText(phone);
                 emerphn.setText(emergency_phone);
                 grad.setText(grad_date);


            }
        }



    }
}
