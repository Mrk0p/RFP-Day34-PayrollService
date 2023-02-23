package com.bridgelabz.payroll_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeePayroll {

    public static void preparedStatement(String name, double salary) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root",
                    "root");
            String s = "update employee_payroll set Salary = ? where Name=?";
            PreparedStatement ps = connection.prepareStatement(s);
            ps.setDouble(1, salary);
            ps.setString(2, name);
            ps.executeUpdate();
            boolean result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
        preparedStatement("Terrisa",  300000.000);

    }
}
