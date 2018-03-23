package com.example.popla.gorkhavidyutpowerpay.activity.ApproverP;

/**
 * Created by DELL on 3/20/2018.
 */

public class ApproverDataProvider
{
    private Long App_Id;
    private String App_Name;
    private String App_Area;

        public ApproverDataProvider(Long app_Id, String app_Name, String app_Area) {
            App_Id = app_Id;
            App_Name = app_Name;
            App_Area = app_Area;
        }


        public String getApp_Name() {
        return App_Name;
    }

         public String getApp_Area() {
        return App_Area;
    }

        public void setApp_Name(String app_Name) {
        App_Name = app_Name;
    }

             public void setApp_Area(String app_Area) {
        App_Area = app_Area;
    }


             public Long getApp_Id() {
            return App_Id;
        }

        public void setApp_Id(Long app_Id) {
            App_Id = app_Id;
        }
}
