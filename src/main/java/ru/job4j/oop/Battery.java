package ru.job4j.oop;

public class Battery {
    private int load;

    public void setLoad(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.setLoad(another.getLoad() + this.load);
        this.load = 0;
    }
}
