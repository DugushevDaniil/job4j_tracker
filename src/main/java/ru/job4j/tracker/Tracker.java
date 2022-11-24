package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
      return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int  counter = 0;
        Item[] result = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
               result[counter++] = item;
            }
        }
        result = Arrays.copyOf(result, counter);
        return result;
    }

    public boolean replace(int id, Item updateItem) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        } else {
            updateItem.setId(id);
            items[index] = updateItem;
            return true;
        }
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        } else {
            System.arraycopy(items, index + 1,
                    items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
    }
}