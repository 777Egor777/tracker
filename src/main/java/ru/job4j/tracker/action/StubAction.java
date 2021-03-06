package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

/**
 * Implementation of the
 * UserAction interface.
 * We use it for
 * testing.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public class StubAction implements UserAction {
    /**
     * true - if method "execute"
     *        of this object was
     *        called
     * false - otherwise
     */
    private boolean call = false;

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
        return "Stub action";
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
        this.call = true;
        return false;
    }

    public boolean isCall() {
        return this.call;
    }
}
