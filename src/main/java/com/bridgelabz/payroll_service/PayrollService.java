package com.bridgelabz.payroll_service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PayrollService {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        listDrivers();
        try {
            System.out.println("Connecting to Database...:" + URL);
            Connection connection = DriverManager.getConnection(URL, userName, password);

            System.out.println("connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
