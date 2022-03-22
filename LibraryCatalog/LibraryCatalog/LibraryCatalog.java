package LibraryCatalog;


import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Book aBook = new Novel("  The Master and MARGARITA", 392, "fantastic fICTION   ");
        Book anotherBook = new Novel("Quo Vadis", 589, "historical novel");
        Book anAlbum = new ArtAlbum("Art Album", 50, "matte");
        Book anotherAlbum = new ArtAlbum("Album", 30, "matte");

        catalog.addBookFromMain(aBook);
        catalog.addBookFromMain(anotherBook);
        catalog.addBookFromMain(anAlbum);
        catalog.addBookFromMain(anotherAlbum);


//        catalog.openCatalog();

//        List<Book> books = new ArrayList();
//        books.add(new Novel("  The Master and MARGARITA", 392, "fantastic fICTION   "));
//        books.add(new Novel("Quo Vadis", 589, "historical novel"));
//        books.add(new Novel("Quo Vadis", 589, "historical novel"));
//        books.add(new Novel("Quo Vadis", 589, "historical novel"));
//        books.stream().filter(book -> book.getName().startsWith("Q")).forEach(System.out::println);

        try {
            throw new RuntimeException();
        } catch (Error error) {
            System.out.println("error");
        } finally {
            System.out.println("finally");
        }
    }
}
