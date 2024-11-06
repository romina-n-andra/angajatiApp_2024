package AngajatiApp.validator;

import AngajatiApp.model.DidacticFunction;
import AngajatiApp.model.Employee;


public class EmployeeValidator {

	public EmployeeValidator(){
		//empty for code consistency
	}

	public boolean isValid(Employee employee) {
		if (!isFirstNameValid(employee)) {
			System.out.println("Invalid first name");
			return false;
		}
		if (!isLastNameValid(employee)) {
			System.out.println("Invalid last name");
			return false;
		}
		if (!isCnpValid(employee)){
			System.out.println("Invalid CNP");
			return false;
		}
		if (!isFunctionValid(employee)){
			System.out.println("Invalid function");
			return false;
		}
		if (!isSalaryValid(employee)){
			System.out.println("Invalid salary");
			return false;
		}
		return true;
	}

	private boolean isSalaryValid(Employee employee) {
		return employee.getSalary() > 0;
	}

	private boolean isFunctionValid(Employee employee) {
		return employee.getFunction().equals(DidacticFunction.ASSISTENT)
				|| employee.getFunction().equals(DidacticFunction.LECTURER) 
				|| employee.getFunction().equals(DidacticFunction.TEACHER) 
				|| employee.getFunction().equals(DidacticFunction.CONFERENTIAR);
	}

	private boolean isCnpValid(Employee employee) {
		return employee.getCnp().matches("\\d{13}") && (employee.getCnp().length() == 13);
	}

	private boolean isLastNameValid(Employee employee) {
		return employee.getLastName().matches("[a-zA-Z]+") && (employee.getLastName().length() > 2);
	}

	private boolean isFirstNameValid(Employee employee) {
		return employee.getFirstName().matches("[a-zA-Z]+") && (employee.getFirstName().length() > 2);
	}
	
}


