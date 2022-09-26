package ru.job4j.oop;

public class DummyDic {
    public String engToRus (String eng) {
        String word ="Неизвестное слово. " + eng;
        return word;
    }

    public static void main(String[] args) {
        DummyDic test = new DummyDic();
        String translate = test.engToRus("Name");
        System.out.println(translate);
    }
}
