package models;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Planet {

    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    @JsonAlias("orbital_period")
    private String orbitalPeriod;
    private String population;
    private List<String> residents;
    @JsonAlias("rotation_period")
    private String rotationPeriod;
    @JsonAlias("surface_water")
    private String surfaceWater;
    private String terrain;
    private String url;

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "climate='" + climate + '\'' +
                ", diameter='" + diameter + '\'' +
                ", gravity='" + gravity + '\'' +
                ", name='" + name + '\'' +
                ", orbitalPeriod='" + orbitalPeriod + '\'' +
                ", population='" + population + '\'' +
                ", residents=" + residents +
                ", rotationPeriod='" + rotationPeriod + '\'' +
                ", surfaceWater='" + surfaceWater + '\'' +
                ", terrain='" + terrain + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
