package com.example.utaresidentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    DatabaseHelper db = new DatabaseHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(LoginActivity.this, "checkinghere", Toast.LENGTH_SHORT).show();


        mTextUsername =(EditText)findViewById(R.id.edittext_username);
       mTextPassword =(EditText)findViewById(R.id.edittext_password);
        mButtonLogin=(Button)findViewById(R.id.button_login);


       mButtonLogin.setOnClickListener(new OnClickListener(){

            public void onClick(View view){
                Toast.makeText(LoginActivity.this, "checkinghere", Toast.LENGTH_SHORT).show();
              String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res= db.checkUser(user,pwd);
              // mTextUsername.setText("chanhed");
                if(res == true)
                {
                    Toast.makeText(LoginActivity.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                    Intent LoginScreen = new Intent(LoginActivity.this, SecScreen.class);

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
