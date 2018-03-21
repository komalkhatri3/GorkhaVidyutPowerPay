package com.example.popla.gorkhavidyutpowerpay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data.ShowAllEmploye;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;

public class EmployeRegistration extends AppCompatActivity {

    Spinner spinner ;
    ArrayAdapter<CharSequence> adapter ;
    EditText ename,emailid,emobile,eage,edd,emm,eyyyy;
    Spinner edesig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe_registration);
        spinner =(Spinner)findViewById(R.id.designation);
        adapter = ArrayAdapter.createFromResource(this,R.array.designation,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ename = (EditText)findViewById(R.id.name);
        emailid = (EditText)findViewById(R.id.email);
        emobile = (EditText)findViewById(R.id.mobile);
        edd = (EditText)findViewById(R.id.dates);
        emm = (EditText)findViewById(R.id.months);
        eyyyy = (EditText)findViewById(R.id.years);
        edesig = (Spinner)findViewById(R.id.designation);
    }
    public void registerEmploye(View view)
    {

       Toast.makeText(this,"Employe Registered",Toast.LENGTH_LONG).show();
        DaoSession daoSession =((AppController)getApplication()).getDaoSession();

        Employee employees = new Employee();
        //employees.setEmp_id(1l);
        employees.setEmp_name(ename.getText().toString());
        employees.setEmp_email_id(emailid.getText().toString());
        employees.setEmp_mobile(emobile.getText().toString());
        employees.setEmp_age(edd.getText().toString()+emm.getText().toString()+eyyyy.getText().toString());
        employees.setEmp_designation(edesig.getSelectedItem().toString());
        daoSession.getEmployeeDao().insert(employees);

    }
    public void viewAllEmploye(View view)
    {
        Intent intent = new Intent(this,ShowAllEmploye.class);
        startActivity(intent);

    }

}
