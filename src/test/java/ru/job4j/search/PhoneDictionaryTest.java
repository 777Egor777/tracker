package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary dictionary = new PhoneDictionary();
        Person egor = new Person("Egor", "Geraskin", "111111", "Saratov");
        dictionary.add(egor);
        ArrayList<Person> foundPersons = dictionary.find("gor");
        String result = foundPersons.get(0).getSurname();
        String expected = "Geraskin";
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindByCity() {
        PhoneDictionary dictionary = new PhoneDictionary();
        Person egor = new Person("Egor", "Geraskin", "111111", "Saratov");
        dictionary.add(egor);
        ArrayList<Person> foundPersons = dictionary.find("rat");
        String result = foundPersons.get(0).getSurname();
        String expected = "Geraskin";
        assertThat(result, is(expected));
    }
}