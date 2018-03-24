package com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popla.gorkhavidyutpowerpay.R;

import java.util.ArrayList;
import java.util.List;


public class EmployeeAdapter extends ArrayAdapter{
    List list = new ArrayList();
    Context mcontext;
    public EmployeeAdapter(Context context, int resources)
    {
        super(context,resources);
        mcontext = context;
    }
    static class DataHandler
    {
        TextView name;
        TextView designations;
        TextView emailid;
        Button b1;
    }
    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }
    @Override
    public int getCount()
    {
        return this.list.size();
    }
    @Override
    public Object getItem(int position)
    {
        return this.list.get(position);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View row;
        row = convertView;
        final DataHandler handler;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.activity_all_employee_layouts, parent, false);
            handler = new DataHandler();
            handler.name = (TextView) row.findViewById(R.id.emp_name);
            handler.designations = (TextView) row.findViewById(R.id.emp_desig);
            handler.emailid = (TextView) row.findViewById(R.id.emp_id);


            row.setTag(handler);
        }
        else
        {
            handler=(DataHandler) row.getTag();
        }



        handler.b1 = (Button) row.findViewById(R.id.emp_view);

        handler.b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //
                String s= "emp_id";
                // AppCompatActivity act = new AppCompatActivity();
                Intent i = new  Intent(mcontext,ParticularEmployeeDetail.class);
                i.putExtra(s,handler.emailid.getText().toString());
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);
                //Toast.makeText(mcontext,"Hi this is Mohit", Toast.LENGTH_SHORT).show();
            }
        });



        EmployeeDataProvider dataProvider = (EmployeeDataProvider) this.getItem(position);
        handler.name.setText(dataProvider.getEmp_name());
        handler.emailid.setText(dataProvider.getEmp_email());
        handler.designations.setText(dataProvider.getEmp_designation());


        return row;
    }
}
