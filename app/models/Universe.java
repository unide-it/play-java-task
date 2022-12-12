package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Universe {
    Planet planet;
    List<Person> people;
}
