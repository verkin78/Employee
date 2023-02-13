package Services;

import Models.Employee;
import java.util.List;

public interface EmployeeDAO {
    void createEmployee(Employee employee);

    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();

    void setEmployeeCityByid(int id, int cityId);

    void deleteEmployeeById(int id);
}
