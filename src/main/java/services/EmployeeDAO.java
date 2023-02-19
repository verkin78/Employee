package services;

import models.Employee;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(Employee employee);

    Employee getEmployeeById(long id);

    List<Employee> getAllEmployees();

    void setEmployeeCityByid(Employee employee);

    void deleteEmployeeById(long id);
}
