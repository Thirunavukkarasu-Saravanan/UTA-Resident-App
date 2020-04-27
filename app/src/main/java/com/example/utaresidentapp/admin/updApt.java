package com.example.utaresidentapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
public class updApt extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);

     int session_var_aptid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd_apt);


        session_var_aptid= getIntent().getIntExtra("apt_id",0);

       // String session_var_aptid = getIntent().getStringExtra("apt_id");
        Log.d("sara_updApt", "session_var_aptid " + session_var_aptid);


        //setting an instance of edittext fetched by id
        final EditText apt_name = (EditText)findViewById(R.id.textInputEditText5);
        final EditText apt_block    = (EditText)findViewById(R.id.textInputEditText13);
        final EditText apt_no    = (EditText)findViewById(R.id.textInputEditText14);

        //Fetching data from table for clicked item
        Cursor cursor = db.getapt(session_var_aptid);

        if (cursor.moveToNext()) {
            //assigning values if returned to instances - "tab_"
            String tab_apt_name = cursor.getString(1);
            String tab_apt_block = cursor.getString(2);
            String tab_apt_no = cursor.getString(3);
            Log.d("sara_user_session", "tab_apt_block" + tab_apt_block);
            Log.d("sara_user_session", "tab_apt_no" + tab_apt_no);
            // reassigning returned values from table to be displayed in fields
            apt_block.setText(tab_apt_block);
            apt_no.setText(tab_apt_no);
            apt_name.setText(tab_apt_name);



        }

        Button updbtn = (Button)findViewById(R.id.button8);
        updbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText updaptname =(EditText)findViewById(R.id.textInputEditText5);
                final EditText updaptblock=(EditText)findViewById(R.id.textInputEditText13);
                final EditText updaptnum =(EditText)findViewById(R.id.textInputEditText14);

                String conv_name = updaptname.getText().toString().trim();
                String conv_block = updaptblock.getText().toString().trim();
                String conv_number = updaptnum.getText().toString().trim();




                if(!conv_name.isEmpty()){
                    Log.d("sara_upd_apt", "conv_name field " + String.valueOf(conv_name.isEmpty()));

                    Log.d("sara_upd_apt", "conv_name field " + String.valueOf(conv_name));
                    Log.d("sara_upd_apt", "conv_block field " + String.valueOf(conv_block));
                    Log.d("sara_upd_apt", "conv_number field " + String.valueOf(conv_number));

                    if(conv_block.matches("[3-9]\\d\\d")){
                        Log.d("sara_upd_apt", "regex  pass for update_apt block  " );
                        if(!conv_number.isEmpty() && conv_number.length() == 3){
                            int insertsucc = db.updapt(session_var_aptid,conv_name,conv_block,conv_number);

                            if(insertsucc != -1){
                                Toast.makeText(updApt.this, "Apartment Successfully updated", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(updApt.this, view_apt_tab.class);
                               // Log.d("sara_updApt", "acmnt_id from ancmt " + v.getId());
                                //intent.putExtra("acmnt_id",v.getId());
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(updApt.this, "Update Apartment failed, Pleas Try again", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(updApt.this, "Apartment number can't be empty", Toast.LENGTH_SHORT).show();
                            Log.d("sara_upd_apt", "aptnumber field fail" + String.valueOf(conv_number.isEmpty()));
                            Log.d("sara_upd_apt", "aptnumber field fail" + String.valueOf(conv_number.length()));
                        }

                    }
                    else{
                        Toast.makeText(updApt.this, "Apartblock field entry is invalid, eg: 345,021,456", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(updApt.this, "Apartname field can't  be empty", Toast.LENGTH_SHORT).show();

                }


            }
        });







    }
}
