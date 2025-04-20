package music;
public class Song {
    private String title;
    private String artist;
    private float duration;

    public Song(String title, String artist, float duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() { 
        return artist; 
    }
    public void setArtist(String artist) { 
        this.artist = artist; 
    }
    public float getDuration() { 
        return duration; 
    }
    public void setDuration(float duration) { 
        this.duration = duration; 
    }
    public void play() {
        System.out.println("\nMemutar lagu: " + title + " oleh " + artist);
    }
    @Override
    public String toString() {
        return title + " - " + artist + " (" + String.format("%.2f", duration) + " menit)";
    }
    public static void quickSort(Song[] songs) {
    }
    public void sell(int qty) {
    }
    public void getRevenue() {    
    }
    public boolean getInfo() {
        return false;
    }
    public void applyDiscount(double disc) {
    }
}
