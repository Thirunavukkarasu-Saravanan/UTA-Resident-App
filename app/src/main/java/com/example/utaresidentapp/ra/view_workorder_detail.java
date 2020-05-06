package com.example.utaresidentapp.ra;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utaresidentapp.DatabaseHelper;
import com.example.utaresidentapp.R;
import com.example.utaresidentapp.SecScreen;
import com.example.utaresidentapp.admin.addUser;
import com.example.utaresidentapp.admin.updApt;
import com.example.utaresidentapp.admin.view_apt_tab;

public class view_workorder_detail extends AppCompatActivity {

    //For identifying Radiogroups
    RadioGroup radioGroup;
    RadioButton rb1; //= (RadioButton) findViewById(R.id.radioButton);
    RadioButton rb2; //= (RadioButton) findViewById(R.id.radioButton2);
    // To check for status of work order
    static int work_status_rb = 0;
   static String work_status_conv = null;
   static int num_work_status_conv = 1;
    // Work id from session variable to retrieve data
    int ses_work_id=0;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workorder_detail);


        rb1 = (RadioButton) findViewById(R.id.radioButton4);
        rb2 = (RadioButton) findViewById(R.id.radioButton5);

        final TextView workreqby =(TextView) findViewById(R.id.work_req_by);
        final TextView aptblock=(TextView) findViewById(R.id.apt_block);
        final TextView aptno =(TextView) findViewById(R.id.apt_no);
        final TextView reqon =(TextView) findViewById(R.id.req_on);
        final TextView desc =(TextView)findViewById(R.id.desc);
        final TextView status =(TextView) findViewById(R.id.status);

        //fetch apt_id from intent that is getting transferred from view_apt page with apt_id string key.
        ses_work_id= getIntent().getIntExtra("work_id",0);
        //if apt_id is equal to
        if(ses_work_id!=0){
            Cursor cursor= db.getWorkOrderRequest(String.valueOf(ses_work_id));
            if(cursor.moveToFirst()){
                final String work_id=cursor.getString(0);
                String work_requestby=cursor.getString(1);
                String work_block=cursor.getString(2);
                String work_no=cursor.getString(3);
                String work_desc=cursor.getString(4);
                String work_date=cursor.getString(5);
                String work_time=cursor.getString(6);
                final String work_status=cursor.getString(7);

                workreqby.setText(work_requestby);
                aptblock.setText(work_block);
                aptno.setText(work_no);
                reqon.setText(work_date);
                desc.setText(work_desc);
                status.setText(work_status);

                if(work_status.equals("Active")){
                    rb1.setChecked(true);
                    Log.d("sara_radio", "setting radio button from table : " + rb1.getText() );
                }
                else {
                    rb2.setChecked(true);
                    Log.d("sara_radio", "setting radio button from table : " + rb1.getText());
                }

                // Set Word order Status to radiobutton
               if(work_status.equals("Active")){

                    work_status_rb = 1;
                    Log.d("sara_radio_workorder", "setting radio button to variable from table : " + work_status);
                }
                else{
                    work_status_rb = 2;
                    Log.d("sara_radio_workorder", "setting radio button  to variable from table : " + work_status);
                }


                Button updbtn = (Button)findViewById(R.id.button16);
                updbtn.setOnClickListener(new View.OnClickListener() {

                                              @Override
                                              public void onClick(View v) {
                                                  Log.d("sara_updstatus", "work_status " + work_status);
                                                  Log.d("sara_updstatus", "work_status_conv " + work_status_conv);
                                                  //boolean resu = (!work_status.equals(work_status_conv));
                                                    //if(!work_status.equals(work_status_conv)
                                                  boolean resu = work_status_rb == num_work_status_conv;
                                                  if(work_status_rb == num_work_status_conv){


                                                       // Log.d("sara_updstatus", "work_status_rb " + work_status_rb);
                                                       // Log.d("sara_updstatus", "num_work_status_conv " + num_work_status_conv);
                                                       // Log.d("sara_updstatus", "result " + resu);
                                                      //Log.d("sara_updstatus", "insert error ") ;

                                                       Toast.makeText(view_workorder_detail.this, "No change in status, Please try again with different status", Toast.LENGTH_SHORT).show();


                                                    }
                                                    else{

                                                    //  Log.d("sara_updstatus", "work_status_rb " + work_status_rb);
                                                     // Log.d("sara_updstatus", "num_work_status_conv " + num_work_status_conv);
                                                     // Log.d("sara_updstatus", "result " + resu);

                                                    //  Log.d("sara_updstatus", "insert now " );
                                                       int insertsucc = db.updstatus(ses_work_id,work_status_conv);

                                                        if(insertsucc != -1){
                                                            Toast.makeText(view_workorder_detail.this
                                                                    , "Status Updated Sucessfully", Toast.LENGTH_SHORT).show();
                                                            Intent intent=new Intent(view_workorder_detail.this, view_workorder_ra.class);
                                                            // Log.d("sara_updApt", "acmnt_id from ancmt " + v.getId());
                                                            //intent.putExtra("acmnt_id",v.getId());
                                                            startActivity(intent);
                                                        }
                                                        else{
                                                            Toast.makeText(view_workorder_detail.this, "Update Apartment failed, Pleas Try again", Toast.LENGTH_SHORT).show();
                                                        }
                                                      Toast.makeText(view_workorder_detail.this, "Status Updated Sucessfully", Toast.LENGTH_SHORT).show();


                                                    }



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

    public void onRadioButtonClicked(View v){
        RadioGroup rg = (RadioGroup) findViewById(R.id.myRadioGroup);
        RadioButton rb_1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rb_2 = (RadioButton) findViewById(R.id.radioButton2);

        // Is the current Radio Button checked?
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()){
            case R.id.radioButton4:
                if(checked)
                    work_status_conv = "Active";
                num_work_status_conv = 1;
                   // Toast.makeText(this, "Default switch case", Toast.LENGTH_SHORT).show();
                rb2.setChecked(false);
                Log.d("sara_radio", "inside rb1 " + (rb1.getText()) +  " "  );
                break;

            case R.id.radioButton5:
                if(checked)
                    work_status_conv = "Complete";
                num_work_status_conv = 2;
                   // Toast.makeText(this, "Default switch case", Toast.LENGTH_SHORT).show();
                rb1.setChecked(false);
                Log.d("sara_radio", "inside rb2 " + (rb2.getText()) +  " "  );
                Log.d("sara_radio", "inside rb2 " + (rb2.getText()) +  " "  );
                break;

            //case R.id.default_activity_button:
             //   Toast.makeText(addUser.this, "Default switch case", Toast.LENGTH_SHORT).show();
                //usertype = "3";
                //work_status_conv = "Active";
               // Log.d("sara_radio", "inside default " + (rb2.getText()) +  " "  +usertype);
        }
    }



}
