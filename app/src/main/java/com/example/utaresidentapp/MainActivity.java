package com.example.utaresidentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;



    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }


        });







        Log.d("Sara_corejava", "onCreate wroked");


    }




    public void openActivity2() {
       db = new DatabaseHelper(this);
      db.addUser(1,"sara", "sara" );
        db.addUser(2,"admin", "admin" );
        db.addUser(2,"sarara", "sarara" );
        Log.d("Sara_corejava","insert worked");
        Intent intent = new Intent(this,SecScreen.class
        );
        startActivity(intent);
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Sara_corejava","onStart worked");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Sara_corejava","onResume working");

    }





}

