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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;

public class addUser extends AppCompatActivity {
     RadioGroup radioGroup;
    RadioButton rb1; //= (RadioButton) findViewById(R.id.radioButton);
     RadioButton rb2; //= (RadioButton) findViewById(R.id.radioButton2);

    String usertype = "";

    DatabaseHelper db = new DatabaseHelper(this);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("sara_admin", "inside add user");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
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

        Button addbtn = (Button)findViewById(R.id.button7);
        Log.d("sara_radio", "before function to chekc if clicked " + rb1.getText());
        Log.d("sara_radio", "before function to chekc if clicked " + rb2.getText());




        addbtn.setOnClickListener(new View.OnClickListener() {

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


                   long insertesucc = db.addUser(userid,adusername,mavid,phne,adaptblock,emercntct,aptnumber,graddate,pword,f_user_type);
                    Log.d("sara_admin_fail", "return from insert " );

                    if(insertesucc != -1)


                    {
                        Toast.makeText(addUser.this, "User added Successfully", Toast.LENGTH_SHORT).show();
                        Intent LoginScreen = new Intent(addUser.this, AdminHome.class);
                        startActivity(LoginScreen);
                    }
                    else
                        {

                            Log.d("sara_admin_fail", "return from insert " + insertesucc);
                            Toast.makeText(addUser.this, "User add FAILED", Toast.LENGTH_SHORT).show();

                        }

                    }
                else
                    {
                        Log.d("sara_admin_fail", "mavid field " + String.valueOf(mavid.isEmpty()));
                        Log.d("sara_admin", "userid " + String.valueOf(userid));
                        Log.d("sara_admin", "password " + String.valueOf(pword));
                        Toast.makeText(addUser.this, "User validation working but failed", Toast.LENGTH_SHORT).show();

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
