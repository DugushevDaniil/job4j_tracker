package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private static final int A380_COUNT_ENGINE = 4;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println((name.equals("A380")) ? "Количество двигателей равно: " + A380_COUNT_ENGINE
                : "Количество двигателей равно: " + COUNT_ENGINE);
        }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
