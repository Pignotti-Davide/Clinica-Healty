package clinica.facade;

import java.util.List;

import clinica.model.Employee;

public interface EmployeeFacade {

	public void insertEmployee(Employee employeee);

	public List<Employee> listEmployee();

	public void deleteEmployee(Integer employeeId);

}
