package com.example.utaresidentapp.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.users.User_WorkOrder;

public class AdminHome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        Button btn_adduser = findViewById(R.id.button2);
        btn_adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddUser();
            }


        });

        Button btn_addapt = findViewById(R.id.button6);
        btn_addapt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddApt();
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



    public void openaddUser() {

        Intent intent = new Intent(this, addUser.class);
        startActivity(intent);
    }

    public void openaddApt() {

        Intent intent = new Intent(this, addApt.class);
        startActivity(intent);
    }


}
