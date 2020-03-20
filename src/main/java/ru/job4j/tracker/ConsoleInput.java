package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class realise Input
 * interface. All methods are
 * use console input
 * from user's keyboard;
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class ConsoleInput extends CommonInput {
    /**
     * java.util.Scanner object
     * We need this field
     * to get input from
     * user's keyboard
     */
    private Scanner scanner = new Scanner(System.in);

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
        System.out.print(question);
        return nextLine();
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
    public int askInt(String question) {
        return Integer.parseInt(this.askStr(question));
    }

    /**
     * Method organize input
     * of the integer number
     * from user from
     * diapason [0;max]
     * If number not in this diapason,
     * it trows Exception
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
            throw  new IllegalStateException(String.format("Number out of bounds [%d, %d)", 0, max));
        }
        return result;
    }

    /**
     * Base method that
     * return newLine
     * from console
     * @return new line from
     *         console
     */
    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
