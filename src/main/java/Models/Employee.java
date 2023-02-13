package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Employee {

    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private int id;
    private int cityId;
    private City city;

    public Employee(String firstName, String lastName, String gender, int age, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee(String firstName, String lastName, String gender, int age, int cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "First_Name: " + firstName + '\n' +
                "Last_Name: " + lastName + '\n' +
                "Gender: " + gender + '\n' +
                "Age: " + age +'\n' +
                "City: " + city.getCityName();
    }
}
