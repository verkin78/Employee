package services;

import configuration.HibernateSessionFactoryUtil;
import models.City;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void createCity(City city) {
        if (!city.getCityName().equals("No City")) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(city);
                transaction.commit();
            }
        }
    }

    @Override
    public City getCityById(long id) {
        City city = new City();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            city = session.get(City.class, id);
            transaction.commit();
        }
        return city;
    }

    @Override
    public List<City> getAllCity() {
        List<City> cities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            cities = session.createQuery("from City").list();
            transaction.commit();
        }
        return cities;
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCityById(long id) {
        City city = new City(id);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
