package ru.job4j.pojo;

public class Shop {
    public static Product[] delete(Product[] products, int positionToDelete) {
        for (int index = positionToDelete; index < products.length - 1; index++) {
            products[index] = products[index + 1];
        }
        products[products.length - 1] = null;
        return products;
    }

    public static void printProductArray(Product[] products) {
        for (int index = 0; index < products.length; ++index) {
            System.out.print(index + ": ");
            if (products[index] == null) {
                System.out.println("null");
            } else {
                System.out.println(products[index].getName());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("Bread", 5);
        products[1] = new Product("MilkPackage", 3);
        products[2] = new Product("Egg", 10);
        products[3] = new Product("KgOfMeat", 1);
        System.out.println("Start array:");
        printProductArray(products);
        delete(products, 2);
        System.out.println("Array after deleting Eggs:");
        printProductArray(products);
    }
}
