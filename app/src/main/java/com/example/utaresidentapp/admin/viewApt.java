package com.example.utaresidentapp.admin;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.Controller.AdminController;
import com.example.utaresidentapp.SecScreen;

import java.util.ArrayList;
import java.util.List;

public class viewApt extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(viewApt.this, "INSIDE VIEW APT", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_apt);

        ListView listView =(ListView)findViewById(R.id.listView);

         ArrayList<String> mylist = new ArrayList<>();
       // TableLayout tb = (TableLayout)findViewById(R.id.tableView);

         Cursor data = db.getListContents();

         if(data.getCount() == 0 ){
             Toast.makeText(viewApt.this, "Table has no records", Toast.LENGTH_SHORT).show();
         }
         else{
             while(data.moveToNext()){
                 mylist.add(data.getString(1));
                 mylist.add(data.getString(2));
                // mylist.add(data.getString(3));
                 ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mylist);

                 listView.setAdapter(listAdapter);

                 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                     @Override
                     public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                         Intent intent = new Intent(viewApt.this, addApt.class );
                         startActivity(intent);

                     }
                 });
             }

         }

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
