package ru.job4j.bank;

import java.util.Objects;

public class User {
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            User user = (User) obj;
            result = Objects.equals(passport, user.getPassport());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("User{passport='%s', username='%s'}",
                passport, username);
    }
}
