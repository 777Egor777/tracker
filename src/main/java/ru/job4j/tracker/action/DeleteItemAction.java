package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

/**
 * Menu Item of the
 * User Interface.
 * It helps to delete
 * a user from tracker.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class DeleteItemAction implements UserAction {
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
        return "=== Delete item ===";
    }

    /**
     * Interact mecthod.
     * Used for deleting
     * item from the Tracker
     * @param input - object of class that
     *                realise Input interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        System.out.println(this.name());
        Integer itemId = input.askInt("Enter id: ");
        if (tracker.delete(itemId)) {
            System.out.println("Operation successful!");
        } else {
            System.out.println("No such id :(");
        }
        return true;
    }
}
