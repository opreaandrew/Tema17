package ro.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final List<Person> people;

    public PersonService(List<Person> people) {
        this.people = new ArrayList<>(people);
    }

    public List<String> allNames(){
        return people.stream()
                .map(person -> "\n" + person.firstName() + " " + person.lastName())
                .toList();
    }


}
