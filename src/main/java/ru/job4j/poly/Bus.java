package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Едет по маршруту ");
    }

    @Override
    public void passengers(int numberOf) {
        System.out.println("Колличество мест в автобусе " + numberOf);
    }

    @Override
    public double refuelingPrice(double fuel) {
        double price = 45.84;
        return price * fuel;
    }
}
