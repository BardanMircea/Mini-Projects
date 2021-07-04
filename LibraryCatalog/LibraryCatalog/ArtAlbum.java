package LibraryCatalog;

public class ArtAlbum extends Book{
    private String paperQuality;

    public ArtAlbum(String name, int pages, String paperQuality){
        super(name, pages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return this.paperQuality;
    }

    public void setPaperQuality(String paper) {
        this.paperQuality = paper;
    }

    public String toString() {
        return super.toString() + " Paper quality: " + this.paperQuality + ".";
    }
}
