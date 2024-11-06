package AngajatiApp.model;

import AngajatiApp.validator.EmployeeException;

import java.util.Objects;

public class Employee {
	private static final int LAST_NAME_INDEX = 1;
	private static final int FIRST_NAME_INDEX = 0;
	private static final int CNP_INDEX = 2;
	private static final int DIDACTIC_FUNCTION_INDEX = 3;
	private static final int SALARY_INDEX = 4;
	private static final int ID = 5;
	private int idEmployee;
	private String nume;/** The last name of the employee */
	private String firstName; /** The first name of the employee */
	private String cnp; /** The unique id of the employee */
	private DidacticFunction function; /** The didactic function of the employee inside the university */
	private Double salary; /** The salary of the employee */
	
	/**
	 * Default constructor for employee
	 */
	public Employee() {
		this.idEmployee = idEmployee;
		this.firstName = "";
		this.nume  = "";
		this.cnp       = "";
		this.function  = DidacticFunction.ASSISTENT;
		this.salary    = 0.0d;
	}
	
	/**
	 * Constructor with fields for employee
	 */
	public Employee(int id, String firstName, String lastName, String cnp, DidacticFunction function, Double salary) {
		this.idEmployee=idEmployee;
		this.firstName = firstName;
		this.nume  = lastName;
		this.cnp       = cnp;
		this.function  = function;
		this.salary    = salary;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return nume;
	}

	public void setLastName(String lastName) {
		this.nume = lastName;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public DidacticFunction getFunction() {
		return function;
	}

	public void setFunction(DidacticFunction function) {
		this.function = function;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		String employee = "";
		employee += firstName + ";";
		employee += nume + ";";
		employee += cnp + ";";
		employee += function.toString() + ";";
		employee += salary + ";";
		employee += idEmployee;
		return employee;
	}
	
	@Override
	public boolean equals(Object otherEmployee) {
		if (otherEmployee == this) {
            return true;
        }
		if (!(otherEmployee instanceof Employee)) {
            return false;
        }
		final Employee employee = (Employee) otherEmployee;
		boolean hasSameFirstName = this.firstName.equals(employee.getFirstName()),
				hasSameLastName  = this.nume.equals(employee.getLastName()),
				hasSameCNP       = this.cnp.equals(employee.getCnp()),
				hasSameFunction  = this.function.equals(employee.getFunction()),
				hasSameSalary    = this.salary.equals(employee.getSalary());
		return hasSameFirstName && hasSameLastName && hasSameCNP && hasSameFunction && hasSameSalary;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, nume, cnp, function, salary);
	}
	
	/**
	 * Returns the Employee after parsing the given line
	 * 
	 * @param employeeString
	 *            the employee given as String from the input file
	 * @param line
	 *            the current line in the file
	 * 
	 * @return if the given line is valid returns the corresponding Employee
	 * @throws EmployeeException
	 */
	public static Employee getEmployeeFromString(String employeeString, int line) throws EmployeeException {
		Employee employee = new Employee();

		String[] attributes = employeeString.split("[;]");

		switch (attributes[DIDACTIC_FUNCTION_INDEX]) {
			case "ASSISTENT":
				employee.setFunction(DidacticFunction.ASSISTENT);
				break;
			case "LECTURER":
				employee.setFunction(DidacticFunction.LECTURER);
				break;
			case "TEACHER":
				employee.setFunction(DidacticFunction.TEACHER);
				break;
			case "CONFERENTIAR":
				employee.setFunction(DidacticFunction.CONFERENTIAR);
				break;
			default:
				throw new EmployeeException("Unknown didactic function at line: " + line);
		}

		return employee;
	}
	
}

