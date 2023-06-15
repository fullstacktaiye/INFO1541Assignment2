package EmployeeObjects;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


class SalaryEmployeeTest {

    private SalaryEmployee emp = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
    @Test
    void calculateWeeklyPay() {
        Assertions.assertEquals(1237.02, emp.calculateWeeklyPay()); 
//        System.out.println(emp.calculateWeeklyPay());

    }

    @Test
    void holidayBonus() {
        Assertions.assertEquals(2164.54, emp.holidayBonus());
//        System.out.println(emp.holidayBonus());
    }
}