package models;

import lombok.Data;

import java.util.List;

@Data
public class Planet {
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String orbital_period;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String rotation_period;
    private String surface_water;
    private String terrain;
    private String url;
    private String created;
    private String edited;
}
