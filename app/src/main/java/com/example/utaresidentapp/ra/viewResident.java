package com.example.utaresidentapp.ra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;

public class viewResident extends AppCompatActivity {
    static String session_var_userid;

    TextView tv1, tv2, tv3,tv4;
    TableLayout tl;

    TableRow tr;
    String temp = null;


    DatabaseHelper db = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resident);
        session_var_userid = getIntent().getStringExtra("NAME");


        Cursor cursor1 = db.getaptblock(session_var_userid);
        if (cursor1.moveToNext()) {
            String myblock = cursor1.getString(0);
            Log.d("sara_view_my_resident", "myblock :" + myblock);
             temp = myblock;
            Log.d("sara_view_my_resident", "temp :" + temp);
        }
        Log.d("sara_view_my_resident", "temp before getprofile :" + temp);
        Cursor cursor2 = db.getProfilebyblock(temp);
        tl = (TableLayout) findViewById(R.id.tl);
        tl.setColumnStretchable(2, true);
        tl.setColumnStretchable(1, true);
        tl.setColumnStretchable(4, true);
        //tl.setColumnStretchable(5, true);


        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams tr_param = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        //layoutParams.setMargins(1,1,1,1);
        tr_param.weight = 2.0f;
        tr_param.height = 110;
        tr_param.setMargins(4, 4, 4, 4);
        tr_param.width = 100;


        if (cursor2.getCount() == 0) {
            Toast.makeText(this, "Table has no records", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor2.moveToNext()) {

                tr = new TableRow(this);
                tv1 = new TextView(this);
                tv2 = new TextView(this);
                tv3 = new TextView(this);

                tv1.setHeight(25);
                tv1.setText(cursor2.getString(8));
                tv1.setGravity(Gravity.CENTER);
                tv1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv1.setLayoutParams(tr_param);
                tv2.setHeight(25);
                tv2.setText(cursor2.getString(4));
                tv2.setGravity(Gravity.CENTER);
                tv2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv2.setLayoutParams(tr_param);
                tv3.setHeight(30);
                tv3.setText(cursor2.getString(0));
                tv3.setGravity(Gravity.CENTER);
                tv3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv3.setLayoutParams(tr_param);

                tr.addView(tv1);
                tr.addView(tv2);
                tr.addView(tv3);
                tl.addView(tr, layoutParams);

                tr.setClickable(true);
                tr.setId(Integer.parseInt(cursor2.getString(0)));
                tr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(viewResident.this,view_resident_detail.class);
                        intent.putExtra("utaid",v.getId());
                        Log.d("sara_view_workorder", "utaid  " + v.getId());
                        startActivity(intent);
                    }
                });
            }
        }




    }


}
