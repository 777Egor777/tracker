package ru.job4j.tracker;

public class ShowAllItems implements UserAction {
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
        return "=== Show all items ===";
    }

    /**
     * Interact method. Send all
     * items in tracker to
     * standard output
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(this.name());
        Item[] allItems = tracker.findAll();
        StartUI.printItems(allItems);
        return true;
    }
}
