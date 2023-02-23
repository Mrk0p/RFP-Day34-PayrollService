package com.bridgelabz.payroll_service;

import java.sql.*;
import java.util.Enumeration;

public class PayrollService {

    static Connection connect = null;

    public static void main(String[] args) throws EmployeeCustomException, SQLException {
        connect = connected();
        retrieveData(connect);
        updateData(connect);
    }

    public static Connection connected() throws EmployeeCustomException {

        String URL = "jdbc:mysql://localhost:3306/payroll_service ? useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        listDrivers();
        try {
            System.out.println("Connecting to Database...:" + URL);
            connection = DriverManager.getConnection(URL, userName, password);
            System.out.println("connection successful" + connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void retrieveData(Connection connection) throws EmployeeCustomException, SQLException {

        PreparedStatement ps = connection.prepareStatement("Select * from employee_payroll");
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            System.out.print(result.getInt(1));
            System.out.print(" | ");
            System.out.print(result.getString(2));
            System.out.print(" | ");
            System.out.print(result.getString(3));
            System.out.print(" | ");
            System.out.println();
        }
    }
    public static void updateData(Connection connection) throws EmployeeCustomException, SQLException {

        PreparedStatement ps = connection.prepareStatement("update employee_payroll set salary = ? where id = ?;");
        ps.setDouble(1, 3000000.00);
        ps.setInt(2, 1);

        ps.executeUpdate();
        System.out.println("Update Successfully");
    }

    public static void listDrivers() {

        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements())
        {

            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" " + driverClass.getClass().getName());
        }
    }
}
