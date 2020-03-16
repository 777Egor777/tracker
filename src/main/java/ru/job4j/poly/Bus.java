package ru.job4j.poly;

public class Bus implements Transport {
    private int numberOfPassengers;

    @Override
    public void move() {
        System.out.println("Bus start to move");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int fillUp(int liters) {
        return 49 * liters;
    }
}
