package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox fox = new Fox();
        System.out.print("Попытка зайца: ");
        hare.tryEat(ball);
        System.out.print("Попытка волка: ");
        wolf.tryEat(ball);
        System.out.print("Попытка лисы: ");
        fox.tryEat(ball);
    }
}
