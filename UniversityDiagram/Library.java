package UniversityDiagram;

public class Library extends Room {
    private String libraryName;
    private Employee librarian;

    public Library(String roomNumber) {
        super(roomNumber);
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Employee getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Employee librarian) {
        this.librarian = librarian;
    }

    public String toString() {
        return this.libraryName;
    }
}
