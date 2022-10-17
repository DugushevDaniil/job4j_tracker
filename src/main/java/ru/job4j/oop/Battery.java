package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery charger = new Battery(30);
        Battery second = new Battery(20);
        System.out.println("charger: " + charger.load + ". second: " + second.load);
        charger.exchange(second);
        System.out.println("charger: " + charger.load + ". second: " + second.load);
    }
}
