package com.example.utaresidentapp.ra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.utaresidentapp.EmrgncyContct;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.admin.addUser;

public class RaHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra_home_screen);


        Button btn_postancmnt = findViewById(R.id.button2);
        btn_postancmnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPostancmnt();
            }


        });

        Button btn_emercntct = findViewById(R.id.button10);
        btn_emercntct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmerCntct();
            }


        });

    }

    public void openPostancmnt() {

        Intent intent = new Intent(this, postAncmnt.class);
        startActivity(intent);
    }

    public void openEmerCntct() {

        Intent intent = new Intent(this, EmrgncyContct.class);
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
}
