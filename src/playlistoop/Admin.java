package playlistoop;

/*
 * Class Admin merupakan child class dari User.
 *
 * Admin bertugas untuk menambahkan lagu ke dalam sistem
 * dan melihat daftar lagu yang tersimpan.
 */
public class Admin extends User {

    /*
     * Array playlist digunakan untuk menyimpan kumpulan
     * objek Lagu.
     */
    private Lagu[] playlist;

    /*
     * Constructor Admin.
     *
     * super(nama) digunakan untuk memanggil constructor
     * dari parent class User.
     */
    public Admin(String nama, Lagu[] playlist) {
        super(nama);
        this.playlist = playlist;
    }

    /*
     * Override method tampilkanAkses() dari class User.
     *
     * Method ini memiliki implementasi yang berbeda
     * dari method pada parent class.
     */
    @Override
    public void tampilkanAkses() {
        System.out.println(
                "Admin " + getNama()
                + " dapat menambahkan lagu dan melihat daftar playlist."
        );
    }

    /*
     * Method tambahLagu() digunakan Admin untuk
     * menambahkan objek Lagu ke dalam array playlist.
     */
    public void tambahLagu(Lagu lagu) {

        /*
         * Melakukan perulangan untuk mencari posisi array
         * yang masih kosong.
         */
        for (int i = 0; i < playlist.length; i++) {

            // Mengecek apakah posisi array masih kosong
            if (playlist[i] == null) {

                // Menyimpan objek Lagu ke dalam array
                playlist[i] = lagu;

                System.out.println();
                System.out.println("Lagu berhasil ditambahkan.");
                System.out.println("Judul : " + lagu.getJudul());

                // Menghentikan method setelah lagu berhasil ditambahkan
                return;
            }
        }

        /*
         * Pesan ditampilkan apabila seluruh posisi
         * array sudah terisi.
         */
        System.out.println();
        System.out.println(
                "Playlist penuh. Lagu tidak dapat ditambahkan."
        );
    }

    /*
     * Method lihatPlaylist() digunakan Admin untuk
     * melihat seluruh lagu yang tersimpan dalam array.
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

            // Mengecek apakah terdapat objek Lagu pada posisi tersebut
            if (playlist[i] != null) {

                System.out.println();
                System.out.println("Lagu ke-" + (i + 1));
                System.out.println("------------------------------------------");

                // Menampilkan informasi lengkap lagu
                playlist[i].tampilkanInfo();

                adaLagu = true;
            }
        }

        /*
         * Jika tidak terdapat lagu dalam array,
         * playlist dinyatakan masih kosong.
         */
        if (!adaLagu) {
            System.out.println("Playlist masih kosong.");
        }
    }
}