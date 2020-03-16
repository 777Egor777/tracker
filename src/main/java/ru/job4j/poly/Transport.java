package ru.job4j.poly;

public interface Transport {
    void move();
    void passengers(int numberOfPassengers);
    int fillUp(int liters);
}
