package model;

import org.junit.Test;

public class EmployeeTest {

    @Test
    public void testConstructor() {
        Employee employeeX = new Employee(29, "a@email.com",
                "Ivan", "Ivanov", "+4812345678");
    }
}
