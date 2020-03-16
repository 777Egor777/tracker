package ru.job4j.tracker;

/**
 * Interface necessary for
 * organising input in the program
 * and testing in the program
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public interface Input {
    /**
     * Method send question
     * to standard output
     * an input String from
     * user
     * @param question - we output this
     *                   question. It need
     *                   for user to understand
     *                   what he should type
     * @return String, that
     *         user type
     */
    String askStr(String question);

    /**
     * Method send question
     * to standard output
     * an input integer
     * number from user
     * @param question - we output this
     *                   question. It need
     *                   for user to understand
     *                   what he should type
     * @return Integer number, that
     *         user type
     */
    String askInt(String question);
}
