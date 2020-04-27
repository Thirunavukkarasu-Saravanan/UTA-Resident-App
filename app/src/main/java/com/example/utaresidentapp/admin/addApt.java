package com.example.utaresidentapp.admin;

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
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.Controller.AdminController;
import com.example.utaresidentapp.SecScreen;

public class addApt extends AppCompatActivity {
    //AdminController adminCont = new AdminController(this);
    DatabaseHelper db = new DatabaseHelper(this);
    int apt_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apt);
        //fetch apt_id from intent that is getting transferred from view_apt page with apt_id string key.
        apt_id= getIntent().getIntExtra("apt_id",0);
        //if apt_id is equal to
        if(apt_id!=0){

        }

        final EditText addaptname =(EditText)findViewById(R.id.textInputEditText5);
        final EditText addaptblock=(EditText)findViewById(R.id.textInputEditText13);
        final EditText addaptnum =(EditText)findViewById(R.id.textInputEditText14);

        Button addbtn = (Button)findViewById(R.id.button8);

        addbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String aptname = addaptname.getText().toString().trim();
                String aptblock = addaptblock.getText().toString().trim();
                String aptnumber = addaptnum.getText().toString().trim();


                if(!aptname.isEmpty()){
                    Log.d("sara_apt", "aptname field " + String.valueOf(aptname.isEmpty()));

                    Log.d("sara_apt", "aptname field " + String.valueOf(aptname));
                    Log.d("sara_apt", "aptblock field " + String.valueOf(aptblock));
                    Log.d("sara_apt", "aptnumber field " + String.valueOf(aptnumber));

                    if(aptblock.matches("[3-9]\\d\\d")){
                        Log.d("sara_apt", "regex  pass for apt block  " );
                        if(!aptnumber.isEmpty() && aptnumber.length() == 3){
                            Log.d("sara_apt", "aptnumber field " + String.valueOf(aptnumber.isEmpty()));
                            Log.d("sara_apt", "aptnumber field " + String.valueOf(aptnumber.length()));
                            Log.d("sara_apt", "All validation pass " );

                            long insertsucc = db.addapart(aptname,aptblock,aptnumber);
                            if(insertsucc != -1){
                                Toast.makeText(addApt.this, "Apartment Successfully added", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(addApt.this, AdminHome.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(addApt.this, "Add Apartment failed, Pleas Try again", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(addApt.this, "Apartnumber field entry is wrong", Toast.LENGTH_SHORT).show();
                            Log.d("sara_apt", "aptnumber field fail" + String.valueOf(aptnumber.isEmpty()));
                            Log.d("sara_apt", "aptnumber field fail" + String.valueOf(aptnumber.length()));
                        }



                    }
                    else{
                        Toast.makeText(addApt.this, "Apartblock field entry is invalid, eg: 345,021,456", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(addApt.this, "Apartname field can't  be empty", Toast.LENGTH_SHORT).show();
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
