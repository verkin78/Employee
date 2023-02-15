import models.Employee;
import services.EmployeeDAO;
import services.EmployeeDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args)  {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee("Andrey",
                "Davidov",
                "man",
                9,
                5);
        // employeeDAO.createEmployee(employee);
        // System.out.println(employeeDAO.getEmployeeById(1));
        //  employeeDAO.setEmployeeCityByid(employee);
        // employeeDAO.deleteEmployeeById(employee);
       List<Employee> employeeList = employeeDAO.getAllEmployees();
        employeeList.forEach(System.out::println);
    }
}
