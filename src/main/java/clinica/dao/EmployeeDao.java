package clinica.dao;

import java.util.List;

import clinica.model.Employee;

public interface EmployeeDao {

	public void insertEmployee(Employee employeee);

	public List<Employee> listEmployee();

	public void deleteEmployee(Integer employeeId);

}
