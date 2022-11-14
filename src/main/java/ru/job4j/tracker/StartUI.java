package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
         Item created = new Item();
         LocalDateTime currentDate = created.getCreated();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
         String currentDateTimeFormat = currentDate.format(formatter);
         System.out.println(currentDateTimeFormat);
    }
}
