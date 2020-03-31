package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

/**
 * Class used to interact
 * with user. It get from
 * user number of menu item
 * and oll other needed
 * information and do
 * call all needed
 * operations
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class StartUI {
    /**
     * All possible actions
     * that user can call
     */
    public List<UserAction> actions;
    {
        this.actions = Arrays.asList(
                new AddItem(),
                new ShowAllItems(),
                new EditItem(),
                new DeleteItem(),
                new FindItemByID(),
                new FindItemByName(),
                new ExitItem()
        );
    }

    /**
     * Print all menu items
     */
    public void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); ++index) {
            System.out.println(index + ": " + actions.get(index).name());
        }
    }

    /**
     * Method print item
     * @param item - Item object to
     *               print
     */
    public static void printItem(Item item) {
        String result = String.format("id: \"%s\"  name: \"%s\"%s",
                                   item.getId(),
                                   item.getName(), System.lineSeparator());
        System.out.print(result);
    }

    /**
     * Print name of all
     * Item object that
     * located in item's array
     * @param items - array of Item objects,
     *                which name's we
     *                should print
     */
    public static void printItems(List<Item> items) {
        if (items.size() > 0) {
            for (Item item : items) {
                StartUI.printItem(item);
            }
        } else {
            System.out.println("No items in tracker at the moment!!!");
        }
    }

    /**
     * Interact method. Get from user
     * number of menu item, and
     * do call necessary operation
     * next.
     * @param input - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            run = actions.get(select).execute(input, tracker);
            System.out.println();
        }
    }

    /**
     * Main class, entry-point of the program.
     * We create here all necessary
     * objects and start to
     * interact with user.
     * @param args - standard compiler args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        StartUI ui = new StartUI();
        ui.init(input, tracker, ui.actions);
    }
}
