package ro.fasttrackit;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(peeps.allNames());

    }
}