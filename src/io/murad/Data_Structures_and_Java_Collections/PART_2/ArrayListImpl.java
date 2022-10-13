package io.murad.Data_Structures_and_Java_Collections.PART_2;

import java.util.ArrayList;
import java.util.List;

/**
 * List (ArrayList)
 */
public class ArrayListImpl {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Tanveer","Noman",37));
        persons.add(new Person("Shamim","Shahnewaz",35));
        persons.add(new Person("Sekh","Mahdi",32));

        persons.forEach(person -> {
            System.out.println(person.getFirstName() + " " + person.getLastName() + " is " + person.getAge() + " years old.");
        });

    }
}
