package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

/**
 * Menu Item of the
 * User Interface.
 * It helps to add
 * a new user to
 * tracker.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class AddItemAction implements UserAction {
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
    public boolean execute(Input input, Store tracker) {
        System.out.println(this.name());
        String itemName = input.askStr("Enter item name: ");
        Item item = new Item(itemName);
        tracker.add(item);
        return true;
    }
}
