package ru.job4j.lambda;

import java.util.Objects;

public class Student {
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            Student student = (Student) obj;
            result = score == student.getScore();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
