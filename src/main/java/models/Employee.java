package models;

import lombok.*;
import services.CityDAO;
import services.CityDAOImpl;
import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    private static CityDAO cityDao = new CityDAOImpl();

    public Employee(String firstName,
                    String lastName,
                    String gender,
                    int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String firstName,
                    String lastName,
                    String gender,
                    int age,
                    City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        cityDao.createCity(city);
        this.city = new City(city.getId());
    }

    public Employee(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id " + id + "." +
                " First_Name - " + firstName + "." +
                " Last_Name - " + lastName + "." +
                " Gender - " + gender + "." +
                " Age - " + age +
                " City - " + city;
    }
}
