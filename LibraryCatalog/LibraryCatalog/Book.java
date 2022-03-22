package LibraryCatalog;

import java.util.Objects;

public class Book {
    private String name;
    private int numberOfPages;

    public Book(String name, int pages) {
        this.name = name;
        this.numberOfPages = pages;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int pages) {
        this.numberOfPages = pages;
    }

    public String toString() {
        return "Name: " + this.name + ", " + this.numberOfPages + " pages.";
    }
}

