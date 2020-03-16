package ru.job4j.tracker;

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
     * @param input - object of
     *                class that realise
     *                Input interface.
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
    public static int getInputNumberFromDiapason(Input input, String message, int start, int finish) {
        int result = -1;
        while (!(result >= start && result <= finish)) {
            result = input.askInt(message);
        }
        System.out.println();
        return result;
    }

    /**
     * Print all menu items
     */
    public static void showMenu() {
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
     * @param input - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @return new String that user print
     */
    public static String getInputString(String message, Input input) {
       String result = "";
       boolean run = true;
       while (run) {
           result = input.askStr(message);
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
    public static void printItem(int index, Item item) {
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
    public static void printItems(Item[] items) {
        if (items != null) {
            if (items.length > 1) {
                for (int index = 0; index < items.length; ++index) {
                    StartUI.printItem(index, items[index]);
                }
            } else if (items.length == 1) {
                StartUI.printItem(-1, items[0]);
            } else {
                System.out.println("No items in tracker at the moment!!!");
            }
        }
    }

    /**
     * Interact mecthod.
     * Used for add new
     * item to Tracker
     * @param input - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    public static void addItemToTracker(Input input, Tracker tracker) {
        System.out.println("=== Add new Item ===");
        String itemName = StartUI.getInputString("Enter item name: ", input);
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
    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] allItems = tracker.findAll();
        StartUI.printItems(allItems);
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
    public static void editItemInTracker(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        String itemId = StartUI.getInputString("Enter id: ", input);
        String itemName = StartUI.getInputString("Enter item name: ", input);
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
     * @param input - object of class that
     *                realise Input interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    public static void deleteItemFromTracker(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        String itemId = StartUI.getInputString("Enter id: ", input);
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
     * @param input - object of class
     *                that realise Input
     *                interface.
     *                Need to organise
     *                input.
     * @param tracker - object of Tracker class
     *                  that we interact with
     */
    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id  ===");
        String itemId = StartUI.getInputString("Enter id: ", input);
        Item item = tracker.findById(itemId);
        if (item == null) {
            System.out.println("No such id");
        } else {
            StartUI.printItem(-1, item);
        }
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
    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find item's by name ===");
        String itemName = StartUI.getInputString("Enter name: ", input);
        Item[] items = tracker.findByName(itemName);
        StartUI.printItems(items);
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
    public static void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            StartUI.showMenu();
            int select = StartUI.getInputNumberFromDiapason(input, "Select: ", 0, 6);
            switch (select) {
                case 0: StartUI.addItemToTracker(input, tracker);
                        break;
                case 1: StartUI.showAllItems(tracker);
                        break;
                case 2: StartUI.editItemInTracker(input, tracker);
                        break;
                case 3: StartUI.deleteItemFromTracker(input, tracker);
                        break;
                case 4: StartUI.findItemById(input, tracker);
                        break;
                case 5: StartUI.findItemsByName(input, tracker);
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
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI.init(input, tracker);
    }
}
