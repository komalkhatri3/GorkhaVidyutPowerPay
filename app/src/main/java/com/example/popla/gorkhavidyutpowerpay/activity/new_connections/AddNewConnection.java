package com.example.popla.gorkhavidyutpowerpay.activity.new_connections;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.Calendar;

public class AddNewConnection extends FragmentActivity{
    //DateSettings dateSettings;

    Spinner spinner;
    DatePickerDialog datePickerDialog;
    ArrayAdapter<CharSequence> arrayAdapter;
    EditText name,fname,dob,occupation,area,landmark,city,pincode,psize,covereda,reqKV,pos,addhar,ed;
    Spinner contype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_connection);
        //dateSettings=new DateSettings();
        spinner=(Spinner) findViewById(R.id.connectionspinner);
        arrayAdapter=ArrayAdapter.createFromResource(this,R.array.Connection_type,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        /*spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i)+"is selected",Toast.LENGTH_LONG).show();
            }
        });*/
        name=(EditText)findViewById(R.id.Add_name);
        fname=(EditText)findViewById(R.id.Add_fathern);
        dob=(EditText)findViewById(R.id.edit12);
        occupation=(EditText)findViewById(R.id.Add_occupation);
        area=(EditText)findViewById(R.id.Add_area);
        landmark=(EditText)findViewById(R.id.Add_landmark);
        city=(EditText)findViewById(R.id.Add_city);
        pincode=(EditText)findViewById(R.id.Add_pincode);
        psize=(EditText)findViewById(R.id.Add_plotsize);
        covereda=(EditText)findViewById(R.id.Add_coveredarea);
        reqKV=(EditText)findViewById(R.id.required_kv);
        pos=(EditText)findViewById(R.id.pos);
        addhar=(EditText)findViewById(R.id.Adhar_add);
        contype=(Spinner) findViewById(R.id.connectionspinner);
        ed=(EditText) findViewById(R.id.edit12);
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog=new DatePickerDialog(AddNewConnection.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        ed.setText(i2 + "/"
                                + (i1 + 1) + "/" + i);

                    }
                },mYear,mMonth,mDay);
                datePickerDialog.show();
            }
        });
    }

    public void submitNewdetails(View view)
    {


        DaoSession daoSession =((PowerApplication)getApplication()).getDaoSession();
        New_Connection new_connection=new New_Connection();
        new_connection.setApplicant_name(name.getText().toString());
        new_connection.setApplicant_fname(fname.getText().toString());
        new_connection.setApplicant_DOB(dob.getText().toString());
        new_connection.setApplicant_occupaion(occupation.getText().toString());
        new_connection.setApplicant_area(area.getText().toString());
        new_connection.setApplicant_landmark(landmark.getText().toString());
        new_connection.setApplicant_city(city.getText().toString());
        new_connection.setApplicant_pincode(pincode.getText().toString());
        new_connection.setApplicant_contype(contype.getSelectedItem().toString());
        new_connection.setApplicant_Psize(Float.parseFloat(psize.getText().toString()));
        new_connection.setApplicant_covereda(Float.parseFloat(covereda.getText().toString()));
        new_connection.setApplicant_reqKV(Float.parseFloat(reqKV.getText().toString()));
        new_connection.setApplicant_pos(pos.getText().toString());
        new_connection.setApplicant_aadhar(addhar.getText().toString());
        new_connection.setNew_Con_LogInBy("komal");
        new_connection.setNew_Con_Req_S("initial");
        daoSession.getNew_ConnectionDao().insert(new_connection);
        Toast.makeText(this,"Employee Registered",Toast.LENGTH_LONG).show();
    }
}
