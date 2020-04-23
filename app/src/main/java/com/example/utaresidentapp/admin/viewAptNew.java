package com.example.utaresidentapp.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;

public class viewAptNew extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    TableLayout tl;

    TableRow tr;
    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(viewAptNew.this, "INSIDE VIEW APT", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_apt2);

        Cursor data = db.getListContents();

        tl = (TableLayout) findViewById(R.id.tl);
        tl.setColumnStretchable(0, true);
        tl.setColumnStretchable(1, true);
        tl.setColumnStretchable(2, true);

        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams tr_param = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        //layoutParams.setMargins(1,1,1,1);
        tr_param.weight = 1.0f;
        tr_param.height = 70;
        tr_param.setMargins(4, 4, 4, 4);
        tr_param.width = 100;


        if (data.getCount() == 0) {
            Toast.makeText(viewAptNew.this, "Table has no records", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {

                tr = new TableRow(this);
                tv1 = new TextView(this);
                tv2 = new TextView(this);
                tv3 = new TextView(this);

                tv1.setHeight(25);
                tv1.setText(data.getString(1));
                tv1.setGravity(Gravity.CENTER);
                tv1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv1.setLayoutParams(tr_param);
                tv2.setHeight(25);
                tv2.setText(data.getString(2));
                tv2.setGravity(Gravity.CENTER);
                tv2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv2.setLayoutParams(tr_param);
                tv3.setHeight(25);
                tv3.setText(data.getString(3));
                tv3.setGravity(Gravity.CENTER);
                tv3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv3.setLayoutParams(tr_param);
                tr.addView(tv1);
                tr.addView(tv2);
                tr.addView(tv3);
                tl.addView(tr, layoutParams);


//                mylist.add(data.getString(1));
//                mylist.add(data.getString(2));
//                // mylist.add(data.getString(3));
//                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mylist);
//
//                listView.setAdapter(listAdapter);
//
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//                        Intent intent = new Intent(viewApt2.this, addApt.class );
//                        startActivity(intent);
//
//                    }
//                });
            }

//        tl=(TableLayout)findViewById(R.id.tl);
//        tl.setColumnStretchable(0,true);
//        tl.setColumnStretchable(1,true);
//        tl.setColumnStretchable(2,true);
//
//        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//        TableRow.LayoutParams tr_param = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
//
//        //layoutParams.setMargins(1,1,1,1);
//        tr_param.weight=1.0f;
//        tr_param.height=70;
//        tr_param.setMargins(4,4,4,4);
//        tr_param.width=100;
//        tr=new TableRow(this);
//
//         tv1=new TextView(this);
//         tv2=new TextView(this);
//         tv3=new TextView(this);
//
//         tv1.setHeight(25);
//         tv1.setText("Arbor Oaks");
//         tv1.setGravity(Gravity.CENTER);
//         tv1.setBackgroundColor(Color.parseColor("#FFFFFF"));
//         tv1.setLayoutParams(tr_param);
//         tv2.setHeight(25);
//         tv2.setText("222");
//         tv2.setGravity(Gravity.CENTER);
//         tv2.setBackgroundColor(Color.parseColor("#FFFFFF"));
//         tv2.setLayoutParams(tr_param);
//         tv3.setHeight(25);
//         tv3.setText("215");
//         tv3.setGravity(Gravity.CENTER);
//         tv3.setBackgroundColor(Color.parseColor("#FFFFFF"));
//         tv3.setLayoutParams(tr_param);
//         tr.addView(tv1);
//         tr.addView(tv2);
//         tr.addView(tv3);
//        tl.addView(tr,layoutParams);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logout:{
                Intent intent = new Intent(this, SecScreen.class);
                startActivity(intent);

            }
        }
        return super.onOptionsItemSelected(item);
    }


}
