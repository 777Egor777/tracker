package ru.job4j.tracker;

/**
 * Interface that describe
 * one user action that
 * user chose from menu
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public interface UserAction {
    /**
     * Description of the
     * user action
     * @return String that
     *         describe user
     *         action
     */
    String name();

    /**
     * Method include
     * operation that we
     * should do according
     * to this user action
     * @param input - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     * @return true - if operation correctly
     *                finished
     *         false - otherwise
     */
    boolean execute(Input input, Tracker tracker);
}
