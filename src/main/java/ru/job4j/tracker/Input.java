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
     * Method organize input
     * of the String from user
     * @param question - message that shows
     *                   to user before he
     *                   starts to type
     * @return String that user
     *         enter
     */
    String askStr(String question);

    /**
     * Method organize input
     * of the integer number
     * from user
     * @param question - message that shows
     *                   to user before he
     *                   starts to type
     * @return integer number
     *         that user enter
     */
    int askInt(String question);

    /**
     * Method organize input
     * of the integer number
     * from user from
     * diapason [0;max]
     * @param question - message that shows
     *                   to user before he
     *                   starts to type
     * @param max - upper bound of
     *              the diapason
     * @return integer number
     *         that user enter
     */
    int askInt(String question, int max);
}
