package models;

import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Universe {
    @Builder.Default
    private Planet planet = null;
    @Builder.Default
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
    }
}
