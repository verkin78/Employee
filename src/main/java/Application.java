import models.Employee;
import services.EmployeeDAO;
import services.EmployeeDAOImpl;
import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "DthjybrfZ";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        Connection connection = DriverManager.getConnection(url, user, password);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

        Employee employee = new Employee("Sergey",
                "Solovyev",
                "man",
                26,2);
       // employeeDAO.getAllEmployees();
       // testDataBase(connection);
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        employeeList.forEach(System.out::println);
    }

    public static void testDataBase(Connection connection) {
            try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT first_name," +
                            "last_name," +
                            "gender," +
                            "age," +
                            "city_name" +
                            " FROM employee " +
                            "INNER JOIN city ON employee.city_id = city.city_id WHERE id =(?)");
            preparedStatement.setInt(1,4);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = "firstname: "+resultSet.getString("first_name");
                String lastName = "lastname: "+resultSet.getString("last_name");
                String gender = "gender: "+resultSet.getString("gender");
                int age = resultSet.getInt("age");
                String cityName = "City: " + resultSet.getString("city_name");
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println("Age: "+age);
                System.out.println(cityName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
