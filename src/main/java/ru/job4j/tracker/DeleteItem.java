package ru.job4j.tracker;

/**
 * Menu Item of the
 * User Interface.
 * It helps to delete
 * a user from tracker.
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version $Id$
 */
public class DeleteItem implements UserAction {
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
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(this.name());
        String itemId = input.askStr("Enter id: ");
        if (tracker.delete(itemId)) {
            System.out.println("Operation successful!");
        } else {
            System.out.println("No such id :(");
        }
        return true;
    }
}
