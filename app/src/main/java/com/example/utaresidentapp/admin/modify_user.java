package com.example.utaresidentapp.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utaresidentapp.R;
import com.example.utaresidentapp.profile;

public class modify_user extends AppCompatActivity {
    //Declaring button for assigning to button from xml
    Button search_user;

    // Declaring EditText for capturing user input from xml
    EditText utaid_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);
        utaid_editText = (EditText) findViewById(R.id.editText2);
        Log.d("sara_sessio_var", "utaid_editText " + utaid_editText);
        //assigning  identified xml field by id to declared button
        search_user = (Button)findViewById(R.id.button14);
        // On button click when Search button is hit
        //final String temp_id = utaid_editText.getText().toString();
       // Log.d("sara_sessio_var", "userid " + String.valueOf(temp_id));
        if(utaid_editText.length() == 0)
        search_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String uta_id = utaid_editText.getText().toString();
                Log.d("sara_sessio_var", "uta_id " + uta_id);
                Intent intent = new Intent(modify_user.this, admin_update_profile.class );
                intent.putExtra("MAV_ID", uta_id);
                startActivity(intent);

            }
        }
        );
        else{
            Toast.makeText(modify_user.this, "UTA ID can't be empty", Toast.LENGTH_SHORT).show();
            Log.d("sara_mod", "userid " + String.valueOf(utaid_editText.length()));
        }


    }
}
