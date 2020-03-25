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
            User user = (User)obj;
            result = Objects.equals(name, user.getName()) &&
                     age == user.getAge();
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age='%d'}", name, age);
    }

    @Override
    public int compareTo(User o) {
        int result = 1;
        if (Objects.equals(this, o)) {
            result = 0;
        } else if (name.compareTo(o.getName()) < 0 ||
                (name.compareTo(o.getName()) == 0 && age < o.getAge() )) {
            result = -1;
        }
        return result;
    }
}
