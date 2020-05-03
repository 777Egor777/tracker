package ru.job4j.lambda.streamadv;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(scope, o.scope);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && getClass() == obj.getClass()) {
            Student student = (Student) obj;
            result = name.equals(student.name)
                    && scope == student.scope;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }
}

