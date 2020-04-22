package com.example.utaresidentapp.users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.DummyActivity;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.ra.RaHomeScreen;
import com.example.utaresidentapp.ra.postAncmnt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class User_WorkOrder extends AppCompatActivity {

    static String session_var_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__work_order);

        session_var_username = getIntent().getStringExtra("NAME");
        Log.d("sara_user_session", "session_var_username in user_workorder home " + session_var_username);

        //setting an instance of edittext fetched by id
        final EditText apt_block = (EditText)findViewById(R.id.edittext_username);
        final EditText apt_no    = (EditText)findViewById(R.id.edittext_password);


        //Function to get apartment block and number for this particular user using userID
        final DatabaseHelper db  = new DatabaseHelper(this);
        Cursor cursor = db.getaptdetails(session_var_username);

        if (cursor.moveToNext()) {
            //assigning values if returned to instances - "tab_"
            String tab_apt_block = cursor.getString(0);
            String tab_apt_no = cursor.getString(1);
            Log.d("sara_user_session", "tab_apt_block" + tab_apt_block);
            Log.d("sara_user_session", "tab_apt_no" + tab_apt_no);
            // reassigning returned values from table to be displayed in fields
            apt_block.setText(tab_apt_block);
            apt_no.setText(tab_apt_no);
        }

        //System Time
        final Date c = Calendar.getInstance().getTime();
        Log.d("sara_post_ancment", "c " + c);
        //System Date
        final SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        final String formattedDate = df.format(c);
        Log.d("sara_post_ancment", "df " + formattedDate);
        final EditText descr = (EditText)findViewById(R.id.editttext_password);

        Button reqWork = (Button)findViewById(R.id.button_login);
        reqWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String apart_block = apt_block.getText().toString().trim();
                String apart_no = apt_no.getText().toString().trim();
                String desc = descr.getText().toString().trim();
                String wrk_date = formattedDate.trim();
                Log.d("sara_user_workorder", "a_date field beofre conversion " + formattedDate.trim());
                String wrk_time = c.toString().trim();
                String session_user = session_var_username.trim();
                String wrk_status = "Active";

                if(!desc.isEmpty()){
                    long insertsucc = db.reqworkorder(session_user,apart_block,apart_no,desc,wrk_date,wrk_time,wrk_status);
                    if(insertsucc != -1){
                        Toast.makeText(User_WorkOrder.this, "Work order has been submitted sucessfully ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(User_WorkOrder.this, DummyActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(User_WorkOrder.this, "Something went wrong, Pleas Try again", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(User_WorkOrder.this, "Description field cannot be empty ", Toast.LENGTH_SHORT).show();
                }


            }
        });





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
