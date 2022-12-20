package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.print("Двигается по рельсам ");
    }

    @Override
    public void speed() {
        System.out.println("со скоростью 60 км/ч");
    }
}
