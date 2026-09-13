package playlistoop;

/*
 * Class Member merupakan child class dari User.
 * Member dapat melihat daftar lagu, mencari lagu berdasarkan
 * judul, melihat detail lagu, dan menghitung rata-rata durasi.
 */
public class Member extends User {

    private Lagu[] playlist;

    // Constructor untuk membuat objek Member
    public Member(String nama, Lagu[] playlist) {
        super(nama);
        this.playlist = playlist;
    }

    /*
     * Method ini melakukan override terhadap method
     * tampilkanAkses() dari class User.
     * Implementasi yang berbeda menunjukkan polymorphism.
     */
    @Override
    public void tampilkanAkses() {
        System.out.println("Member " + nama
                + " dapat melihat dan mencari lagu dalam playlist.");
    }

    /*
     * Method lihatPlaylist() digunakan Member untuk
     * menelusuri semua lagu yang tersimpan dalam playlist.
     */
    public void lihatPlaylist() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           DAFTAR LAGU PLAYLIST");
        System.out.println("==========================================");

        boolean adaLagu = false;

        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null) {

                System.out.println(
                        (i + 1) + ". "
                        + playlist[i].getJudul()
                        + " - "
                        + playlist[i].getArtis()
                        + " ("
                        + String.format("%.2f", playlist[i].getDurasi())
                        + " menit)"
                );

                adaLagu = true;
            }
        }

        if (!adaLagu) {
            System.out.println("Playlist masih kosong.");
        }
    }

    /*
     * Method cariLagu() digunakan Member untuk mencari
     * lagu berdasarkan judul yang dimasukkan pengguna.
     */
    public void cariLagu(String judul) {

        boolean ditemukan = false;

        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null
                    && playlist[i].getJudul().equalsIgnoreCase(judul)) {

                System.out.println();
                System.out.println("Lagu ditemukan.");
                System.out.println("------------------------------------------");

                playlist[i].tampilkanInfo();

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {

            System.out.println();
            System.out.println("Lagu dengan judul \""
                    + judul
                    + "\" tidak ditemukan.");
        }
    }

    /*
     * Method lihatDetailLagu() digunakan Member untuk
     * melihat informasi lengkap dari lagu berdasarkan judul.
     */
    public void lihatDetailLagu(String judul) {

        boolean ditemukan = false;

        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null
                    && playlist[i].getJudul().equalsIgnoreCase(judul)) {

                System.out.println();
                System.out.println("==========================================");
                System.out.println("              DETAIL LAGU");
                System.out.println("==========================================");

                playlist[i].tampilkanInfo();

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {

            System.out.println();
            System.out.println("Lagu dengan judul \""
                    + judul
                    + "\" tidak ditemukan.");
        }
    }

    /*
     * Method hitungRataRataDurasi() digunakan untuk
     * menghitung rata-rata durasi seluruh lagu dalam playlist.
     */
    public void hitungRataRataDurasi() {

        double totalDurasi = 0;
        int jumlahLagu = 0;

        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null) {

                totalDurasi += playlist[i].getDurasi();
                jumlahLagu++;
            }
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         RATA-RATA DURASI LAGU");
        System.out.println("==========================================");

        if (jumlahLagu == 0) {

            System.out.println("Playlist masih kosong.");

        } else {

            double rataRata = totalDurasi / jumlahLagu;

            System.out.printf("Jumlah lagu    : %d%n", jumlahLagu);
            System.out.printf("Total durasi   : %.2f menit%n", totalDurasi);
            System.out.printf("Rata-rata      : %.2f menit%n", rataRata);
        }
    }
}