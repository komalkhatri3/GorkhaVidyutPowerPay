package com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.popla.gorkhavidyutpowerpay.R;

import java.util.ArrayList;
import java.util.List;


public class EmployeeAdapter extends ArrayAdapter{
    List list = new ArrayList();
    public EmployeeAdapter(Context context, int resources)
    {
        super(context,resources);
    }
    static class DataHandler
    {
        TextView name;
        TextView designations;

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
        DataHandler handler;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.all_employee_layout, parent, false);
            handler = new DataHandler();
            handler.name = (TextView) row.findViewById(R.id.emp_name);
            handler.designations = (TextView) row.findViewById(R.id.emp_desig);
            row.setTag(handler);
        }
        else
        {
            handler=(DataHandler) row.getTag();
        }
        EmployeeDataProvider dataProvider = (EmployeeDataProvider) this.getItem(position);
        handler.name.setText(dataProvider.getEmp_name());
        handler.designations.setText(dataProvider.getEmp_designation());
        return row;
    }
}
