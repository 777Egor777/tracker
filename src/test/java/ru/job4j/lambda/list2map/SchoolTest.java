package ru.job4j.lambda.list2map;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SchoolTest {

    @Test
    public void collectWhenEmptyList() {
        List<Student> students = List.of();
        Map<String, Student> result = School.collect(students);
        Map<String, Student> expected = new HashMap<>();
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhenNotEmptyList() {
        List<Student> students = List.of(
                new Student(99, "Egor"),
                new Student(100, "Ivan"),
                new Student(70, "Alex")
        );
        Map<String, Student> result = School.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Egor", new Student(99, "Egor"));
        expected.put("Ivan", new Student(100, "Ivan"));
        expected.put("Alex", new Student(70, "Alex"));
        assertThat(result, is(expected));
    }
}