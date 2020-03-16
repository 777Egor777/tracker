package ru.job4j.tracker;

/**
 * Realisation of the
 * Input intercface.
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class StubInput implements Input {
    /**
     * Method send question
     * to standard output
     * an input String from
     * user
     *
     * @param question - we output this
     *                 question. It need
     *                 for user to understand
     *                 what he should type
     * @return String, that
     * user type
     */
    @Override
    public String askStr(String question) {
        return null;
    }

    /**
     * Method send question
     * to standard output
     * an input integer
     * number from user
     *
     * @param question - we output this
     *                 question. It need
     *                 for user to understand
     *                 what he should type
     * @return Integer number, that
     * user type
     */
    @Override
    public String askInt(String question) {
        return null;
    }
}
