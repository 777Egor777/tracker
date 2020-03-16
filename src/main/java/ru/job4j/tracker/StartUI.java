package ru.job4j.tracker;

import java.io.IOException;
import java.util.Scanner;

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
     * Method, that organize
     * interactive input of the
     * integer number from
     * diapason [start, finish]
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param message - Start message,
     *                output to console
     *                before user
     *                can print number
     * @param start - beginning of the
     *                diapason
     * @param finish - end of the
     *                 diapason
     * @return number that user enter
     */
    private int getInputNumberFromDiapason(Scanner scanner, String message, int start, int finish) throws IOException {
        int result = -1;
        while (!(result >= start && result <= finish)) {
            System.out.print(message);
            result = Integer.parseInt(scanner.nextLine());
        }
        System.out.println();
        return result;
    }

    /**
     * Print all menu items
     */
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Method organise interactive
     * input of new String
     * @param message - Start message. Output
     *                  to console before user
     *                  can print
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @return new String that user print
     */
    private String getInputString(String message, Scanner scanner) {
       String result = "";
       boolean run = true;
       while (run) {
           System.out.print(message);
           result = scanner.nextLine();
           run = false;
       }
       return result;
    }

    /**
     * Method print item
     * with specified
     * index
     * @param index - specified index
     * @param item - Item object to
     *               print
     */
    private void printItem(int index, Item item) {
        String result = "";
        if (index != -1) {
            result = String.format("%d. id: \"%s\"\n   name: \"%s\"\n",
                                   index,
                                   item.getId(),
                                   item.getName());
        } else {
            result = String.format("id: \"%s\"\nname: \"%s\"\n",
                                   item.getId(),
                                   item.getName());
        }
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
    private void printItems(Item[] items) {
        if (items != null) {
            if (items.length > 1) {
                for (int index = 0; index < items.length; ++index) {
                    this.printItem(index, items[index]);
                }
            } else if (items.length == 1) {
                this.printItem(-1, items[0]);
            } else {
                System.out.println("No items in tracker at the moment!!!");
            }
        }
    }

    /**
     * Interact mecthod.
     * Used for add new
     * item to Tracker
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void addItemToTracker(Scanner scanner, Tracker tracker) {
        System.out.println("=== Add new Item ===");
        String itemName = this.getInputString("Enter item name: ", scanner);
        Item item = new Item(itemName);
        tracker.add(item);
    }

    /**
     * Interact method. Send all
     * items in tracker to
     * standard output
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] allItems = tracker.findAll();
        this.printItems(allItems);
    }

    /**
     * Interact mecthod.
     * Used for edit
     * item in the Tracker
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void editItemInTracker(Scanner scanner, Tracker tracker) {
        System.out.println("=== Edit item ===");
        String itemId = this.getInputString("Enter id: ", scanner);
        String itemName = this.getInputString("Enter item name: ", scanner);
        Item item = new Item(itemName);
        if (tracker.replace(itemId, item)) {
            System.out.println("Operation successful!");
        } else {
            System.out.println("No such id :(");
        }
    }

    /**
     * Interact mecthod.
     * Used for deleting
     * item from the Tracker
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void deleteItemFromTracker(Scanner scanner, Tracker tracker) {
        System.out.println("=== Delete item ===");
        String itemId = this.getInputString("Enter id: ", scanner);
        if (tracker.delete(itemId)) {
            System.out.println("Operation successful!");
        } else {
            System.out.println("No such id :(");
        }
    }

    /**
     * Interact mecthod.
     * Used for searching
     * Item with id
     * that user enters.
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void findItemById(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find item by id  ===");
        String itemId = this.getInputString("Enter id: ", scanner);
        Item item = tracker.findById(itemId);
        if (item == null) {
            System.out.println("No such id");
        } else {
            this.printItem(-1, item);
        }
    }

    /**
     * Interact mecthod.
     * Used for searching
     * Item's with name
     * that user enters.
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void findItemsByName(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find item's by name ===");
        String itemName = this.getInputString("Enter name: ", scanner);
        Item[] items = tracker.findByName(itemName);
        this.printItems(items);
    }

    /**
     * Interact method. Get from user
     * number of menu item, and
     * do call necessary operation
     * next.
     * @param scanner - object of
     *                java.util.Scanner.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    private void init(Scanner scanner, Tracker tracker) throws IOException {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = this.getInputNumberFromDiapason(scanner, "Select: ", 0, 6);
            switch (select) {
                case 0: this.addItemToTracker(scanner, tracker);
                        break;
                case 1: this.showAllItems(tracker);
                        break;
                case 2: this.editItemInTracker(scanner, tracker);
                        break;
                case 3: this.deleteItemFromTracker(scanner, tracker);
                        break;
                case 4: this.findItemById(scanner, tracker);
                        break;
                case 5: this.findItemsByName(scanner, tracker);
                        break;
                case 6: System.out.println("=== Exit program ===");
                        run = false;
                        break;
                default: break;
            }
            System.out.println();
        }
    }

    /**
     * Main class, entry-point of the program.
     * We create here all necessary
     * objects and start to
     * interact with user.
     * @param args - standard compiler args
     * @throws IOException - method can
     *                       throw exception during
     *                       input-output processes
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
