import models.City;
import models.Employee;
import services.CityDAO;
import services.CityDAOImpl;
import services.EmployeeDAO;
import services.EmployeeDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee("Vladimir",
                "Dmitriev",
                "man",
                4,
                26,
                new City(1));
        //employeeDAO.createEmployee(employee);
        // System.out.println(employeeDAO.getEmployeeById(1));
        // employeeDAO.setEmployeeCityByid(employee);
        //   employeeDAO.deleteEmployeeById(35);
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        employeeList.forEach(System.out::println);
        //testHibernateTheTableCity();
    }

    public static void testHibernateTheTableCity() {
        CityDAO cityDao = new CityDAOImpl();
        // cityDao.createCity(new City("Norilsk"));
        List<City> cityList = cityDao.getAllCity();
        cityList.forEach(System.out::println);
    }
}
