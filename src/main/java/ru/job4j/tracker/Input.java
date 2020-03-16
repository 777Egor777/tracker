package ru.job4j.tracker;

/**
 * Interface necessary for
 * organising input in the program
 * and testing in the program
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
