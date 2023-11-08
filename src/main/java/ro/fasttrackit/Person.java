package ro.fasttrackit;

public record Person(
        String firstName,
        String lastName,
        int age,
        String city
) {
    public String toString() { // De estetica
        return "\n" + firstName + " " +lastName + ", " + age + " years old, from " + city;
    }
}
