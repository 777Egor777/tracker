package ru.job4j.sort;

import java.util.Arrays;

public class Vending {
    public static final int[] coins = {10, 5, 2, 1};
    public int[] change(int money, int price) {
        int[] result = new int[100];
        int size = 0;
        money -= price;
        while (money > 0) {
            forblock:
            {
                for (int index = 0; index < coins.length; ++index) {
                    if (coins[index] <= money) {
                        money -= coins[index];
                        result[size++] = coins[index];
                        break forblock;
                    }
                }
            }
        }
        return Arrays.copyOf(result, size);
    }
}
