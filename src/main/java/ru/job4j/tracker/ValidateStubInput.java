package ru.job4j.tracker;

public class ValidateStubInput extends ValidateInput {
    private String[] data;
    private int position = 0;

    public ValidateStubInput(String[] data) {
        this.data = data;
    }

    /**
     * Base method that
     * return newLine
     * from data array
     * @return new line from
     *         data array
     */
    @Override
    public String nextLine() {
        return data[position++];
    }

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
        return super.askInt("", max);
    }
}
