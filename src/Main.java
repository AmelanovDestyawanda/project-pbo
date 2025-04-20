import java.util.Scanner;
import music.Playlist;
import music.Song;
import premium.PremiumPlan;
import premium.IndividualPlan;
import premium.StudentPlan;
import premium.FamilyPlan;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist("3am");

        PremiumPlan plan = null;

        int choice;
        do {
            System.out.println("\n================== MENU SPOTIFY ==================");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Lagu");
            System.out.println("3. Urutkan Lagu");
            System.out.println("4. Cari Lagu");
            System.out.println("5. Putar Semua Lagu");
            System.out.println("6. Buat Plan Premium");
            System.out.println("7. Lihat Info Plan Premium");
            System.out.println("8. Putar Lagu Tertentu");
            System.out.println("9. Hapus Lagu");
            System.out.println("0. Keluar");
            System.out.println("==================================================");
            System.out.print("                   Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // buang newline
            System.out.println("==================================================");

            switch (choice) {
                case 1:
                    System.out.print("\nJudul: ");
                    String title = scanner.nextLine();
                    System.out.print("Artis: ");
                    String artist = scanner.nextLine();
                    float duration = 0f;
                    boolean valid = false;
                    while (!valid) {
                        try {
                            System.out.print("Durasi (menit): ");
                            String input = scanner.nextLine();
                            duration = Float.parseFloat(input);
                            valid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Format tidak valid! Gunakan titik untuk desimal (contoh: 3.5)");
                        }
                    }

                    Song newSong = new Song(title, artist, duration);
                    playlist.addSong(newSong);
                    System.out.println("Lagu berhasil ditambahkan!");

                    System.out.println("Jumlah lagu sekarang: " + playlist.getSongs().size());
                    break;

                case 2:
                    playlist.showSongs();
                    break;
                
                case 3:
                    System.out.println("\nUrutkan berdasarkan:");
                    System.out.println("1. Durasi");
                    System.out.println("2. Judul");
                    System.out.print("Pilihan: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
            
                    if (sortChoice == 1) {
                        playlist.sortByDuration();
                        System.out.println("Lagu diurutkan berdasarkan durasi.");
                    } else if (sortChoice == 2) {
                        playlist.sortByTitle();
                        System.out.println("Lagu diurutkan berdasarkan judul.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break; 

                case 4:
                    System.out.print("\nKeyword: ");
                    String keyword = scanner.nextLine();
                    playlist.searchSong(keyword);
                    break;

                case 5:
                    playlist.playAll();
                    break;
            
                case 6:
                    System.out.println("\nPilih Plan:");
                    System.out.println("1. Individual");
                    System.out.println("2. Student");
                    System.out.println("3. Family");
                    System.out.print("Pilihan: ");
                    int planChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (planChoice) {
                        case 1:
                            System.out.print("Apakah kamu mahasiswa? (true/false): ");
                            boolean isStudent = scanner.nextBoolean();
                            scanner.nextLine();
                            plan = new IndividualPlan(isStudent);
                            break;               
                        case 2:
                            System.out.print("Email mahasiswa: ");
                            String email = scanner.nextLine();
                            plan = new StudentPlan("Student", 30000, email);
                            break;
                        case 3:
                            System.out.print("Jumlah anggota (max 6): ");
                            int memberCount = scanner.nextInt();                  scanner.nextLine();
                            plan = new FamilyPlan("Family", 79000, 0, 0, memberCount);
                            break;
                        default:
                            System.out.println("Plan tidak tersedia.");
                    }
                    if (plan != null) {
                        System.out.print("Berapa banyak yang ingin dibeli? ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();                        plan.sell(qty);

                        System.out.print("Mau kasih diskon? (0-100): ");
                        double discount = scanner.nextDouble();
                        scanner.nextLine();
                        plan.applyDiscount(discount);
                    }
                    break;
                case 7:
                    if (plan != null) {
                        System.out.println("\nInfo Plan:");
                        System.out.println(plan.getInfo());
                        System.out.println("Total Pendapatan: Rp" + (int) plan.getRevenue());
                    } else {
                        System.out.println("Belum ada plan dibuat.");
                    }
                    break;
                case 8:
                    playlist.showSongs(); // tampilkan daftar dulu
                    System.out.print("Masukkan nomor lagu yang ingin diputar (mulai dari 1): ");
                    int songIndex = scanner.nextInt();
                    scanner.nextLine(); // buang newline
                    playlist.playOneSong(songIndex - 1); // karena index mulai dari 0
                    break;
                case 9:
                    playlist.showSongs(); // tampilkan daftar lagu dulu
                    System.out.print("Masukkan nomor lagu yang ingin dihapus (mulai dari 1): ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine();
                    playlist.removeSong(deleteIndex - 1); // karena index dari 0
                    break;

                case 0:
                    System.out.println("\nTerima kasih sudah menggunakan Spotify versi Java!");
                    break;
            
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice!=0); 
            
        scanner.close();
    }
}