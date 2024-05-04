package facade.scenario1;

public class EmployeeClient {

	public static void main(String[] args) {
		getEmployeeDetails();
	}

	public static void getEmployeeDetails() {

		EmployeeFacade employeeFacade = new EmployeeFacade();
		Employee employeeDetails = employeeFacade.employeeDAO.getEmployeeDetails(121222);

		System.out.println(employeeDetails.empID);

	}
}