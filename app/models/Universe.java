package models;

import java.util.List;

public class Universe {

    private Planet planet;
    // TODO: add Person type and use it instead of Object here
    private List<Object> people;

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "Universe{" +
                "planet=" + planet +
                ", people=" + people +
                '}';
    }
}
