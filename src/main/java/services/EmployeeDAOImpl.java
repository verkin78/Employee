package services;

import configuration.HibernateSessionFactoryUtil;
import models.City;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    CityDAO cityDao = new CityDAOImpl();
    public EmployeeDAOImpl() {
    }

    @Override
    public void createEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
        if (employee.getCity() != null) {
            cityDao.createCity(new City(employee.getCity().getCityName()));
        }

    }

    @Override
    public Employee getEmployeeById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = (List<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("From Employee").list();
        return employees;
    }

    @Override
    public void setEmployeeCityByid(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(long id) {
        Employee employee = new Employee(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
