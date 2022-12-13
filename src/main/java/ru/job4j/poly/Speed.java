package ru.job4j.poly;

public class Speed {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus2();
        Vehicle train = new Train();
        Vehicle[] transport = new Vehicle[] {plane, bus, train};
        for (Vehicle i : transport) {
            i.move();
            i.speed();
        }
    }
}
