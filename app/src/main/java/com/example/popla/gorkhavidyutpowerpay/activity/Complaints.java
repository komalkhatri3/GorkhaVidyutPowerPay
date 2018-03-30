package com.example.popla.gorkhavidyutpowerpay.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.Complaint_Details;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Complaints extends AppCompatActivity {
    Spinner spinner,spinner2;
    EditText K_No,other,temp;
    String s;
    ArrayAdapter<CharSequence> arrayAdapter,arrayAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);
        other=(EditText)findViewById(R.id.other_comp);
        other.setVisibility(View.INVISIBLE);
        spinner=(Spinner) findViewById(R.id.complaint_spinner);
        arrayAdapter= ArrayAdapter.createFromResource(this,R.array.Complaint_Type,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
         temp=(EditText) findViewById(R.id.Temporary);
        //other.setText(spinner.getSelectedItem().toString());
        spinner2=(Spinner) findViewById(R.id.Sub_com_spin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             s=spinner.getItemAtPosition(i).toString();
               //other.setText(s);

                if(s.equals("Meter Problem"))
                {

                    arrayAdapter2= ArrayAdapter.createFromResource(view.getContext(),R.array.Sconnection_TypeM,android.R.layout.simple_spinner_item);
                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);
                    other.setVisibility(View.INVISIBLE);
                    spinner2.setVisibility(View.VISIBLE);
                }
                else if(s.equals("Voltage Problem"))
                {
                    arrayAdapter2= ArrayAdapter.createFromResource(view.getContext(),R.array.Sconnection_TypeV,android.R.layout.simple_spinner_item);
                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);
                    other.setVisibility(View.INVISIBLE);
                    spinner2.setVisibility(View.VISIBLE);
                }
                else if(s.equals("Power Cut Problem"))
                {
                    arrayAdapter2= ArrayAdapter.createFromResource(view.getContext(),R.array.Sconnection_TypeP,android.R.layout.simple_spinner_item);
                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);
                    other.setVisibility(View.INVISIBLE);
                    spinner2.setVisibility(View.VISIBLE);
                }
                else if(s.equals("Bill Related Problem"))
                {
                    arrayAdapter2= ArrayAdapter.createFromResource(view.getContext(),R.array.Sconnection_TypeB,android.R.layout.simple_spinner_item);
                    arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(arrayAdapter2);
                    other.setVisibility(View.INVISIBLE);
                    spinner2.setVisibility(View.VISIBLE);
                }
                else if(s.equals("Other"))
                {
                    other.setVisibility(View.VISIBLE);
                    spinner2.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                temp.setText(spinner2.getItemAtPosition(i).toString());

                    if(spinner2.getItemAtPosition(i).toString().equals("Other"))
                    {
                        other.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        other.setVisibility(View.INVISIBLE);
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

              //arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner2.setAdapter(arrayAdapter2);

    }
    public void BookComplaint(View view)
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / YYYY ");
        String strDate = "Current Date : " + mdformat.format(calendar.getTime());
        //Toast.makeText(this,"Employe Registered",Toast.LENGTH_LONG).show();
        DaoSession daoSession =((PowerApplication)getApplication()).getDaoSession();
        other.setText(strDate);
        Complaint_Details complaint_details= new Complaint_Details();
        //employees.setEmp_id(1l);
        complaint_details.setK_No(K_No.getText().toString());
        complaint_details.setLogin_by(K_No.getText().toString());
        complaint_details.setSubmit_Date(strDate);
        complaint_details.setComp_Msg("");
        complaint_details.setStatus("");
        daoSession.getComplaint_DetailsDao().insert(complaint_details);
        //orderAsc(BirthdayDao.Properties.DOB).list();

            }
}
