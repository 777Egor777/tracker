package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book orwell = new Book("1984", 319);
        Book martin = new Book("Clean code", 462);
        Book robbins = new Book("AWAKEN THE GIANT WITHIN", 742);
        Book headfist = new Book("HeadFist Java", 690);
        Book[] books = new Book[4];
        books[0] = orwell;
        books[1] = martin;
        books[2] = robbins;
        books[3] = headfist;
        printBooksArray(books);
        System.out.println("switch 0 and 3 books");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        printBooksArray(books);
        System.out.println("Output only books with name \"Clean code\"");
        for (int index = 0; index < books.length; ++index) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println(books[index].getName() + " - "
                                 + books[index].getPages() + " pages");
            }
        }
    }

    public static void printBooksArray(Book[] books) {
        for (int index = 0; index < books.length; ++index) {
            System.out.println(String.format("%d: %s - %d pages", index,
                    books[index].getName(), books[index].getPages()));
        }
    }
}
