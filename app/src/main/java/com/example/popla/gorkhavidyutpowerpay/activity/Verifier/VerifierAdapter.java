package com.example.popla.gorkhavidyutpowerpay.activity.Verifier;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data.EmployeeAdapter;
import com.example.popla.gorkhavidyutpowerpay.activity.Employee_Data.EmployeeDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 3/20/2018.
 */

public class VerifierAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public VerifierAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
    static class DataHandler
    {
        TextView ApplicationId;
        TextView Applicant_Area;

    }
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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
       View row;
        row=convertView;
        DataHandler handler;
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.verifier_layout, parent, false);
            handler = new DataHandler();
            handler.ApplicationId = (TextView) row.findViewById(R.id.Application_Id);
            handler.Applicant_Area = (TextView) row.findViewById(R.id.Application_Name);
            row.setTag(handler);

        }
        else{
            handler=(DataHandler) row.getTag();
        }
        VerifierDataProvider dataProvider = (VerifierDataProvider) this.getItem(position);
        handler.ApplicationId.setText(dataProvider.getApp_Name());
        handler.Applicant_Area.setText(dataProvider.getApp_Area());
        return row;
    }
}
