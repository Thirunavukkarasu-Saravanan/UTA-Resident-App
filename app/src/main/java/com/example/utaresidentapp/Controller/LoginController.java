package com.example.utaresidentapp.Controller;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.utaresidentapp.users.User_WorkOrder;

public class LoginController extends AppCompatActivity {

    public void btnClick(View v) {

        Intent intent = new Intent(this, User_WorkOrder.class);
        startActivity(intent);
    }


}
