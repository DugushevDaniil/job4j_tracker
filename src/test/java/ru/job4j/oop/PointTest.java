package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    public void when000and122Then3() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 2, 2);
        double distance = a.distance3d(b);
        double expected = 3;
        assertEquals(expected, distance);
    }

    @Test
    public void when561and123Then6() {
        Point a = new Point(5, 6, 1);
        Point b = new Point(1, 2, 3);
        double distance = a.distance3d(b);
        double expected = 6;
        assertEquals(expected, distance);
    }
}