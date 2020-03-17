package ru.job4j.tracker;

public class AddItem implements UserAction {
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
        return "=== Add new Item ===";
    }

    /**
     * Interact mecthod.
     * Used for add new
     * item to Tracker
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
        System.out.println(this.name());
        String itemName = StartUI.getInputString("Enter item name: ", input);
        Item item = new Item(itemName);
        tracker.add(item);
        return true;
    }
}
