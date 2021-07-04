package LibraryCatalog;

public class Novel extends Book{
    private String type;

    public Novel(String name, int pages, String type) {
        super(name, pages);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return super.toString() + " Type of novel: " + this.type + ".";
    }
}
