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

import com.example.utaresidentapp.Controller.LoginController;
import com.example.utaresidentapp.users.User_WorkOrder;
import com.example.*;

public class DummyActivity extends AppCompatActivity {

    private Button btn_workordr;
    private Button btn_viewancmnt;
    private Button btn_emercont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);


        btn_workordr = findViewById(R.id.button2);
        btn_workordr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkOrder();
                            }


        });
        btn_emercont = findViewById(R.id.button4);
        btn_emercont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmerCntct();
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
        startActivity(intent);
    }
    public void openEmerCntct() {

        Intent intent = new Intent(this, EmrgncyContct.class);
        startActivity(intent);
    }
}
