package com.example.utaresidentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utaresidentapp.Controller.LoginController;
import com.example.utaresidentapp.admin.AdminHome;
import com.example.utaresidentapp.ra.RaHomeScreen;

public class SecScreen extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    DatabaseHelper db = new DatabaseHelper(this);
    LoginController lgncont = new LoginController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_screen);


        mTextUsername =(EditText)findViewById(R.id.edittext_username);
        mTextPassword =(EditText)findViewById(R.id.edittext_password);
        mButtonLogin=(Button)findViewById(R.id.button_login);

        mButtonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                chechen();
            }


        });
    }

    public void chechen(){
        //Toast.makeText(SecScreen.this, "checkinghere", Toast.LENGTH_SHORT).show();
        String user = mTextUsername.getText().toString().trim();
        String pwd = mTextPassword.getText().toString().trim();
        Boolean res= db.checkUser(user,pwd);
        String temp = null;

        //mTextUsername.setText("chanhed");

        if(res == true) {
            Cursor cursor= db.checkRole(user);
            if(cursor.moveToNext()){
                 String myrole = cursor.getString(0);
                Log.d("sara_sec_login", "myrole" + myrole);
                temp = myrole;

            }

            //admin role login
            if (temp.equals("3") ) {
                String session_username = mTextUsername.getText().toString();
                Log.d("sara_login_session", "session_username" + session_username);


                Toast.makeText(SecScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent LoginScreen = new Intent(SecScreen.this, AdminHome.class);
                LoginScreen.putExtra("USERNAME", session_username);
                startActivity(LoginScreen);
            } else if (temp.equals("2") ) { //User role login


                Log.d("sara_sa", "resstatus");
                Toast.makeText(SecScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent LoginScreen = new Intent(SecScreen.this, DummyActivity.class);
                startActivity(LoginScreen);

            } else if ( temp.equals("1")) { //RA role login

                Log.d("sara_sa", "resstatus");
                Toast.makeText(SecScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent LoginScreen = new Intent(SecScreen.this, RaHomeScreen.class);
                startActivity(LoginScreen);

            }
        }
        else
        {
            Log.d("sara_sec_login", "result from checking user in table returned false");
            Toast.makeText(SecScreen.this, "Login Error, Try again with correct credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
