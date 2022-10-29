package models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

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
    private String skinColor;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> starships;
    private List<String> vehicles;
    private String url;
    private String created;

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

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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
                ", skinColor='" + skinColor + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", films=" + films +
                ", species=" + species +
                ", starships=" + starships +
                ", vehicles=" + vehicles +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
