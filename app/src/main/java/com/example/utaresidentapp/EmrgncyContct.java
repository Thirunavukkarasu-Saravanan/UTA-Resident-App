package com.example.utaresidentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class EmrgncyContct extends AppCompatActivity {

    //Declaring and assigning values to global variables
    static final String EC1 = "817-600-0832";
    static final String EC2 = "817-272-2000";
    static final String EC3 = "817-272-2791";
    static final String EC4 = "817-272-3003";
    static final String EC5 = "817-272-8255";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emrgncy_contct);
     // Instantiating local variable to fields fetched by ID
        EditText ec_1 = (EditText)findViewById(R.id.textInputEditText11);
        EditText ec_2 = (EditText)findViewById(R.id.textInputEditText6);
        EditText ec_3 = (EditText)findViewById(R.id.textInputEditText10);
        EditText ec_4 = (EditText)findViewById(R.id.textInputEditText7);
        EditText ec_5 = (EditText)findViewById(R.id.textInputEditText12);
    //assigning fetched fields to global values
        ec_1.setText(EC1);
        ec_2.setText(EC2);
        ec_3.setText(EC3);
        ec_4.setText(EC4);
        ec_5.setText(EC5);

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
