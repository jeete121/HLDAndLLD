package facade.scenario1;

public class EmployeeFacade {

	EmployeeDAO employeeDAO;

	public EmployeeFacade() {
		employeeDAO = new EmployeeDAO();
	}

	public void insert() {
		employeeDAO.insert();
	}
}