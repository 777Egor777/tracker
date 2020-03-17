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
     * All possible actions
     * that user can call
     */
    public static UserAction[] actions;
    {
        this.actions = new UserAction[]{
                new AddItem(),
                new ShowAllItems(),
                new EditItem(),
                new DeleteItem(),
                new FindItemByID(),
                new FindItemByName(),
                new ExitItem()
        };
    }

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
    public static void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; ++index) {
            System.out.println(index + ": " + actions[index].name());
        }
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
        String result;
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
    public static void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            StartUI.showMenu(actions);
            int select = StartUI.getInputNumberFromDiapason(input,
                    "Select: ", 0, actions.length - 1);
            run = actions[select].execute(input, tracker);
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
        StartUI.init(input, tracker, StartUI.actions);
    }
}
