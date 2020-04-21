package com.example.utaresidentapp.ra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.admin.AdminHome;
import com.example.utaresidentapp.admin.addApt;
import com.example.utaresidentapp.profile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class postAncmnt extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    private TextView dateTimeDisplay;
    static String session_var_userid;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private Formatter date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ancmnt);

        //assigining username from previous session
        session_var_userid = getIntent().getStringExtra("NAME");
        Log.d("sara_login_session", "session_var_username in postancmnt " + session_var_userid);

        //capturing details from user and assigning
        final EditText topic =(EditText)findViewById(R.id.editText1);
        final EditText desc =(EditText)findViewById(R.id.editText6);


        //System Time
        final Date c = Calendar.getInstance().getTime();
        Log.d("sara_post_ancment", "c " + c);
        //System Date
        final SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        final String formattedDate = df.format(c);
        Log.d("sara_post_ancment", "df " + formattedDate);
       // System.out.println("Current time => " + c);
        //assigning button "post"
        Button postbtn = (Button)findViewById(R.id.button11);
        postbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String heading = topic.getText().toString().trim();
                String description  = desc.getText().toString().trim();

                String a_date = formattedDate.trim();
                Log.d("sara_postancment", "a_date field beofre conversion " + formattedDate.trim());
                String a_time = c.toString().trim();
                String session_un = session_var_userid.trim();

                if(!heading.isEmpty()){
                    Log.d("sara_post_ancment", "inside topic = true " + (heading.isEmpty()));
                    if(!description.isEmpty() || description.length() > 3){
                        //Toast.makeText(postAncmnt.this, "add insert function here", Toast.LENGTH_SHORT).show();
                        Log.d("sara_postancment", "a_date field " + a_date);
                        long insertsucc = db.postancmt(heading,description,a_date,a_time,session_un);
                        if(insertsucc != -1){
                            Toast.makeText(postAncmnt.this, "Announcement posted successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(postAncmnt.this, RaHomeScreen.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(postAncmnt.this, "Something went wrong, Pleas Try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(postAncmnt.this, "Description can't be empty, must be atleast 3 characters length", Toast.LENGTH_SHORT).show();
                    }


                }
                else{
                    Toast.makeText(postAncmnt.this, "Topic Can't be empty", Toast.LENGTH_SHORT).show();
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
