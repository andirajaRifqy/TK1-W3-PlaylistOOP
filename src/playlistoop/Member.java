package playlistoop;

/*
 * Class Member merupakan child class dari User.
 *
 * Member dapat melihat daftar lagu, mencari lagu berdasarkan
 * judul, melihat detail lagu tertentu, dan menghitung
 * rata-rata durasi lagu dalam playlist.
 */
public class Member extends User {

    /*
     * Array playlist digunakan untuk mengakses kumpulan
     * objek Lagu yang sama dengan Admin.
     */
    private Lagu[] playlist;

    /*
     * Constructor Member.
     *
     * super(nama) digunakan untuk memanggil constructor
     * dari parent class User.
     */
    public Member(String nama, Lagu[] playlist) {
        super(nama);
        this.playlist = playlist;
    }

    /*
     * Override method tampilkanAkses() dari class User.
     *
     * Implementasi method ini berbeda dengan Admin.
     */
    @Override
    public void tampilkanAkses() {
        System.out.println(
                "Member " + getNama()
                + " dapat melihat dan mencari lagu dalam playlist."
        );
    }

    /*
     * Method lihatPlaylist() digunakan Member untuk
     * melihat seluruh lagu yang tersedia.
     */
    public void lihatPlaylist() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           DAFTAR LAGU PLAYLIST");
        System.out.println("==========================================");

        boolean adaLagu = false;

        /*
         * Menelusuri seluruh isi array playlist.
         */
        for (int i = 0; i < playlist.length; i++) {

            // Mengecek apakah posisi array berisi objek Lagu
            if (playlist[i] != null) {

                /*
                 * Menampilkan nomor, judul, artis,
                 * dan durasi lagu.
                 */
                System.out.println(
                        (i + 1) + ". "
                        + playlist[i].getJudul()
                        + " - "
                        + playlist[i].getArtis()
                        + " ("
                        + String.format(
                                "%.2f",
                                playlist[i].getDurasi()
                        )
                        + " menit)"
                );

                adaLagu = true;
            }
        }

        /*
         * Jika tidak terdapat lagu dalam playlist.
         */
        if (!adaLagu) {
            System.out.println("Playlist masih kosong.");
        }
    }

    /*
     * Method cariLagu() digunakan Member untuk mencari
     * lagu berdasarkan judul.
     */
    public void cariLagu(String judul) {

        boolean ditemukan = false;

        /*
         * Menelusuri array untuk mencari judul lagu.
         */
        for (int i = 0; i < playlist.length; i++) {

            /*
             * Pencarian dilakukan dengan membandingkan
             * judul yang dimasukkan dengan judul lagu.
             *
             * equalsIgnoreCase() membuat pencarian tidak
             * membedakan huruf besar dan huruf kecil.
             */
            if (playlist[i] != null
                    && playlist[i].getJudul()
                            .equalsIgnoreCase(judul)) {

                System.out.println();
                System.out.println("Lagu ditemukan.");
                System.out.println("------------------------------------------");

                // Menampilkan informasi lengkap lagu
                playlist[i].tampilkanInfo();

                ditemukan = true;

                // Menghentikan pencarian setelah lagu ditemukan
                break;
            }
        }

        /*
         * Menampilkan pesan apabila lagu tidak ditemukan.
         */
        if (!ditemukan) {

            System.out.println();
            System.out.println(
                    "Lagu dengan judul \""
                    + judul
                    + "\" tidak ditemukan."
            );
        }
    }

    /*
     * Method lihatDetailLagu() digunakan Member untuk
     * melihat informasi lengkap dari lagu tertentu.
     */
    public void lihatDetailLagu(String judul) {

        boolean ditemukan = false;

        /*
         * Menelusuri array untuk mencari lagu berdasarkan judul.
         */
        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null
                    && playlist[i].getJudul()
                            .equalsIgnoreCase(judul)) {

                System.out.println();
                System.out.println("==========================================");
                System.out.println("              DETAIL LAGU");
                System.out.println("==========================================");

                // Menampilkan informasi lengkap lagu
                playlist[i].tampilkanInfo();

                ditemukan = true;

                // Menghentikan pencarian
                break;
            }
        }

        /*
         * Menampilkan pesan jika lagu tidak ditemukan.
         */
        if (!ditemukan) {

            System.out.println();
            System.out.println(
                    "Lagu dengan judul \""
                    + judul
                    + "\" tidak ditemukan."
            );
        }
    }

    /*
     * Method hitungRataRataDurasi() digunakan untuk
     * menghitung rata-rata durasi seluruh lagu.
     */
    public void hitungRataRataDurasi() {

        double totalDurasi = 0;
        int jumlahLagu = 0;

        /*
         * Menelusuri seluruh array playlist.
         */
        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null) {

                // Menambahkan durasi lagu ke total durasi
                totalDurasi += playlist[i].getDurasi();

                // Menambah jumlah lagu
                jumlahLagu++;
            }
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         RATA-RATA DURASI LAGU");
        System.out.println("==========================================");

        /*
         * Mengecek apakah playlist kosong sebelum
         * melakukan pembagian.
         */
        if (jumlahLagu == 0) {

            System.out.println("Playlist masih kosong.");

        } else {

            // Menghitung rata-rata durasi
            double rataRata = totalDurasi / jumlahLagu;

            System.out.printf(
                    "Jumlah lagu    : %d%n",
                    jumlahLagu
            );

            System.out.printf(
                    "Total durasi   : %.2f menit%n",
                    totalDurasi
            );

            System.out.printf(
                    "Rata-rata      : %.2f menit%n",
                    rataRata
            );
        }
    }
}