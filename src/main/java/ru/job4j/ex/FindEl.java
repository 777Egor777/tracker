package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
       int result = -1;

       for (int i = 0; i < value.length; ++i) {
           if (value[i] != null && value[i].equals(key)) {
               result = i;
               break;
           }
       }

       if (result == -1) {
           throw new ElementNotFoundException("There is no such String in array");
       }
       return result;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"Alex", "Kate", "Paul", "Viktor", null, "Sasha"};
        try {
            int index = indexOf(arr, "Sasha Gray");
            System.out.println(index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
