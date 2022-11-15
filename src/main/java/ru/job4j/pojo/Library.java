package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book lTolstoy = new Book("War and Peace", 1225);
        Book rMartin = new Book("Clean Code", 464);
        Book tDreiser = new Book("The Financier", 450);
        Book jLondon = new Book("Martin Eden", 450);
        Book[] lib = new Book[4];
        lib[0] = lTolstoy;
        lib[1] = rMartin;
        lib[2] = tDreiser;
        lib[3] = jLondon;
        for (int index = 0; index < lib.length; index++) {
            Book book = lib[index];
            System.out.println(book.getName() + " - " + book.getPage());
        }
        System.out.println();
        System.out.println("Replace 0 and 3");
        Book bookShelf = lib[0];
        lib[0] = lib[3];
        lib[3] = bookShelf;
        for (int index = 0; index < lib.length; index++) {
            Book book = lib[index];
            System.out.println(book.getName() + " - " + book.getPage());
        }
        System.out.println();
        System.out.println("Search for \"Clean Code\"");
        for (int index = 0; index < lib.length; index++) {
            Book book = lib[index];
            if (lib[index].getName() == "Clean Code") {
                System.out.println(book.getName() + " - " + book.getPage());
            }
        }
    }
}
