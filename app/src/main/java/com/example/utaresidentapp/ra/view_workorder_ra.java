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

public class view_workorder_ra extends AppCompatActivity {

    TextView tv1, tv2, tv3,tv4;
    TableLayout tl;

    TableRow tr;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workorder_ra);

        String session_var_userid = getIntent().getStringExtra("NAME");


        Cursor data = db.getWorkOrder(session_var_userid);
        tl = (TableLayout) findViewById(R.id.tl);
        tl.setColumnStretchable(2, true);
        tl.setColumnStretchable(3, true);
        tl.setColumnStretchable(5, true);
        tl.setColumnStretchable(5, true);

        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams tr_param = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        //layoutParams.setMargins(1,1,1,1);
        tr_param.weight = 1.0f;
        tr_param.height = 70;
        tr_param.setMargins(4, 4, 4, 4);
        tr_param.width = 100;


        if (data.getCount() == 0) {
            Toast.makeText(this, "Table has no records", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {

                tr = new TableRow(this);
                tv1 = new TextView(this);
                tv2 = new TextView(this);
                tv3 = new TextView(this);
                tv4 = new TextView(this);

                tv1.setHeight(25);
                tv1.setText(data.getString(2));
                tv1.setGravity(Gravity.CENTER);
                tv1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv1.setLayoutParams(tr_param);
                tv2.setHeight(25);
                tv2.setText(data.getString(3));
                tv2.setGravity(Gravity.CENTER);
                tv2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv2.setLayoutParams(tr_param);
                tv3.setHeight(30);
                tv3.setText(data.getString(5));
                tv3.setGravity(Gravity.CENTER);
                tv3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv3.setLayoutParams(tr_param);
                tv4.setHeight(25);
                tv4.setText(data.getString(7));
                tv4.setGravity(Gravity.CENTER);
                tv4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv4.setLayoutParams(tr_param);
                tr.addView(tv1);
                tr.addView(tv2);
                tr.addView(tv3);
                tr.addView(tv4);
                tl.addView(tr, layoutParams);

                tr.setClickable(true);
                tr.setId(Integer.parseInt(data.getString(0)));
                tr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(view_workorder_ra.this,view_workorder_detail.class);
                        intent.putExtra("work_id",v.getId());
                        Log.d("sara_view_workorder", "v.getId " + v.getId());
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
