package ru.job4j.tracker;

public class ExitItem implements UserAction {
    /**
     * Description of the
     * user action
     *
     * @return String that
     * describe user
     * action
     */
    @Override
    public String name() {
        return "=== Exit program ===";
    }

    /**
     * Method include
     * operation that we
     * should do according
     * to this user action
     *
     * @param input   - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                that we interact with
     * @return true - if operation correctly
     * finished
     * false - otherwise
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(this.name());
        return false;
    }
}
