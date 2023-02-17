package models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private  long id;
    @Column(name = "city_name")
    private  String cityName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<Employee> employees;

    public City(long id) {
        this.id = id;
    }

    public City(String cityName) {
        if (Objects.isNull(cityName)) {
            this.cityName = "No City";
        } else {
            this.cityName = cityName;
        }
    }

    @Override
    public String toString() {
        return cityName;
    }
}
