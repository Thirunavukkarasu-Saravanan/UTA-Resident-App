package com.example.utaresidentapp.users;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;

public class view_workorder_det_user extends AppCompatActivity {
    int work_id=0;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workorder_det_user);
        final TextView workreqby =(TextView) findViewById(R.id.work_req_by);
        final TextView aptblock=(TextView) findViewById(R.id.apt_block);
        final TextView aptno =(TextView) findViewById(R.id.apt_no);
        final TextView reqon =(TextView) findViewById(R.id.req_on);
        final TextView desc =(TextView)findViewById(R.id.desc);
        final TextView status =(TextView) findViewById(R.id.status);

        //fetch apt_id from intent that is getting transferred from view_apt page with apt_id string key.
        work_id= getIntent().getIntExtra("work_id",0);
        //if apt_id is equal to
        if(work_id!=0){
            Cursor cursor= db.getWorkOrderRequest(String.valueOf(work_id));
            if(cursor.moveToFirst()){
                String work_id=cursor.getString(0);
                String work_requestby=cursor.getString(1);
                String work_block=cursor.getString(2);
                String work_no=cursor.getString(3);
                String work_desc=cursor.getString(4);
                String work_date=cursor.getString(5);
                String work_time=cursor.getString(6);
                String work_status=cursor.getString(7);

                workreqby.setText(work_requestby);
                aptblock.setText(work_block);
                aptno.setText(work_no);
                reqon.setText(work_date);
                desc.setText(work_desc);
                status.setText(work_status);
            }
        }
    }
}
