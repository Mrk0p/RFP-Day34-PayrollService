package com.bridgelabz.payroll_service;

import java.sql.*;

public class EmployeePayroll {

    public static void CreatedConnection() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root",
                    "root");
            Statement statement = connection.createStatement();
            statement.execute("select sum(Salary) from employee_payroll");
            statement.execute("select avg(Salary) from employee_payroll");
            statement.execute("select min(Salary) from employee_payroll");
            statement.execute("select count(Salary) from employee_payroll");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        CreatedConnection();
    }
}
