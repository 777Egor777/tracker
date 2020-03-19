package ru.job4j.tracker;

/**
 * Class realise Input
 * interface. All methods are
 * use console input
 * from user's keyboard;
 * All methods implement's
 * with validation
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Method organize input
     * of the integer number
     * from user from
     * diapason [0;max)
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
        boolean invalid = true;
        do {
            try {
                result = super.askInt(question);
                if (result <= max && result >= 0) {
                    invalid = false;
                } else {
                    System.out.println(String.format("Please enter number from %d to %d", 0, max));
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter correct integer number!");
            } catch (Exception ex) {
                System.out.println("Please enter correct number!");
            }
        } while(invalid);
        return result;
    }
}
