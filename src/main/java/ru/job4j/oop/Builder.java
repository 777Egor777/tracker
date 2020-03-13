package ru.job4j.oop;

public class Builder extends Engineer {
    public void buildHouse(Layout layout) {
    }

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }
}
