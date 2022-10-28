package models;

import java.util.List;

public class Person {
    private String name;
    private String birth_year;
    private String eye_color;
    private String gender;
    private String hair_color;
    private String height;
    private String mass;
    private String skin_color;
    private String homeworld;
    private List<Object> films;
    private List<Object> species;
    private List<Object> starships;
    private List<Object> vehicles;
    private String url;
    private String created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
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

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<Object> getFilms() {
        return films;
    }

    public void setFilms(List<Object> films) {
        this.films = films;
    }

    public List<Object> getSpecies() {
        return species;
    }

    public void setSpecies(List<Object> species) {
        this.species = species;
    }

    public List<Object> getStarships() {
        return starships;
    }

    public void setStarships(List<Object> starships) {
        this.starships = starships;
    }

    public List<Object> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Object> vehicles) {
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
                ", birth_year='" + birth_year + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", gender='" + gender + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", skin_color='" + skin_color + '\'' +
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
