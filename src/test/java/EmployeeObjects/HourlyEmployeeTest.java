package EmployeeObjects;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


class HourlyEmployeeTest {
    private HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);

    @Test
    void increaseHours() {
        emp.increaseHours(); // Add 1 hour (default behavior)
        Assertions.assertEquals(1.0, emp.getHoursWorked());

        emp.increaseHours(2.5); // Add positive hours
        Assertions.assertEquals(3.5, emp.getHoursWorked());

        emp.increaseHours(-1.5); // Add negative hours
        Assertions.assertEquals(3.5, emp.getHoursWorked()); // Hours should remain unchanged

        System.out.println(emp.getHoursWorked());

        emp.increaseHours(0); // Add 0 hours
        Assertions.assertEquals(3.5, emp.getHoursWorked()); // Hours should remain unchanged

    }

    @Test
    void annualRaise() {
        Assertions.assertEquals(32.85, emp.getWage());
        emp.annualRaise();
        Assertions.assertEquals(34.49, emp.getWage());
    }

    @Test
    void calculateWeeklyPay() {
        Assertions.assertEquals(0.0, emp.calculateWeeklyPay()); // No hours worked, so pay should be 0.0

        emp.increaseHours(35);
        Assertions.assertEquals(1149.75, emp.calculateWeeklyPay()); // 35 hours worked, no overtime

        emp.increaseHours(10);
        Assertions.assertEquals(1560.38, emp.calculateWeeklyPay()); // 45 hours worked, 40 regular hours + 5 overtime

        // Custom test cases
        testCalculateWeeklyPay(35, 1149.75); // 35 hours worked, no overtime
        testCalculateWeeklyPay(45, 1560.38); // 45 hours worked, 40 regular hours + 5 overtime
    }

    private void testCalculateWeeklyPay(double hoursWorked, double expectedPay) {
        emp.resetWeek();
        emp.increaseHours(hoursWorked);
        Assertions.assertEquals(expectedPay, emp.calculateWeeklyPay());
    }



}