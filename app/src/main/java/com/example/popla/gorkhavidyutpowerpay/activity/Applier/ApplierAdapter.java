package com.example.popla.gorkhavidyutpowerpay.activity.Applier;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.popla.gorkhavidyutpowerpay.R;
import com.example.popla.gorkhavidyutpowerpay.activity.ApproverP.ApproverDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 3/21/2018.
 */

public class ApplierAdapter extends ArrayAdapter{

    List list=new ArrayList();
    Context mcontext;

    public ApplierAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
    static class DataHandler
    {
        TextView Application_Id;
        TextView Application_Name;
        TextView Applicant_Area;
        Button b1;
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
        final DataHandler handler;
        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.verifier_layout, parent, false);
            handler = new DataHandler();
            handler.Application_Id = (TextView) row.findViewById(R.id.Application_Id);
            handler.Application_Name=(TextView) row.findViewById(R.id.Application_Name) ;
            handler.Applicant_Area = (TextView) row.findViewById(R.id.Application_area);
            row.setTag(handler);

        }
        else{
            handler=(DataHandler) row.getTag();
        }
        handler.b1 = (Button) row.findViewById(R.id.Applicat_view);
        handler.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= "Application_Id";
                // AppCompatActivity act = new AppCompatActivity();
                Intent i = new  Intent(mcontext,ApplierDetail.class);
                i.putExtra(s,handler.Application_Id.getText().toString());
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);

            }
        });
       /* handler.b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //
                String s= "Application_Id";
                // AppCompatActivity act = new AppCompatActivity();
                Intent i = new  Intent(mcontext,ApplierDetail.class);
                i.putExtra(s,handler.Application_Id.getText().toString());
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(i);
                //Toast.makeText(mcontext,"Hi this is Mohit", Toast.LENGTH_SHORT).show();
            }
        });;*/
        ApplierDataProvider dataProvider = (ApplierDataProvider) this.getItem(position);
        handler.Application_Id.setText(dataProvider.getApp_Name());
        handler.Application_Name.setText(dataProvider.getApp_Name());
        handler.Applicant_Area.setText(dataProvider.getApp_Area());
        return row;
    }
}
