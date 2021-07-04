package OOP;


import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {

    private final ArrayList<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    public void openCatalog() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Catalog opened.");

        this.printAllBooks();

        while (true) {
            System.out.println("Select operation: add / search / update / delete / quit");

            String input = scanner.nextLine();
            input = trimToLowerCase(input);

            if (input.equals("add")) {
                this.addBookFromInput();
                this.printAllBooks();

                continue;
            }

            if (input.equals("search")) {
                System.out.println("What are you searching for: novel / album ?");
                String searchFor = scanner.nextLine();
                searchFor = trimToLowerCase(searchFor);

                if (searchFor.equals("novel")) {
                    System.out.println("Search for novels by: name / type / list all");
                    String searchNovelsBy = scanner.nextLine();
                    searchNovelsBy = trimToLowerCase(searchNovelsBy);

                    searchForNovels(scanner, searchNovelsBy);

                    continue;
                }

                if (searchFor.equals("album")) {
                    System.out.println("Search for albums by: name / paper quality / list all ");
                    String searchAlbumsBy = scanner.nextLine();
                    searchAlbumsBy = trimToLowerCase(searchAlbumsBy);

                    searchForAlbums(scanner, searchAlbumsBy);

                    continue;
                }

                System.out.println("Unknown search parameter: [" + searchFor + "]. Back to main menu (Try searching for [novel] / [album]).");

                continue;
            }

            if (input.equals("update")) {
                System.out.println("Enter the name of the book: ");
                String name = scanner.nextLine();
                name = trimToLowerCase(name);
                this.updateEntry(name);
                this.printAllBooks();

                continue;
            }

            if (input.equals("delete")) {
                System.out.println("Enter the name of the book: ");
                String name = scanner.nextLine();
                name = trimToLowerCase(name);
                this.deleteEntry(name);
                this.printAllBooks();

                continue;
            }

            if (input.equals("quit")) {
                System.out.println("Catalog closed.");

                return;
            }

            System.out.println("Unknown command. Back to main menu (select 'quit' to exit the program).");
        }
    }

    private String trimToLowerCase(String input) {
        input = input.trim();
        input = input.toLowerCase();

        return input;
    }

    public void addBookFromMain(Book book) {
        book.setName(trimToLowerCase(book.getName()));

        if (book instanceof Novel) {
            ((Novel) book).setType(trimToLowerCase(((Novel) book).getType()));
        }

        if (book instanceof ArtAlbum) {
            ((ArtAlbum) book).setPaperQuality(trimToLowerCase(((ArtAlbum) book).getPaperQuality()));
        }

        this.books.add(book);
    }

    public void addBookFromInput () {
        Scanner scanner = new Scanner(System.in);

        String novelOrAlbum = enterType(scanner);
        if (novelOrAlbum == null) {
            return;
        }

        String name = enterName(scanner, novelOrAlbum);
        if (name == null) {
            return;
        }

        int numberOfPages = enterNumberOfPages(scanner);

        addToCatalog(scanner, novelOrAlbum, name, numberOfPages);
    }

    private void addUpdatedEntryToCatalog(Scanner scanner, String novelOrAlbum, String name, int numberOfPages, int position) {
        if (novelOrAlbum.equals("novel")) {
            System.out.println("Please enter the type of novel");
            String typeOfNovel = scanner.nextLine();
            typeOfNovel = trimToLowerCase(typeOfNovel);
            this.books.set(position, new Novel(name, numberOfPages, typeOfNovel));
        }

        if (novelOrAlbum.equals("album")) {
            System.out.println("Please enter the type of paper(matte / luster / silk / high gloss etc)");
            String paper = scanner.nextLine();
            paper = trimToLowerCase(paper);
            this.books.set(position, new ArtAlbum(name, numberOfPages, paper));
        }

        System.out.println("Entry updated.");
    }

    private void addToCatalog(Scanner scanner, String novelOrAlbum, String name, int numberOfPages) {
        if (novelOrAlbum.equals("novel")) {
            System.out.println("Please enter the type of novel");
            String typeOfNovel = scanner.nextLine();
            typeOfNovel = trimToLowerCase(typeOfNovel);
            this.books.add(new Novel(name, numberOfPages, typeOfNovel));
        }

        if (novelOrAlbum.equals("album")) {
            System.out.println("Please enter the type of paper(matte / luster / silk / high gloss etc)");
            String paper = scanner.nextLine();
            paper = trimToLowerCase(paper);
            this.books.add(new ArtAlbum(name, numberOfPages, paper));
        }

        System.out.println("Entry added.");
    }

    private String enterType(Scanner scanner) {
        String type;
        while (true) {
            System.out.println("Choose the type of book: novel or album. Press 'Enter' to quit this process.");
            type = scanner.nextLine();
            type = trimToLowerCase(type);

            if (type.equals("")) {
                System.out.println("Process cancelled. Back to main menu.");
                return null;
            }

            if (type.equals("novel") || type.equals("album")) {
                break;
            }   else {
                System.out.println("You can only add novels or albums to the catalog.");
            }
        }
        return type;
    }

    private String enterName(Scanner scanner, String novelOrAlbum) {
        System.out.println("Please enter the name");
        String name = scanner.nextLine();
        name = trimToLowerCase(name);

        if(nameIsInTheCatalog(name)) {
            if (novelOrAlbum.equals("novel") && isNovel(name)) {
                System.out.println("The novel '" + name + "' is already in the catalog. You can update this entry by selecting 'update' at program start.");
                return null;
            }
            if (novelOrAlbum.equals("album") && isAlbum(name)){
                System.out.println("The album '" + name + "' is already in the catalog. You can update this entry by selecting 'update' at program start.");
                return null;
            }
        }

        return name;
    }

    private int enterNumberOfPages(Scanner scanner) {
        int pages;
        while (true) {
            System.out.println("Please enter the number of pages (Numerical value required):");
            try {
                String numberOfPages = scanner.nextLine();
                pages = Integer.parseInt(numberOfPages);
                if (pages < 0) {
                    System.out.println("That's impossible. You can't have a negative number of pages.");
                    continue;
                }
                break;
            }   catch (Exception e) {
                System.out.println("Error: Numerical input not provided.");
            }
        }

        return pages;
    }

    public boolean isAlbum(String name) {
        boolean isAlbum = false;
        for (Book book : this.books) {
            if (book.getName().equals(name) && book instanceof ArtAlbum) {
                isAlbum = true;
                break;
            }
        }

        return isAlbum;
    }

    public boolean isNovel(String name) {
        boolean isNovel = false;
        for (Book book : this.books) {
            if (book.getName().equals(name) && book instanceof Novel) {
                isNovel = true;
                break;
            }
        }

        return isNovel;
    }

    public void searchForNovels(Scanner scanner, String searchNovelsBy) {
        if (searchNovelsBy.equals("name")) {
            System.out.println("Please enter the name: ");
            String name = scanner.nextLine();
            name = trimToLowerCase(name);
            findNovelByName(name);
            return;
        }

        if (searchNovelsBy.equals("type")) {
            System.out.println("Please enter the type: ");
            String type = scanner.nextLine();
            type = trimToLowerCase(type);
            findNovelsByType(type);
            return;
        }

        if (searchNovelsBy.equals("list all")) {
            System.out.println("Novels currently in catalog: ");
            printOnly("novels");
            return;
        }

        System.out.println("Unknown command: [" + searchNovelsBy + "]. 'Search' process ended. Back to main menu.");
    }

    public void searchForAlbums (Scanner scanner, String searchAlbumsBy) {
        if (searchAlbumsBy.equals("name")) {
            System.out.println("Please enter the name: ");
            String name = scanner.nextLine();
            name = trimToLowerCase(name);
            findAlbumByName(name);
            return;
        }

        if (searchAlbumsBy.equals("paper quality")) {
            System.out.println("Please enter the type of paper: ");
            String typeOfPaper = scanner.nextLine();
            typeOfPaper = trimToLowerCase(typeOfPaper);
            findAlbumsByTypeOfPaper(typeOfPaper);
            return;
        }

        if (searchAlbumsBy.equals("list all")) {
            System.out.println("Albums currently in catalog: ");
            printOnly("albums");
            return;
        }

        System.out.println("Unknown command: [" + searchAlbumsBy + "]. 'Search' process ended. Back to main menu.");
    }

    public void findNovelByName(String name) {

        for (Book book : this.books) {
            if (book.getName().equals(name) && book instanceof Novel){
                System.out.println("Novel found: ");
                System.out.println(book);
                return;
            }
        }

        System.out.println("No novel by that name found.");
    }

    public void findNovelsByType(String type) {
        ArrayList<Book> novelsOfSameType = new ArrayList<>();
        for (Book book : this.books) {
            if (book instanceof Novel && ((Novel) book).getType().equals(type)) {
                novelsOfSameType.add(book);
            }
        }
        if (novelsOfSameType.isEmpty()) {
            System.out.println("No novels of type [" + type + "] found.");
        }   else {
            System.out.println("Novels of type " + type + " found: ");
            for (Book novel : novelsOfSameType) {
                System.out.println(novel);
            }
        }

    }

    public void findAlbumByName(String name) {
        for (Book book : this.books) {
            if (book.getName().equals(name) && book instanceof ArtAlbum){
                System.out.println("Album found: ");
                System.out.println(book);
                return;
            }
        }

        System.out.println("No album by that name found.");
    }

    public void findAlbumsByTypeOfPaper(String typeOfPaper) {
        ArrayList<Book> albumsOfSamePaperType = new ArrayList<>();
        for (Book book : this.books) {
            if (book instanceof ArtAlbum && ((ArtAlbum) book).getPaperQuality().equals(typeOfPaper)) {
                albumsOfSamePaperType.add(book);
            }
        }
        if (albumsOfSamePaperType.isEmpty()) {
            System.out.println("No albums with that paper quality found.");
        }   else {
            System.out.println("Albums of " + typeOfPaper + " paper quality found: ");
            for (Book novel : albumsOfSamePaperType) {
                System.out.println(novel);
            }
        }
    }

    public boolean nameIsInTheCatalog(String name) {
        boolean isInTheCatalog = false;

        for (Book element : this.books) {
            if (element.getName().equals(name)) {
                isInTheCatalog = true;

                break;
            }
        }

        return isInTheCatalog;
    }

    private void makeUpdate(int position) {
        System.out.println("Please fill out this entry's information again, updating it where needed:");
        Scanner scanner = new Scanner(System.in);

        String novelOrAlbum = enterType(scanner);
        if (novelOrAlbum == null) {
            return;
        }

        System.out.println("Please enter the name:");
        String newName = scanner.nextLine();
        newName = trimToLowerCase(newName);

        for (Book book : this.books) {
            if (book.getName().equals(newName) && this.books.indexOf(book) != position) {
                if (novelOrAlbum.equals("album") && book instanceof ArtAlbum) {
                    System.out.println("An album named '" + newName + "' is already in the catalog. You can update that specific entry instead, " +
                                        "by writing its name to be updated in the Update menu.");
                    return;
                }
                if (novelOrAlbum.equals("novel") && book instanceof Novel) {
                    System.out.println("A novel named '" + newName + "' is already in the catalog. You can update that specific entry instead, " +
                            "by writing its name to be updated in the Update menu.");
                    return;
                }
            }
        }

        int newNumberOfPages = enterNumberOfPages(scanner);

        addUpdatedEntryToCatalog(scanner, novelOrAlbum, newName, newNumberOfPages, position);
    }

    private void updateEntry (String name) {
        if (nameIsInTheCatalog(name)) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Book> list = new ArrayList<>();
            for (Book book : this.books) {
                if (book.getName().equals(name)) {
                    list.add(book);
                }
            }

            if (list.size() == 1) {
                int position = this.books.indexOf(list.get(0));
                System.out.println("Entry found at position: " + position + "\n" + list.get(0));
                makeUpdate(position);
                return;
            }

            if (list.size() == 2) {
                System.out.println("Two entries found: " + "\n" + list.get(0) + "\n" + list.get(1));
                while (true) {
                    System.out.println("Which entry do you want to update: first / second / none ?");
                    String firstOrSecond = scanner.nextLine();
                    firstOrSecond = trimToLowerCase(firstOrSecond);
                    switch (firstOrSecond) {
                        case "first":
                            int position = this.books.indexOf(list.get(0));
                            makeUpdate(position);
                            return;
                        case "second":
                            position = this.books.indexOf(list.get(1));
                            makeUpdate(position);
                            return;
                        case "none":
                            System.out.println("Update operation cancelled. Back to main menu.");
                            return;
                        default:
                            System.out.println("Unknown command [" + firstOrSecond + "]");
                            break;
                    }
                }
            }
        }
        System.out.println("The book '" + name + "' is not in the catalog. You can add it by selecting 'add' at program start.");
    }

    private void deleteEntry(String name) {
        if (nameIsInTheCatalog(name)) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Book> list = new ArrayList<>();

            for (Book book : this.books) {
                if (book.getName().equals(name)) {
                    list.add(book);
                }
            }
            if (list.size() == 1) {
                System.out.println("Entry found: " + "\n" + list.get(0));
                while (true) {
                    System.out.println("Are you sure you want to delete this entry? yes / no");

                    String yesOrNo = scanner.nextLine();
                    yesOrNo = trimToLowerCase(yesOrNo);
                    if (yesOrNo.equals("yes")) {
                        this.books.remove(list.get(0));
                        System.out.println("Entry deleted.");
                        return;
                    }   else if (yesOrNo.equals("no")) {
                        System.out.println("Delete operation cancelled. Back to main menu.");
                        return;
                    }   else {
                        System.out.println("Unknown command [" + yesOrNo + "]");
                    }
                }
            }

            if (list.size() == 2) {
                System.out.println("Two entries found: " + "\n" + list.get(0) + "\n" + list.get(1));
                while (true) {
                    System.out.println("Which entry do you want to delete: first / second / none ?");
                    String firstOrSecond = scanner.nextLine();
                    firstOrSecond = trimToLowerCase(firstOrSecond);
                    switch (firstOrSecond) {
                        case "first":
                            this.books.remove(list.get(0));
                            System.out.println("Entry deleted.");
                            return;
                        case "second":
                            this.books.remove(list.get(1));
                            System.out.println("Entry deleted");
                            return;
                        case "none":
                            System.out.println("Delete operation cancelled. Back to main menu.");
                            return;
                        default:
                            System.out.println("Unknown command [" + firstOrSecond + "]");
                            break;
                    }
                }
            }
        }

        System.out.println("The book '" + name + "' is not in the catalog, so it can't be deleted.");
    }

    public void printAllBooks() {
        System.out.println();
        System.out.println("Books in the catalog: ");

        if (this.books.size() > 0) {
            for (Book item: books) {
                System.out.println(item);
            }
            System.out.println();
        }   else {
            System.out.println("The catalog is empty.");
        }
    }

    public void printOnly(String albumsOrNovels) {
        if (albumsOrNovels.equals("albums") || albumsOrNovels.equals("novels")) {
            ArrayList<Book> list = new ArrayList<>();

            if (albumsOrNovels.equals("novels")) {
                for (Book book : this.books) {
                    if (book instanceof Novel) {
                        list.add(book);
                    }
                }
            }

            if (albumsOrNovels.equals("albums")) {
                for (Book book : this.books) {
                    if (book instanceof ArtAlbum) {
                        list.add(book);
                    }
                }
            }

            if (list.isEmpty()) {
                System.out.println("None found.");
            } else {
                for (Book book : list) {
                    System.out.println(book);
                }
            }
        }
    }
}



