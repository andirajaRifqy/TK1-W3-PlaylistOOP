package playlistoop;

/*
 * Class User merupakan parent class untuk Admin dan Member.
 * Class ini digunakan untuk menyimpan data umum pengguna
 * dan menjadi dasar penerapan inheritance serta polymorphism.
 */
public class User {

    protected String nama;

    // Constructor untuk membuat objek User
    public User(String nama) {
        this.nama = nama;
    }

    /*
     * Method tampilkanAkses() akan dioverride oleh class
     * Admin dan Member dengan hak akses yang berbeda.
     * Hal ini merupakan penerapan polymorphism.
     */
    public void tampilkanAkses() {
        System.out.println("Pengguna memiliki akses umum.");
    }

    // Getter untuk mengambil nama pengguna
    public String getNama() {
        return nama;
    }

    // Setter untuk mengubah nama pengguna
    public void setNama(String nama) {
        this.nama = nama;
    }
}