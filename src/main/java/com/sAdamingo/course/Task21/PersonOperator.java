package com.sAdamingo.course.Task21;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonOperator {
    private final List<String> names = List
            .of("Marcin", "Adam", "Agata", "Anna", "Mateusz", "Wojtek", "Kasia", "Tomek", "Kamil",
                    "Maria", "Arkadiusz", "Przemysław", "Horacy", "Zofia", "Genowefa", "Serafin");


    public void printAdultsFromListOfPersons() {
        List<Person> listOfPersons = names.stream()
                .map(s -> new Person(s, new Random().nextInt(8) + 15))
                .collect(Collectors.toList());
        Set<Person> adults = listOfPersons.stream()
                .filter(s -> s.getAge() >= 18)
                .collect(Collectors.toSet());
        adults.forEach(s -> System.out.println(s.getName() + " is " + s.getAge() + " years old."));
    }

    public static void main(String[] args) {
        new PersonOperator().printAdultsFromListOfPersons();
    }
}
