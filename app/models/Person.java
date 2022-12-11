package models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collection;

public class Person {
    private String name;
    @JsonAlias("birth_year")
    private String birthYear;
    @JsonAlias("eye_color")
    private String eyeColor;
    private String gender;
    @JsonAlias("hair_color")
    private String hairColor;
    private String height;
    private String mass;
    @JsonAlias("skin_color")
    private String skinColour;
    private URL homeworld;
    private Collection<URL> films;
    private Collection<URL> species;
    private Collection<URL> starships;
    private Collection<URL> vehicles;
    private URL url;
    private LocalDateTime created;
    private LocalDateTime edited;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkinColour() {
        return skinColour;
    }

    public void setSkinColour(String skinColour) {
        this.skinColour = skinColour;
    }

    public URL getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(URL homeworld) {
        this.homeworld = homeworld;
    }

    public Collection<URL> getFilms() {
        return films;
    }

    public void setFilms(Collection<URL> films) {
        this.films = films;
    }

    public Collection<URL> getSpecies() {
        return species;
    }

    public void setSpecies(Collection<URL> species) {
        this.species = species;
    }

    public Collection<URL> getStarships() {
        return starships;
    }

    public void setStarships(Collection<URL> starships) {
        this.starships = starships;
    }

    public Collection<URL> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<URL> vehicles) {
        this.vehicles = vehicles;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", gender='" + gender + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", skinColour='" + skinColour + '\'' +
                ", homeworld=" + homeworld +
                ", films=" + films +
                ", species=" + species +
                ", starships=" + starships +
                ", vehicles=" + vehicles +
                ", url=" + url +
                ", created=" + created +
                ", edited=" + edited +
                '}';
    }
}
