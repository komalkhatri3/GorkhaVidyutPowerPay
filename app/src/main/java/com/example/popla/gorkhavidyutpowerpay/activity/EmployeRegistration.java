package com.example.popla.gorkhavidyutpowerpay.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.R;

public class EmployeRegistration extends AppCompatActivity {

    Spinner spinner ;
    ArrayAdapter<CharSequence> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_registration);
        spinner =(Spinner)findViewById(R.id.designation);
        adapter = ArrayAdapter.createFromResource(this,R.array.designation,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    public void registerEmploye(View view)
    {
       Toast.makeText(this,"Employe Registered",Toast.LENGTH_LONG).show();
    }
    public void viewAllEmploye(View view)
    {

    }

}
