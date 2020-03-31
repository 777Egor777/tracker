package ru.job4j.sort;

import java.util.Arrays;

public class Vending {
    public static final int[] COINS = {10, 5, 2, 1};
    public int[] change(int money, int price) {
        int[] result = new int[100];
        int size = 0;
        money -= price;
        int indexOfCoin = 0;
        while (money > 0) {
            while (COINS[indexOfCoin] > money) {
                indexOfCoin++;
            }
            money -= COINS[indexOfCoin];
            result[size++] = COINS[indexOfCoin];
        }
        return Arrays.copyOf(result, size);
    }
}
