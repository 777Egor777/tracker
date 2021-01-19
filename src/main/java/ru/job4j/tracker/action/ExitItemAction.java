package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

/**
 * Menu Item of the
 * User Interface.
 * It helps to get
 * out from tracker.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public class ExitItemAction implements UserAction {
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
        return "=== Exit program ===";
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
    public boolean execute(Input input, Store tracker) {
        System.out.println(this.name());
        return false;
    }
}
