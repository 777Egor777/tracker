package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class PassportOfficeTest {

    @Test
    public void whenContains() {
        Citizen citizen = new Citizen("xxx111222", "Vaska");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen result = office.get(citizen.getPassport());
        Citizen expected = citizen;
        assertThat(result, is(expected));
    }

    @Test
    public void whenNotContains() {
        Citizen citizen = new Citizen("xxx111222", "Vaska");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen result = office.get("xxx");
        Citizen expected = new Citizen("plug", "plug");
        assertThat(result, is(expected));
    }
}