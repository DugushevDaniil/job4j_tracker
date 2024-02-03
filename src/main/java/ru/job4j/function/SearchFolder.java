package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        Predicate<Folder> moreThen100 = size -> (size.getSize() > 100);
        return filter(list, moreThen100);
    }

    public static List<Folder> filterName(List<Folder> list) {
    Predicate<Folder> isBug = name -> (name.getName().contains("bug"));
        return filter(list, isBug);
    }

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        List<Folder> added = new ArrayList<>();
        for (Folder folder:
             list) {
            if(predicate.test(folder)) {
                added.add(folder);
            }
        }
        return added;
    }
}
