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
import android.widget.Toast;

import com.example.utaresidentapp.Controller.LoginController;
import com.example.utaresidentapp.users.User_WorkOrder;
import com.example.*;

public class DummyActivity extends AppCompatActivity {

    private Button btn_workordr;
    private Button btn_viewancmnt;
    private Button btn_emercont;
    private Button btn_myprofile;
    static String session_var_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        session_var_username = getIntent().getStringExtra("USERNAME");
        Log.d("sara_login_session", "session_var_username in user home " + session_var_username);


        btn_workordr = findViewById(R.id.button2);
        btn_workordr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkOrder();
                            }


        });



        btn_emercont = findViewById(R.id.button13);
        btn_emercont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmerCntct();
            }


        });

        btn_myprofile = findViewById(R.id.button4);
        btn_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
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

    public void openWorkOrder() {

        Intent intent = new Intent(this, User_WorkOrder.class);
        intent.putExtra("NAME",session_var_username);
        startActivity(intent);
    }
    public void openEmerCntct() {

        Intent intent = new Intent(this, EmrgncyContct.class);
        startActivity(intent);
    }

    public void openProfile() {
        Log.d("sara_admin", "buttonclick success");
        Toast.makeText(DummyActivity.this, "View Profile click success from home page", Toast.LENGTH_SHORT).show();
        Log.d("sara_login_session", "session_var_username in userhome when profile button is clicked" + session_var_username);
        Intent intent = new Intent(this, profile.class);
        intent.putExtra("NAME",session_var_username);
        startActivity(intent);
    }
}
