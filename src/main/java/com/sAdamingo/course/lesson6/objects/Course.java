package com.sAdamingo.course.lesson6.objects;

import com.sAdamingo.course.lesson6.objects.people.Person;

import java.util.ArrayList;
import java.util.List;

public class Course {

    public static void main(String[] args) {
        List<Person> attendants = new ArrayList<>();

        Person attendant1 = new Person();
        Person anotherPerson = new Person(24, "Wojtek");
        Person yetAnotherPerson = new Person(40, "Marek");
        Person attendant2 = new Person();

        attendants.add(attendant1);
        attendants.add(anotherPerson);
        attendants.add(yetAnotherPerson);
        attendants.add(attendant2);

        for (Person attendant : attendants) {
            System.out.println(attendant.getName() + " is " + attendant.getAge() + " years old");
        }

        System.out.println("attendant 2 " + attendant2.getAge(10));

        Person attendant3 = attendant1;

        System.out.println(attendant1 == attendant2);
        System.out.println(attendant1.equals(attendant2));
        System.out.println(attendant1 == attendant3);  // Czy obiekt po lewej znajduje sie
        // w tym samym miejscu w pamieci co obiekt po prawej?
        System.out.println(attendant1.equals(attendant3));
        // Czy metoda equals zwraca prawde?

        Person bezimienny = new Person();
        System.out.println(attendants.contains(bezimienny));
    }
}
