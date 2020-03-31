package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            User user = (User) obj;
            result = Objects.equals(name, user.getName())
                    && age == user.getAge();
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age='%d'}", name, age);
    }

    @Override
    public int compareTo(User o) {
        int result = name.compareTo(o.getName());
        if (result == 0) {
            result = Integer.compare(age, o.getAge());
        }
        return result;
    }
}
