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
public class ConsoleInput implements Input{
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
        return scanner.nextLine();
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
        System.out.print(question);
        return Integer.parseInt(scanner.nextLine());
    }
}
