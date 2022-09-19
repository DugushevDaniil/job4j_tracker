package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String song;
        if (position == 1) {
            song = "Пусть бегут неуклюже";
            System.out.println(song);
        } else {
            if (position == 2) {
                song = "Спокойной ночи";
                System.out.println(song);
            } else {
                song = "Песня не найдена";
                System.out.println(song);
            }
        }
    }

    public static void main(String[] args) {
        Jukebox test = new Jukebox();
        test.music(1);
        test.music(2);
        test.music(3);

    }
}
