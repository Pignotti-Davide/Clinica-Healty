package clinica.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clinica.dao.EmployeeDao;
import clinica.model.Employee;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> listEmployee() {
		return this.employeeDao.listEmployee();
	}

	public void insertEmployee(Employee employee) {
		this.employeeDao.insertEmployee(employee);
	}

	public void deleteEmployee(Integer employeeId) {
		this.employeeDao.deleteEmployee(employeeId);
	}

}