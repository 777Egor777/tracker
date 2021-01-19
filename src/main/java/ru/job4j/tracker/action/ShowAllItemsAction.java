package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

import java.util.List;

/**
 * Menu Item of the
 * User Interface.
 * It helps to show
 * all Items in
 * the tracker.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public class ShowAllItemsAction implements UserAction {
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
    public boolean execute(Input input, Store tracker) {
        System.out.println(this.name());
        List<Item> allItems = tracker.findAll();
        StartUI.printItems(allItems);
        return true;
    }
}
