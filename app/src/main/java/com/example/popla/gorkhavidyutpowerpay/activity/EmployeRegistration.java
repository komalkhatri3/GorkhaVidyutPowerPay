package com.example.popla.gorkhavidyutpowerpay.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.AppController;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data.ShowAllEmploye;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;

import java.util.Calendar;

public class EmployeRegistration extends FragmentActivity {

    Spinner spinner ;
    DatePickerDialog datePickerDialog;
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
        edd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog =new DatePickerDialog(EmployeRegistration.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        edd.setText(i2 + "/"
                                + (i1 + 1) + "/" + i);
                    }
                },mYear,mMonth,mDay);
                datePickerDialog.show();

            }
        });
        //emm = (EditText)findViewById(R.id.months);
        //eyyyy = (EditText)findViewById(R.id.years);
        edesig = (Spinner)findViewById(R.id.designation);
    }
    public void registerEmploye(View view)
    {
        DaoSession daoSession =((AppController)getApplication()).getDaoSession();

        Employee employees = new Employee();
        //employees.setEmp_id(1l);
        employees.setEmp_name(ename.getText().toString());
        employees.setEmp_email_id(emailid.getText().toString());
        employees.setEmp_mobile(emobile.getText().toString());
        employees.setEmp_age(edd.getText().toString());
        employees.setEmp_designation(edesig.getSelectedItem().toString());
        daoSession.getEmployeeDao().insert(employees);
        Toast.makeText(this,"Employe Registered",Toast.LENGTH_LONG).show();

    }
    public void viewAllEmploye(View view)
    {
        Intent intent = new Intent(this,ShowAllEmploye.class);
        startActivity(intent);

    }

}
