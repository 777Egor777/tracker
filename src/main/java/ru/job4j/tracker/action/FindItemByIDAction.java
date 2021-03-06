package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

/**
 * Menu Item of the
 * User Interface.
 * It helps to find
 * user in tracker
 * by Id.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public class FindItemByIDAction implements UserAction {

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
        return "=== Find item by id  ===";
    }

    /**
     * Interact mecthod.
     * Used for searching
     * Item with id
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
    public boolean execute(Input input, Store tracker) {
        System.out.println(this.name());
        Integer itemId = input.askInt("Enter id: ");
        Item item = tracker.findById(itemId);
        if (item == null) {
            System.out.println("No such id");
        } else {
            StartUI.printItem(item);
        }
        return true;
    }
}
