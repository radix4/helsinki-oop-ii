public class CD implements ToBeStored{
    private String artist;
    private String title;
    private int year;
    public static final double WEIGH = 0.1;

    public CD(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    @Override
    public double weight() {
        return WEIGH;
    }

    @Override
    public String toString() {
        return artist + ": " + title + " (" + year + ")";
    }
}
