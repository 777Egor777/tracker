package ru.job4j.collection;

import java.util.Objects;

public class Account {
    private String passport;
    private String username;
    private String deposit;

    public Account(String passport, String username, String deposit) {
        this.passport = passport;
        this.username = username;
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            Account account = (Account)obj;
            result = passport.equals(account.passport);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return String.format("Account{passport='%s', username='%s', deposit='%s'}",
                             passport, username, deposit);
    }
}
