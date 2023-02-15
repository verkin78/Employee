package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NonNull
public class City {
    private  int id;
    private final String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }
}
