package ru.job4j.stream;

import java.util.List;

public class Pupil {
    private String name;
    private List<Subject> marks;

    public Pupil(String name, List<Subject> marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getMarks() {
        return marks;
    }
}
