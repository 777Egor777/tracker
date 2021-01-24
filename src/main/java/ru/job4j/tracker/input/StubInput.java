package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;

import java.util.List;

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
    private final List<String> answers;

    /**
     * Constructor accept
     * Strings that we
     * perceive as "input"
     * Strings
     * @param answers - array
     *                  of user input data.
     *                  Need for testing
     */
    public StubInput(List<String> answers) {
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
        return nextLine();
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
        int result;
        try {
            result = Integer.parseInt(askStr(question));
        } catch (Exception ex) {
            throw new IllegalStateException("This is not an Integer number.");
        }
        return result;
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
        int result = askInt(question);
        if (!(result >= 0 && result < max)) {
            throw new IllegalArgumentException(String.format("Number not from diapason [%d:%d)", 0, max));
        }
        return result;
    }

    /**
     * Base method that
     * return newLine
     * from data array
     * @return next line
     *         from data
     *         array
     */
    @Override
    public String nextLine() {
        return answers.remove(0);
    }
}
