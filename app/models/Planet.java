package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
public class Planet {
    String climate;
    String diameter;
    String gravity;
    String name;
    String orbital_period;
    String population;
    List<String> residents;
    String rotation_period;
    String surface_water;
    String terrain;
    String url;
}
