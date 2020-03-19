package ru.job4j.tracker;

/**
 * Realisation of the
 * Input interface.
 * This class need for
 * testing.
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class StubInput implements Input {
    /**
     * We consider this strings
     * as "input" from user
     */
    private String[] answers;

    /**
     * Current position in
     * "answers" array.
     */
    private int position = 0;

    /**
     * Constructor accept
     * Strings that we
     * perceive as "input"
     * Strings
     * @param answers - array
     *                  of user input data.
     *                  Need for testing
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Method return java.lang.String
     * object, that we can consider
     * as "input" String
     * @param question - Addition information.
     *                   We don't need it
     *                   in this realisation.
     * @return "input" String
     */
    @Override
    public String askStr(String question) {
        return this.answers[this.position++];
    }

    /**
     * Same as in previous method,
     * but we convert it to integer
     * number.
     * @param question - Addition information.
     *                   We don't need it
     *                   in this realisation.
     * @return "input" integer number
     */
    @Override
    public int askInt(String question) {
        return Integer.parseInt(this.askStr(question));
    }

    /**
     * Method organize input
     * of the integer number
     * from user from
     * diapason [0;max]
     *
     * @param question - message that shows
     *                 to user before he
     *                 starts to type
     * @param max      - upper bound of
     *                 the diapason
     * @return integer number
     * that user enter
     */
    @Override
    public int askInt(String question, int max) {
        int result = -1;
        while (!(result >= 0 && result <= max)) {
            result = askInt(question);
        }
        return result;
    }
}
