package music;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void showSongs() {
        System.out.println("\nPlaylist: " + name);
        if (songs.isEmpty()) {
            System.out.println("Belum ada lagu di playlist ini.");
        } else {
            for (Song s : songs) {
                System.out.println("- " + s.getTitle() + " by " + s.getArtist() + " (" + s.getDuration() + " menit)");
            }
        }
    }

    public void sortByTitle() {
        Collections.sort(songs, new Comparator<Song>() { 
            @Override public int compare(Song s1, Song s2) { return s1.getTitle().compareToIgnoreCase(s2.getTitle());}
        });
    }

    public void sortByDuration() {
        quickSort(0, songs.size() - 1);
    }

    public void searchSong(String keyword) {
        boolean found = false;
        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(keyword.toLowerCase()) || 
                s.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Ditemukan: " + s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Lagu tidak ditemukan.");
        }
    }
    
    public void playOneSong(int index) {
        if (index >= 0 && index < songs.size()) {
            Song song = songs.get(index);
            System.out.println("Memutar: " + song.getTitle() + " oleh " + song.getArtist());
            System.out.printf("(jeda simulasi sekitar %.1f detik)%n", song.getDuration());
            try {
                // Simulasi pemutaran lagu, 1 menit = 1 detik
                Thread.sleep((long)song.getDuration() * 1000); 
            } catch (InterruptedException e) {
                System.out.println("Error saat memutar lagu.");
            }
            System.out.println("Lagu selesai diputar.");
        } else {
            System.out.println("Lagu dengan nomor tersebut tidak ditemukan.");
        }
    }
    
    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        float pivot = songs.get(high).getDuration();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (songs.get(j).getDuration() < pivot) {
                i++;
                Song temp = songs.get(i);
                songs.set(i, songs.get(j));
                songs.set(j, temp);
            }
        }
        Song temp = songs.get(i + 1);
        songs.set(i + 1, songs.get(high));
        songs.set(high, temp);
        return i + 1;
    }
    
    public void playAllSongs() {
        for (Song s : songs) {
            s.play();
        }
    }

    public void playAll() {
        playAllSongs();
    }

    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            Song removed = songs.remove(index);
            System.out.println("Lagu \"" + removed.getTitle() + "\" by " + removed.getArtist() + " telah dihapus.");
        } else {
            System.out.println("Indeks lagu tidak valid.");
        }
    }
}