package ru.job4j.oop;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    @Override
    public String name() {
        return super.name() + " and tomatoes";
    }
}
