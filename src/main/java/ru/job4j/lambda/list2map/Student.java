package ru.job4j.lambda.list2map;

import java.util.Objects;

public class Student {
    private int score;
    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            Student student = (Student) obj;
            result = score == student.getScore()
                    && surname.equals(student.getSurname());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}
