package services;

import models.City;
import models.Employee;
import java.util.List;

public interface CityDAO {
    void createCity(City city);

    City getCityById(long id);

    List<City> getAllCity();
}
