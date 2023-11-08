package ro.fasttrackit;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        // Testing purposes
        List<Person> personList = new ArrayList<>();
        try (Scanner scanner = new Scanner(Path.of("src/main/resources/Peeps.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(", ");
                personList.add(new Person(tokens[0], tokens[1], parseInt(tokens[2]), tokens[3]));
            }
        } catch (IOException e) {
            System.out.println("Shit's broken:" + e);
        }

        PersonService peeps = new PersonService(personList);

        // Methods
//        System.out.println(peeps.allNames());
//        System.out.println(peeps.overAge());
//        System.out.println(peeps.fromOradea());
//        System.out.println(peeps.fromOradeaOrCluj());
//        System.out.println(peeps.firstNamesCapitalized());
//        System.out.println(peeps.firstNameAndALetter());
//        System.out.println(peeps.ofWorkingAge());
//        System.out.println(peeps.firstNameStartsWithA());
//        System.out.println(peeps.allFirstNames());
//        System.out.println(peeps.sortedByFirstName());
//        System.out.println(peeps.sortedByLastName());
        System.out.println(peeps.sortedByFnLnAge());

    }
}