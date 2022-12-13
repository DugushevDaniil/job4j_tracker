package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.print("Двигается по воздуху ");
    }

    @Override
    public void speed() {
        System.out.println("со скоростью 340 км/ч");
    }
}
