package playlistoop;

/*
 * Class Lagu digunakan untuk menyimpan data sebuah lagu.
 * Class ini menerapkan konsep enkapsulasi dengan membuat
 * atribut bersifat private dan mengaksesnya melalui getter
 * dan setter.
 */
public class Lagu {

    private String judul;
    private String artis;
    private double durasi;

    // Constructor untuk membuat objek Lagu
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // Getter dan setter untuk atribut judul
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter dan setter untuk atribut artis
    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    // Getter dan setter untuk atribut durasi
    public double getDurasi() {
        return durasi;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    // Menampilkan informasi lengkap sebuah lagu
    public void tampilkanInfo() {
        System.out.println("Judul  : " + judul);
        System.out.println("Artis  : " + artis);
        System.out.printf("Durasi : %.2f menit%n", durasi);
    }
}