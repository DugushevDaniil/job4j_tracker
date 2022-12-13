package ru.job4j.poly;

public class Bus2 implements Vehicle {
    @Override
    public void move() {
        System.out.print("Двигается по трассе ");
    }

    @Override
    public void speed() {
        System.out.println("со скоростью 80 км/ч");
    }
}
