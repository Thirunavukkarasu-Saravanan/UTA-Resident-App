package com.example.utaresidentapp.ra;

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

import com.example.utaresidentapp.EmrgncyContct;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.viewAnnouncement;
import com.example.utaresidentapp.profile;

public class RaHomeScreen extends AppCompatActivity {

    static String session_var_username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra_home_screen);
        session_var_username = getIntent().getStringExtra("USERNAME");
        Log.d("sara_login_session", "session_var_username in RA home " + session_var_username);


        Button btn_postancmnt = findViewById(R.id.button2);
        btn_postancmnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPostancmnt();
            }


        });

        Button btn_emercntct = findViewById(R.id.button12);
        btn_emercntct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmerCntct();
            }


        });


        Button btn_viewancmt = findViewById(R.id.button6);
        btn_viewancmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openviewAncmt();
            }


        });

        Button btn_viewworkorder = findViewById(R.id.button3);
        btn_viewworkorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openviewwork();
            }


        });

        Button btn_viewresident = findViewById(R.id.button4);
        btn_viewresident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openviewresident();
            }


        });

        Button btn_myprofile = findViewById(R.id.button10);
        btn_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }

        });

    }

    public void openPostancmnt() {

        Intent intent = new Intent(this, postAncmnt.class);
        intent.putExtra("NAME",session_var_username);
        startActivity(intent);
    }

    public void openEmerCntct() {

        Intent intent = new Intent(this, EmrgncyContct.class);
        startActivity(intent);
    }

    public void openviewAncmt() {

        Intent intent = new Intent(this, viewAnnouncement.class);
        startActivity(intent);
    }

    public void openviewresident() {

        Intent intent = new Intent(RaHomeScreen.this, viewResident.class);
        Log.d("sara_view_my_resident", "session_var_username in userhome when profile button is clicked" + session_var_username);
        intent.putExtra("NAME",session_var_username);
        startActivity(intent);
    }

    public void openviewwork() {

        Intent intent = new Intent(this, view_workorder_ra.class);
        startActivity(intent);
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

    public void openProfile() {
        Log.d("sara_admin", "buttonclick success");
        Toast.makeText(RaHomeScreen.this, "View Profile click success from home page", Toast.LENGTH_SHORT).show();
        Log.d("sara_login_session", "session_var_username in userhome when profile button is clicked" + session_var_username);
        Intent intent = new Intent(this, profile.class);
        intent.putExtra("NAME",session_var_username);
        startActivity(intent);
    }



}
