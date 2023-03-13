package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (key == null) {
            throw new ElementNotFoundException("Элемент массива не может быть null");
        }
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if(value[i].equals(key)) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"1", "2", "3", "ok"}, "ok");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
