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
import android.widget.Toast;

import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.profile;
import com.example.utaresidentapp.users.User_WorkOrder;

public class AdminHome extends AppCompatActivity {

    //Declaring variables for button click to be Identified by ID
    private Button btn_adduser;
    private Button btn_profile;
    private Button btn_viewApartment;
    private Button btn_mod_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        //On button click to Call Add User  activity
        btn_adduser = findViewById(R.id.button2);
        btn_adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddUser();
            }


        });

        //On button click to Call Modify profile  activity
        btn_mod_user = findViewById(R.id.button3);
        btn_mod_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminHome.this, "inside btn_mod_user", Toast.LENGTH_SHORT).show();
                Log.d("sara_major", "inside mod_button_user" );
                Intent intent = new Intent(AdminHome.this, modify_user.class );
                startActivity(intent);

            }


        });


        //On button click to Call My Profile  activity
        btn_profile = findViewById(R.id.button5);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }


        });
        //On button click to Call Add Apartment activity
        Button btn_addapt = findViewById(R.id.button6);
        btn_addapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddApt();
            }


        });
        //On button click to Call View Apartment activity
        Button btn_viewApartment = (Button)findViewById(R.id.button4);
        btn_viewApartment.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v){
                Intent intent = new Intent(AdminHome.this, viewApt.class );
                startActivity(intent);

            }

        });
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    //Function to Logout
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


    //Function to Call Add User activity
    public void openaddUser() {
        Log.d("sara_admin", "buttonclick success");
        Toast.makeText(AdminHome.this, "Add user click success from home page", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, addUser.class);
        startActivity(intent);
    }
    //Function to Call My Profile activity
    public void openProfile() {
        Log.d("sara_admin", "buttonclick success");
        Toast.makeText(AdminHome.this, "View Profile click success from home page", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

    //Function to Call Add Apartment activity
    public void openaddApt() {

        Intent intent = new Intent(this, addApt.class);
        startActivity(intent);
    }


}
