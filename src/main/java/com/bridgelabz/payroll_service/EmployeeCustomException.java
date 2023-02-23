package com.bridgelabz.payroll_service;

public class EmployeeCustomException extends Exception {

    public EmployeeCustomException(String Invalid_Input)
    {
        super(Invalid_Input);
    }
}
