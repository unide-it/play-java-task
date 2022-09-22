package models;

import java.util.List;

public class Universe {

    private Planet planet;
    // TODO: add Person type and use it instead of Object here
    private List<Person> people;

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Universe{" +
                "planet=" + planet +
                ", people=" + people +
                '}';
    }
}
