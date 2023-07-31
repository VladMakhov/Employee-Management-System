package system.service.interfaces;

import system.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee() ;

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);

}
