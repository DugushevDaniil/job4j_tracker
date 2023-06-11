package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("\\.");
        String[] rightParts = right.split("\\.");
        int length = Math.min(leftParts.length, rightParts.length);
        int rsl = 0;
        for (int i = 0; i < length - 1; i++) {
          rsl = Integer.compare(Integer.parseInt(leftParts[i]), Integer.parseInt(rightParts[i]));
          if (rsl != 0) {
              break;
          }
        }
        return rsl;
    }
}