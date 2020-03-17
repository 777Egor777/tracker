package ru.job4j.tracker;

public class FindItemByName implements UserAction {
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
        return "=== Find item's by name ===";
    }

    /**
     * Interact mecthod.
     * Used for searching
     * Item's with name
     * that user enters.
     * @param input - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item's by name ===");
        String itemName = StartUI.getInputString("Enter name: ", input);
        Item[] items = tracker.findByName(itemName);
        StartUI.printItems(items);
        return true;
    }
}
