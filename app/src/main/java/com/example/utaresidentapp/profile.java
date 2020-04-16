package com.example.utaresidentapp;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.database.Cursor;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.admin.AdminHome;
import com.example.utaresidentapp.admin.addUser;

public class profile extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rb1; //= (RadioButton) findViewById(R.id.radioButton);
    RadioButton rb2; //= (RadioButton) findViewById(R.id.radioButton2);

    String usertype = "";

    DatabaseHelper db = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        final EditText addaptnum =(EditText)findViewById(R.id.textInputEditText9);
        final EditText addgraddt=(EditText)findViewById(R.id.textInputEditText15);
        final EditText addpwd =(EditText)findViewById(R.id.textInputEditText16);
        final EditText addemergnphone =(EditText)findViewById(R.id.textInputEditText8);
        final EditText addphone =(EditText)findViewById(R.id.textInputEditText5);
        final EditText addaptblock =(EditText)findViewById(R.id.textInputEditText7);
        final EditText addusername =(EditText)findViewById(R.id.textInputEditText2);
        final EditText addutaid =(EditText)findViewById(R.id.textInputEditText3);
        final EditText adduserid =(EditText)findViewById(R.id.textInputEditText);
        final EditText addemailid =(EditText)findViewById(R.id.textInputEditText4);

        Button updbtn = (Button)findViewById(R.id.button7);
        Log.d("sara_radio", "before function to chekc if clicked " + rb1.getText());
        Log.d("sara_radio", "before function to chekc if clicked " + rb2.getText());

        //populate the fields
        Cursor cursor= db.getProfile("sara");
        if(cursor.moveToFirst()){
            String Userid=cursor.getString(1);
            String UserName=cursor.getString(4);
            String uta_id=cursor.getString(0);
            String phone=cursor.getString(5);
            String apt_block=cursor.getString(6);
            String emergency_phone=cursor.getString(7);
            String apt_no=cursor.getString(8);
            String grad_date=cursor.getString(9);
            String password=cursor.getString(2);
            String user_role=cursor.getString(3);


            adduserid.setText(Userid);
            addaptnum.setText(apt_no);
            addgraddt.setText(grad_date);
            addpwd.setText(password);
            addemergnphone.setText(emergency_phone);
            addphone.setText(phone);
            addaptblock.setText(apt_block);
            addusername.setText(UserName);
            addutaid.setText(uta_id);
            addemailid.setText(UserName+"@mavs.uta.edu");
            if(user_role.equals("1")){
                rb1.setChecked(true);
            }
            else if(user_role.equals("2")){
                rb2.setChecked(true);
            }
        }


        //Update the fields
        updbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String userid = adduserid.getText().toString().trim();
                String adusername = addusername.getText().toString().trim();
                String mavid = addutaid.getText().toString().trim();
                String phne = addphone.getText().toString().trim();
                String adaptblock = addaptblock.getText().toString().trim();
                String emercntct = addemergnphone.getText().toString().trim();
                String aptnumber = addaptnum.getText().toString().trim();
                String graddate = addgraddt.getText().toString().trim();
                String pword = addpwd.getText().toString().trim();


                String f_user_type = usertype;
                if(f_user_type.isEmpty()){
                    if(rb1.isChecked()==true){
                        f_user_type="1";
                    }
                    else if(rb2.isChecked()==true){
                        f_user_type="2";
                    }
                }
                Log.d("sara_radio", "insideoncreate " + f_user_type);
                // Log.d("sara_radio", "password " + String.valueOf(usertype2));

                if(!mavid.isEmpty()){

                    Log.d("sara_admin", "mavid field " + String.valueOf(mavid.isEmpty()));
                    Log.d("sara_admin", "userid " + String.valueOf(userid));
                    Log.d("sara_admin", "adusername " + String.valueOf(adusername));
                    Log.d("sara_admin", "mavid field " + mavid);
                    Log.d("sara_admin", "phone field " + phne);
                    Log.d("sara_admin", "adaptblock " + String.valueOf(adaptblock));
                    Log.d("sara_admin", "emercntct " + String.valueOf(emercntct));
                    Log.d("sara_admin", "aptnumber " + String.valueOf(aptnumber));
                    Log.d("sara_admin", "graddate " + String.valueOf(graddate));
                    Log.d("sara_admin", "password " + String.valueOf(pword));
                    Log.d("sara_admin", "usertype " + String.valueOf(f_user_type));

                    //Log.d("sara_admin", "adusername " + String.valueOf(adusername));





                    //Log.d("sara_admin", "password " + String.valueOf(pword));


                    long insertesucc = db.UpdateProfile(userid,adusername,mavid,phne,adaptblock,emercntct,aptnumber,graddate,pword,f_user_type);
                   // Log.d("sara_admin_fail", "return from insert " );

                    if(insertesucc != 0) {
                        Toast.makeText(profile.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(profile.this, AdminHome.class);
                        startActivity(intent);
                    }
                    else
                    {

                        //Log.d("sara_admin_fail", "return from insert " + insertesucc);
                        Toast.makeText(profile.this, "Profile update failed!", Toast.LENGTH_SHORT).show();

                    }

                }
                else
                {
                    Log.d("sara_admin_fail", "mavid field " + String.valueOf(mavid.isEmpty()));
                    Log.d("sara_admin", "userid " + String.valueOf(userid));
                    Log.d("sara_admin", "password " + String.valueOf(pword));
                    Toast.makeText(profile.this, "User validation working but failed", Toast.LENGTH_SHORT).show();

                }


            }
        });



    }


    public void onRadioButtonClicked(View v){
        RadioGroup rg = (RadioGroup) findViewById(R.id.myRadioGroup);
        RadioButton rb_1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rb_2 = (RadioButton) findViewById(R.id.radioButton2);

        // Is the current Radio Button checked?
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()){
            case R.id.radioButton:
                if(checked)
                    usertype = "1";
                rb2.setChecked(false);
                Log.d("sara_radio", "inside rb1 " + (rb1.getText()) +  " "  +usertype);
                break;

            case R.id.radioButton2:
                if(checked)
                    usertype = "2";
                rb1.setChecked(false);
                Log.d("sara_radio", "inside rb2 " + (rb2.getText()) +  " "  +usertype);
                break;

            case R.id.default_activity_button:
                usertype = "1";
                Log.d("sara_radio", "inside default " + (rb2.getText()) +  " "  +usertype);
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
