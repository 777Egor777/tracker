package ru.job4j.tracker;

public class FindAllAction implements UserAction {
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
        return "Find all.";
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
        for (Item item : tracker.findAll()) {
            System.out.println(String.format("%s %s", item.getId(), item.getName()));
        }
        return true;
    }
}
