package com.example.utaresidentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class viewAnnouncement extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    TableLayout tl;
    TableRow tr;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_announcement);

        final String session_var_userid = getIntent().getStringExtra("NAME");

        Cursor data = db.getAnnouncements(session_var_userid);
        tl = (TableLayout) findViewById(R.id.tl);
//        tl.setColumnStretchable(0, true);
//        tl.setColumnStretchable(1, true);

        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams tr_param = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams tr_param2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        //layoutParams.setMargins(1,1,1,1);
        tr_param2.weight = 0.5f;
        tr_param.weight = 2.5f;
        tr_param.height = 80;
        tr_param.setMargins(4, 4, 4, 4);
        tr_param2.height = 80;
        tr_param2.setMargins(4, 4, 4, 4);
        tr_param2.width = 50;

        if (data.getCount() == 0) {
            Toast.makeText(this, "Table has no records", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {

                tr = new TableRow(this);
                tv1 = new TextView(this);
                tv2 = new TextView(this);
                tv3 = new TextView(this);

                tv1.setHeight(25);
                tv1.setText(data.getString(3));
                tv1.setGravity(Gravity.CENTER);
                tv1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                //tv1.setLayoutParams(tr_param);
                tv1.setLayoutParams(tr_param2);
                tv1.setPadding(10,6,6,6);
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                //tv1.setWidth(140);
                tv1.setTextColor(Color.parseColor("#333333"));
                tv2.setHeight(25);
                tv2.setText(data.getString(1));
                tv2.setGravity(Gravity.CENTER);
                tv2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv2.setLayoutParams(tr_param);
                tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                tv2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                tv2.setPadding(6,6,6,6);
                tv2.setTextColor(Color.parseColor("#333333"));
                tv2.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

//                tv3.setHeight(25);
//                tv3.setText(data.getString(2));
//                tv3.setGravity(Gravity.CENTER);
//                tv3.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                tv3.setLayoutParams(tr_param2);
//                tv3.setPadding(10,6,6,6);
//                tv3.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
//                tv3.setTextColor(Color.parseColor("#333333"));


                //tv2.setGravity(Gravity.LEFT);

                tr.addView(tv1);
                tr.addView(tv2);
               // tr.addView(tv3);
                tl.addView(tr, layoutParams);

                tr.setClickable(true);
                tr.setId(Integer.parseInt(data.getString(0)));
                tr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent=new Intent(viewAnnouncement.this, view_announcement_detail.class);
                        Log.d("sara_updApt", "acmnt_id from ancmt " + v.getId());
                        intent.putExtra("NAME",session_var_userid);
                        intent.putExtra("acmnt_id",v.getId());
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
