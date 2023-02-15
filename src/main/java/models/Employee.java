package models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "city_id")
    private long city;

    public Employee(String firstName, String lastName, String gender, int age, long city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "id "+id +"."+
                " First_Name - " + firstName + "."+
                " Last_Name - " + lastName +"."+
                " Gender - " + gender +"."+
                " Age - " + age +"."+
                " CityId - " + city+".";
    }
}