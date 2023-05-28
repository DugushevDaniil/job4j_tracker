package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {
    @Test
    public void itemAscByNameTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Car"));
        items.add(new Item("Ball"));
        items.add(new Item("Tetris"));
        items.add(new Item("Avatar"));
        items.sort(new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Tetris"));
        expected.add(new Item("Car"));
        expected.add(new Item("Ball"));
        expected.add(new Item("Avatar"));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void itemDescByNameTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Car"));
        items.add(new Item("Ball"));
        items.add(new Item("Tetris"));
        items.add(new Item("Avatar"));
        items.sort(new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Avatar"));
        expected.add(new Item("Ball"));
        expected.add(new Item("Car"));
        expected.add(new Item("Tetris"));
        assertThat(items).isEqualTo(expected);
    }
}