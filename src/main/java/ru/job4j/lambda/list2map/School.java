package ru.job4j.lambda.list2map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class School {
    public static Map<String, Student> collect(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getSurname,
                x -> x
        ));
    }
}
