package ro.fasttrackit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> people;

    public PersonService(List<Person> people) {
        this.people = new ArrayList<>(people);
    }

    public List<String> allNames() {
        return people.stream()
                .map(person -> "\n" + person.firstName() + " " + person.lastName())
                .toList();
    }

    public List<Person> overAge() {
        return people.stream()
                .filter(person -> person.age() > 18)
                .toList();
    }

    public List<Person> fromOradea() {
        return people.stream()
                .filter(person -> person.city().equalsIgnoreCase("Oradea"))
                .toList();
    }

    public List<Person> fromOradeaOrCluj() {
        return people.stream()
                .filter(person -> person.city().equalsIgnoreCase("Oradea") || person.city().equalsIgnoreCase("Cluj-Napoca"))
                .toList();
    }

    public List<String> firstNamesCapitalized() {
        return people.stream()
                .map(person -> "\n" + person.firstName().toUpperCase())
                .toList();
    }

    public List<String> firstNameAndALetter() {
        return people.stream()
                .map(person -> "\n" + person.firstName() + " " + person.lastName().toUpperCase().charAt(0) + ".")
                .toList();
    }

    public List<Person> ofWorkingAge() {
        return people.stream()
                .filter(person -> person.age() > 18 && person.age() < 60)
                .sorted(Comparator.comparingInt(Person::age))
                .toList();
    }

    public List<Person> firstNameStartsWithA() {
        return people.stream()
                .filter(person -> person.firstName().charAt(0) == 'A')
                .sorted(Comparator.comparing(Person::firstName))
                .toList();
    }

    public List<String> allFirstNames() {
        return people.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .map(Person::firstName)
                .distinct()
                .toList();
    }

    public List<Person> sortedByFirstName(){
        return people.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .toList();
    }

    public List<Person> sortedByLastName(){
        return people.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .toList();
    }

    public List<Person> sortedByFnLnAge(){
        return people.stream()
                .sorted(Comparator.comparing(Person::firstName)
                        .thenComparing(Person::lastName)
                        .thenComparingInt(Person::age))
                .toList();
    }


}
