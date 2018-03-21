package com.example.popla.gorkhavidyutpowerpay;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by DELL on 3/19/2018.
 */

public class PickerDialogs extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DateSettings dateSettings=new DateSettings(getActivity());
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(calendar.YEAR);
        int month=calendar.get(calendar.MONTH);
        int date=calendar.get(calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog=new DatePickerDialog(getActivity(),dateSettings,year,month,date);
        return dialog;
    }
}
