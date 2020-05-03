package ru.job4j.lambda.streamadv;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SchoolTest {

    @Test
    public void levelOfWhenEmptyList() {
        List<Student> students = List.of();
        List<Student> result = School.levelOf(students, 0);
        List<Student> expected = List.of();
        assertThat(result, is(expected));
    }

    @Test
    public void levelOfWhenNotEmptyList() {
        List<Student> students = List.of(
                new Student("Vasya", 2),
                new Student("Bogdan", 20),
                new Student("Alex", 55),
                new Student("Egor", 100),
                new Student("Victor", 47),
                new Student("Kostya", 11),
                new Student("Pavel", 33),
                new Student("Ivan", 67)
        );
        List<Student> result = School.levelOf(students, 50);
        List<Student> expected = List.of(
                new Student("Egor", 100),
                new Student("Ivan", 67),
                new Student("Alex", 55)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void levelOfWhenNotEmptyListWithNulls() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                null,
                new Student("Vasya", 2),
                new Student("Bogdan", 20),
                null,
                new Student("Alex", 55),
                new Student("Egor", 100),
                null,
                null,
                new Student("Victor", 47),
                new Student("Kostya", 11),
                new Student("Pavel", 33),
                null,
                new Student("Ivan", 67),
                null,
                null,
                null
        ));
        List<Student> result = School.levelOf(students, 50);
        List<Student> expected = List.of(
                new Student("Egor", 100),
                new Student("Ivan", 67),
                new Student("Alex", 55)
        );
        assertThat(result, is(expected));
    }
}