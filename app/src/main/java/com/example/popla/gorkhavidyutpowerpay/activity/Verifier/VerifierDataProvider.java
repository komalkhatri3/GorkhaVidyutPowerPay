package com.example.popla.gorkhavidyutpowerpay.activity.Verifier;

/**
 * Created by DELL on 3/20/2018.
 */

public class VerifierDataProvider {
    private String App_id;
    private String App_Name;
    private String App_Area;

    public String getApp_Name() {
        return App_Name;
    }

    public String getApp_Area() {
        return App_Area;
    }

    public VerifierDataProvider(String app_id, String app_Name, String app_Area) {
        this.setApp_id(app_id);
        this.setApp_Name(app_Name);
        this.setApp_Area(app_Area);
    }

    public void setApp_Name(String app_Name) {
        App_Name = app_Name;
    }

    public void setApp_Area(String app_Area) {
        App_Area = app_Area;
    }
    public String getApp_id()
    {
        return App_id;
    }
    public void setApp_id(String app_id)
    {
        App_id = app_id;
    }
}
