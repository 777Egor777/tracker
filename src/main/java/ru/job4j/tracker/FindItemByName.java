package ru.job4j.tracker;

import java.util.List;

/**
 * Menu Item of the
 * User Interface.
 * It helps to find
 * user in tracker
 * by Name.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
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
    public boolean execute(Input input, Store tracker) {
        System.out.println("=== Find item's by name ===");
        String itemName = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(itemName);
        StartUI.printItems(items);
        return true;
    }
}
