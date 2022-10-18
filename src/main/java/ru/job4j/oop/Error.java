package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Ошибка: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Пояснение: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 1, "Ошибка ввода параметров");
        error1.printInfo();
        System.out.println();
        error2.printInfo();
    }
}
