package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

/**
 * Menu Item of the
 * User Interface.
 * It helps to add
 * a edit user in
 * tracker.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public class EditItemAction implements UserAction {
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
        return "=== Edit item ===";
    }

    /**
     * Interact mecthod.
     * Used for edit
     * item in the Tracker
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
        Integer itemId = input.askInt("Enter id: ");
        String itemName = input.askStr("Enter item name: ");
        Item item = new Item(itemName);
        if (tracker.replace(itemId, item)) {
            System.out.println("Operation successful!");
        } else {
            System.out.println("No such id :(");
        }
        return true;
    }
}
