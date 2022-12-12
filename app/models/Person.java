package models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
public class Person {
    String name;
    @JsonAlias("birth_year")
    String birthYear;
    @JsonAlias("eye_color")
    String eyeColor;
    String gender;
    @JsonAlias("hair_color")
    String hairColor;
    String height;
    String mass;
    @JsonAlias("skin_color")
    String skinColour;
    URL homeworld;
    Collection<URL> films;
    Collection<URL> species;
    Collection<URL> starships;
    Collection<URL> vehicles;
    URL url;
    LocalDateTime created;
    LocalDateTime edited;
}
