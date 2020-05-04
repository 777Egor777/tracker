package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    private boolean contains(Person person, String key) {
        return person.getName().contains(key)
                || person.getSurname().contains(key)
                || person.getAddress().contains(key)
                || person.getPhone().contains(key);

    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> prName = (person) -> person.getName().contains(key);
        Predicate<Person> prSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> prPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> prAddress = (person) -> person.getAddress().contains(key);
        Predicate<Person> combine = person -> prName.test(person)
                                           || prSurname.test(person)
                                           || prPhone.test(person)
                                           || prAddress.test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
