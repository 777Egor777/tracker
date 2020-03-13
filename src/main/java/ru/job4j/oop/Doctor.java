package ru.job4j.oop;

public class Doctor extends Profession {
    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }
}
