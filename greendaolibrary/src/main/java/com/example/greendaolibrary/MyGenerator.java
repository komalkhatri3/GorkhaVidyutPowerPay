package com.example.greendaolibrary;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.popla.gorkhavidyutpowerpay.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   private static void addTables(final Schema schema) {
        addUserEntities(schema);
       // addPhonesEntities(schema);
        addEmployeeEntities(schema);
        addRegisterEntities(schema);
        addNewConnectionEntities(schema);
        addComplaint_details(schema);
        addBill_detailsEntities(schema);


    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {
        Entity user = schema.addEntity("User");
        user.addLongProperty("user_id").primaryKey().autoincrement();
        user.addStringProperty("user_name");
        user.addStringProperty("user_type");
        user.addStringProperty("user_email");
        user.addIntProperty("user_mobile");
        user.addLongProperty("user_aadhar");;
        user.addStringProperty("user_password");
        user.addStringProperty("user_kno");
        return user;
    }
    private static Entity addElectricityRatesEntities(final Schema schema) {
        Entity electricityRate = schema.addEntity("ElectricityRate");
        electricityRate.addLongProperty("type");
        electricityRate.addFloatProperty("rate");
        return electricityRate;
    }
    private static Entity addEmployeeEntities(final Schema schema)
    {
        Entity employee = schema.addEntity("Employee");
        employee.addLongProperty("emp_id").primaryKey().autoincrement();
        employee.addStringProperty("emp_name");
        employee.addStringProperty("emp_email_id");
        employee.addStringProperty("emp_mobile");
        employee.addStringProperty("emp_age");
        employee.addStringProperty("emp_designation");
        return employee;
    }
    private static Entity addRegisterEntities(final Schema schema) {
        Entity register = schema.addEntity("Register");
        register.addLongProperty("user_id").primaryKey().autoincrement();
        register.addStringProperty("user_name");
        register.addStringProperty("user_email");
        register.addStringProperty("user_mobile");
        register.addStringProperty("user_aadhar");
        register.addStringProperty("user_password");
        register.addStringProperty("user_kno");
        return register;
    }
    private static Entity addNewConnectionEntities(final Schema schema)
    {
        Entity new_connection=schema.addEntity("New_Connection");
        new_connection.addLongProperty("application_id").primaryKey().autoincrement();
        new_connection.addStringProperty("applicant_name");
        new_connection.addStringProperty("applicant_fname");
        new_connection.addStringProperty("applicant_DOB");
        new_connection.addStringProperty("applicant_occupaion");
        new_connection.addStringProperty("applicant_area");
        new_connection.addStringProperty("applicant_landmark");
        new_connection.addStringProperty("applicant_city");
        new_connection.addStringProperty("applicant_pincode");
        new_connection.addStringProperty("applicant_contype");
        new_connection.addFloatProperty("applicant_Psize");
        new_connection.addFloatProperty("applicant_covereda");
        new_connection.addFloatProperty("applicant_reqKV");
        new_connection.addStringProperty("applicant_pos");
        new_connection.addStringProperty("applicant_aadhar");
        new_connection.addStringProperty("submit_date");
        new_connection.addStringProperty("k_no");
        return new_connection;
    }

    private static Entity addBill_detailsEntities(final Schema schema)
    {
        Entity billdetails=schema.addEntity("Bill_details");
        billdetails.addLongProperty("Bill_id").primaryKey().autoincrement();
        billdetails.addStringProperty("k_no");
        billdetails.addStringProperty("current_read");
        billdetails.addDateProperty("generated_date");
        billdetails.addStringProperty("due_date");
        billdetails.addStringProperty("paid_by");
        return billdetails;
    }

    private static Entity addComplaint_details(final Schema schema)
    {
        Entity complaint_details=schema.addEntity("Complaint_Details");
        complaint_details.addLongProperty("Complaint_Id").primaryKey().autoincrement();
        complaint_details.addStringProperty("K_No");
        complaint_details.addStringProperty("Login_by");
        complaint_details.addStringProperty("Submit_Date");
        complaint_details.addStringProperty("comp_Msg");
        complaint_details.addStringProperty("Status");
        return complaint_details;
    }
 //    private static Entity addPhonesEntities(final Schema schema) {
 //        Entity phone = schema.addEntity("Phone");
 //        phone.addIdProperty().primaryKey().autoincrement();
 //        phone.addIntProperty("user_id").notNull();
 //        phone.addStringProperty("number");
 //        return phone;
 //    }
}