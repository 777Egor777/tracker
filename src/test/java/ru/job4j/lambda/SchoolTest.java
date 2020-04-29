package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SchoolTest {

    @Test
    public void collectWhen70To100() {
        School school = new School();
        List<Student> students = List.of(
                new Student(77),
                new Student(10),
                new Student(100),
                new Student(50),
                new Student(2),
                new Student(33),
                new Student(55),
                new Student(66),
                new Student(52)
        );
        List<Student> expected = List.of(
                new Student(77),
                new Student(100)
        );
        Predicate<Student> predicate = (student) -> student.getScore() >= 70
                                                 && student.getScore() <= 100;
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhen50To70() {
        School school = new School();
        List<Student> students = List.of(
                new Student(77),
                new Student(10),
                new Student(100),
                new Student(50),
                new Student(2),
                new Student(33),
                new Student(55),
                new Student(66),
                new Student(52)
        );
        List<Student> expected = List.of(
                new Student(50),
                new Student(55),
                new Student(66),
                new Student(52)
        );
        Predicate<Student> predicate = (student) -> student.getScore() >= 50
                                                 && student.getScore() < 70;
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhen0To50() {
        School school = new School();
        List<Student> students = List.of(
                new Student(77),
                new Student(10),
                new Student(100),
                new Student(50),
                new Student(2),
                new Student(33),
                new Student(55),
                new Student(66),
                new Student(52)
        );
        List<Student> expected = List.of(
                new Student(10),
                new Student(2),
                new Student(33)
        );
        Predicate<Student> predicate = (student) -> student.getScore() > 0
                                                 && student.getScore() < 50;
        List<Student> result = school.collect(students, predicate);
        assertThat(result, is(expected));
    }
}