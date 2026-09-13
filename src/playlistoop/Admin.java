package playlistoop;

/*
 * Class Admin merupakan child class dari User.
 * Admin memiliki hak untuk menambahkan lagu dan
 * melihat daftar lagu dalam playlist.
 */
public class Admin extends User {

    private Lagu[] playlist;

    // Constructor untuk membuat objek Admin
    public Admin(String nama, Lagu[] playlist) {
        super(nama);
        this.playlist = playlist;
    }

    /*
     * Method ini melakukan override terhadap method
     * tampilkanAkses() dari class User.
     * Implementasi ini menunjukkan polymorphism.
     */
    @Override
    public void tampilkanAkses() {
        System.out.println("Admin " + nama
                + " dapat menambahkan lagu dan melihat daftar playlist.");
    }

    /*
     * Method tambahLagu() digunakan Admin untuk
     * menambahkan objek Lagu ke dalam array playlist.
     */
    public void tambahLagu(Lagu lagu) {

        for (int i = 0; i < playlist.length; i++) {

            // Mencari posisi array yang masih kosong
            if (playlist[i] == null) {
                playlist[i] = lagu;

                System.out.println();
                System.out.println("Lagu berhasil ditambahkan.");
                System.out.println("Judul : " + lagu.getJudul());

                return;
            }
        }

        // Ditampilkan jika seluruh array sudah terisi
        System.out.println();
        System.out.println("Playlist penuh. Lagu tidak dapat ditambahkan.");
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

        for (int i = 0; i < playlist.length; i++) {

            if (playlist[i] != null) {

                System.out.println();
                System.out.println("Lagu ke-" + (i + 1));
                System.out.println("------------------------------------------");

                playlist[i].tampilkanInfo();

                adaLagu = true;
            }
        }

        // Jika belum ada lagu yang tersimpan
        if (!adaLagu) {
            System.out.println("Playlist masih kosong.");
        }
    }
}