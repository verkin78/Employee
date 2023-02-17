package services;

import configuration.HibernateSessionFactoryUtil;
import models.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    @Override
    public List<City> getAllCity() {
        List<City> cities = (List<City>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("From City ").list();
        return cities;
    }
}
