package EmployeeObjects;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class CommissionEmployeeTest {

    private CommissionEmployee emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);
    @Test
    void increaseSales() {
        emp.increaseSales(); // Add 100 to sales (default behavior)
        Assertions.assertEquals(100.0, emp.getSales());

        emp.increaseSales(250.0); // Add positive sales
        Assertions.assertEquals(350.0, emp.getSales());

        emp.increaseSales(-150.0); // Add negative sales
        Assertions.assertEquals(350.0, emp.getSales()); // Sales should remain unchanged

        emp.increaseSales(0); // Add 0 sales
        Assertions.assertEquals(350.0, emp.getSales()); // Sales should remain unchanged

    }

    @Test
    void annualRaise() {
        Assertions.assertEquals(.0265, emp.getRate());
        emp.annualRaise();
        Assertions.assertEquals(.0285, emp.getRate());
        emp.annualRaise();
        Assertions.assertEquals(.0305, emp.getRate());
    }

    @Test
    void holidayBonus() {
        Assertions.assertEquals(0, emp.holidayBonus());
    }
}