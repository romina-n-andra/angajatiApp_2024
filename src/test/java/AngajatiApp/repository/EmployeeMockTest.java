package AngajatiApp.repository;

import AngajatiApp.model.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private EmployeeMock employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = new EmployeeMock();
    }

    @Test
    void addEmployeePass() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8, "Alina", "Salajan", "2971205020080", DidacticFunction.ASSISTENT, 5000.00));
        assertEquals(7, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeWrongFormat() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8, "4lin4", "S4l4j4n", "2971205020080", DidacticFunction.ASSISTENT, 5000.00));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeWrongCNPLonger() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8, "Alina", "Salajan", "99971205020080", DidacticFunction.ASSISTENT, 5000.00));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeWrongSalary() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8,"Alina", "Salajan", "2971205020080", DidacticFunction.ASSISTENT, -1.00));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeWrongCNPShorter() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8,"Alina", "Salajan", "971205020080", DidacticFunction.ASSISTENT, 5000.00));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeZeroSalary() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8, "Alina", "Salajan", "2971205020080", DidacticFunction.ASSISTENT, 0.00));
        assertEquals(6, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeSalaryOne() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8,"Alina", "Salajan", "2971205020080", DidacticFunction.ASSISTENT, 1.00));
        assertEquals(7, employeeRepository.getEmployeeList().size());
    }

    @Test
    void addEmployeeSalaryTwo() {
        assertEquals(6, employeeRepository.getEmployeeList().size());
        employeeRepository.addEmployee(new Employee(8,"Alina", "Salajan", "2971205020080", DidacticFunction.ASSISTENT, 2.00));
        assertEquals(7, employeeRepository.getEmployeeList().size());
    }
}