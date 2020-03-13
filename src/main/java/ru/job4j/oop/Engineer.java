package ru.job4j.oop;

public class Engineer extends Profession {
    public Layout createLayout() {
        return new Layout();
    }

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }
}
