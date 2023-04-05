package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    private int indexOf(int id) {
        int result = -1;
        for (Item element : items) {
            if (element.getId() == id) {
                result = items.indexOf(element);
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
      return items;
    }

    public List<Item> findByName(String key) {
       List<Item> result = new ArrayList<>();
            for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean replace(int id, Item updateItem) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            updateItem.setId(id);
            items.set(index, updateItem);
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }
}