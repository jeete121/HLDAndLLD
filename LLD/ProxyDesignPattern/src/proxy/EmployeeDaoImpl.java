package proxy;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void create(String client, EmployeeDo obj) throws Exception {

		System.out.println("Create new wor in employee table");

	}

	@Override
	public void delete(String client, int employeeId) throws Exception {
		System.out.println("Delete a row from employee table with employeeId " + employeeId);

	}

	@Override
	public EmployeeDo get(String client, int employeeId) throws Exception {

		System.out.println("Fecthing data from the table");
		return new EmployeeDo();
	}

}
