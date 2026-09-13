package playlistoop;
/*
 * Class User merupakan parent class untuk Admin dan Member.
 *
 * Class ini menjadi dasar penerapan inheritance.
 */
public class User {

    /*
     * Atribut nama dibuat private sebagai penerapan
     * konsep enkapsulasi.
     */
    private String nama;

    /*
     * Constructor untuk membuat objek User.
     */
    public User(String nama) {
        this.nama = nama;
    }

    /*
     * Getter digunakan untuk mengambil nilai nama.
     */
    public String getNama() {
        return nama;
    }

    /*
     * Setter digunakan untuk mengubah nilai nama.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /*
     * Method tampilkanAkses() merupakan method yang akan
     * dioverride oleh class Admin dan Member.
     *
     * Perbedaan implementasi method ini pada subclass
     * digunakan untuk menunjukkan konsep polymorphism.
     */
    public void tampilkanAkses() {
        System.out.println("Pengguna memiliki akses umum.");
    }
}