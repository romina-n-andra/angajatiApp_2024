package AngajatiApp.repository;

import AngajatiApp.model.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeModifyMockTest {
    private EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testNullEmployee() {

        employeeMock.modifyEmployeeFunction(null, DidacticFunction.TEACHER);

        assertEquals(DidacticFunction.ASSISTENT, employeeMock.getEmployeeList().get(0).getFunction());
        assertEquals(DidacticFunction.LECTURER, employeeMock.getEmployeeList().get(1).getFunction());
        assertEquals(DidacticFunction.LECTURER, employeeMock.getEmployeeList().get(2).getFunction());
        assertEquals(DidacticFunction.LECTURER, employeeMock.getEmployeeList().get(3).getFunction());
        assertEquals(DidacticFunction.TEACHER, employeeMock.getEmployeeList().get(4).getFunction());
        assertEquals(DidacticFunction.TEACHER, employeeMock.getEmployeeList().get(5).getFunction());
    }

    @Test
    public void testModifyFunctionExistingEmployee() {
        System.out.println("Detalii initiale despre angajat:" + " " + employeeMock.getEmployeeList().get(3));

        Employee employee = employeeMock.getEmployeeList().get(3);
        DidacticFunction newFunction = DidacticFunction.TEACHER;

        employeeMock.modifyEmployeeFunction(employee, newFunction);
        System.out.println("Detalii actualizate despre angajat:" + " " +employeeMock.getEmployeeList().get(3));

        assertEquals(newFunction, employeeMock.getEmployeeList().get(1).getFunction());
    }
}