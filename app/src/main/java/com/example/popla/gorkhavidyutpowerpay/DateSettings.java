package com.example.popla.gorkhavidyutpowerpay;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * Created by DELL on 3/19/2018.
 */

public class DateSettings implements DatePickerDialog.OnDateSetListener {
    Context context;
    public int year,month,day;

    public DateSettings(Context context)
    {
        this.context=context;
    }

    public DateSettings() {

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        year=i;
        month=i1;
        day=i2;


    }
}
