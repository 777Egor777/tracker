package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int result = 1;
        if (n < 0) {
            throw new IllegalArgumentException("n shouldn't be negative");
        } else if (n < 2) {
            result = 1;
        } else {
            result = n * calc(n - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int rsl = calc(0);
        System.out.println(rsl);
    }
}
