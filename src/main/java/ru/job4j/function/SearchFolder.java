package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        List<Folder> added = new ArrayList<>();
        for (Folder folder : list) {
            if (predicate.test(folder)) {
                added.add(folder);
            }
        }
        return added;
    }
}
