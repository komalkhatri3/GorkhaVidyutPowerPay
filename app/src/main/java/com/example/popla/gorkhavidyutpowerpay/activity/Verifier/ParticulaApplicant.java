package com.example.popla.gorkhavidyutpowerpay.activity.Verifier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.PowerApplication;
import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.new_connections.AddNewConnection;
import com.example.popla.gorkhavidyutpowerpay.db.DaoSession;
import com.example.popla.gorkhavidyutpowerpay.db.Employee;
import com.example.popla.gorkhavidyutpowerpay.db.New_Connection;

import java.util.ArrayList;
import java.util.List;

public class ParticulaApplicant extends AppCompatActivity {


    String s, l;
    int point;
    TextView headname;
    DaoSession daoSession;
    EditText editid, editname, editmail, editmobile, editage, editdesig, editlandma, editcity, editpin, plotsize, coveredarea, conntype, reqkv, purpose, aadhar, submitdate, kno, status, userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particula_applicant);


        Intent intent = getIntent();
        s = "emp_id";
        l = intent.getStringExtra(s);
        headname = (TextView) findViewById(R.id.heading_name);
        editid = (EditText) findViewById(R.id.edit_app_id);
        editname = (EditText) findViewById(R.id.edit_app_name);
        editmail = (EditText) findViewById(R.id.edit_app_father);
        editmobile = (EditText) findViewById(R.id.edit_app_dob);
        editage = (EditText) findViewById(R.id.edit_age);
        editdesig = (EditText) findViewById(R.id.edit_app_area);
        editlandma = (EditText) findViewById(R.id.edit_app_landmark);
        editcity = (EditText) findViewById(R.id.edit_app_city);
        editpin = (EditText) findViewById(R.id.edit_app_pin);
        plotsize = (EditText) findViewById(R.id.edit_app_plot_size);
        coveredarea = (EditText) findViewById(R.id.edit_app_covered_area);
        conntype = (EditText) findViewById(R.id.edit_app_con_type);
        reqkv = (EditText) findViewById(R.id.edit_app_reqKv);
        purpose = (EditText) findViewById(R.id.edit_purpose);
        aadhar = (EditText) findViewById(R.id.edit_adhar);
        submitdate = (EditText) findViewById(R.id.edit_submit_date);
        kno = (EditText) findViewById(R.id.edit_kno);
        status = (EditText) findViewById(R.id.edit_status);
        userid = (EditText) findViewById(R.id.edit_user_id);
        daoSession = ((PowerApplication) getApplication()).getDaoSession();
       // List<String> list = new ArrayList<>();

        List <New_Connection> list = daoSession.getNew_ConnectionDao().loadAll();
/*
        for (int i = 0; i < list.size(); i++) {
            if (l.equals(list.get(i).getEmp_ema)) {
                point = i;
                break;
            }
        }
        */
        Toast.makeText(this, list.get(point).getApplicant_aadhar().toString(), Toast.LENGTH_SHORT).show();

       // headname.setText(list.get(0).ge);
        editid.setText(list.get(point).getApplication_id().toString());
        editname.setText(list.get(point).getApplicant_name());
        editmail.setText(list.get(point).getApplicant_fname());
        editmobile.setText(list.get(point).getApplicant_DOB());
        editage.setText(list.get(point).getApplicant_area());
        editdesig.setText(list.get(point).getApplicant_area());
        editlandma.setText(list.get(point).getApplicant_landmark());
        editcity.setText(list.get(point).getApplicant_city());
        editpin.setText(list.get(point).getApplicant_pincode());
      //  plotsize.setText(list.get(point).getApplicant_Psize());
      //  coveredarea.setText(list.get(point).getApplicant_covereda());
        conntype.setText(list.get(point).getApplicant_contype());
      //  reqkv.setText(list.get(point).getApplicant_reqKV());
      //  purpose.setText(list.get(point).ge);
        aadhar.setText(list.get(point).getApplicant_aadhar());
        kno.setText(list.get(point).getK_no());
        userid.setText(list.get(point).getNew_Con_LogInBy());
      //  status.setText(list.get(point).ge);
        submitdate.setText(list.get(point).getSubmit_date());




    }





    public void accept(View view)
    {

    }
    public void reject(View view)
    {

    }
}
