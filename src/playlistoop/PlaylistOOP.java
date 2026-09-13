package playlistoop;

import java.util.Scanner;

/*
 * ============================================================
 * TUGAS KELOMPOK 1 - WEEK 3
 * INTRODUCTION TO OOP & DATA STRUCTURES
 *
 * Nama Anggota:
 * 1. DYNOTAMA PARAYU INDRAWASTRA - 2902824861
 * 2. RIZKY HAIDAR ZAKY - 2902825744
 * 3. M. RIFQY ANDIRAJA DJAMIL - 2902825302
 * 4. GOFAR CHAIRULLOH ANNAM - 2902853363
 *
 * Program : Sistem Manajemen Playlist
 * ============================================================
 */

/*
 * Class PlaylistOOP merupakan class utama untuk menjalankan
 * sistem manajemen playlist musik.
 */
public class PlaylistOOP {

    /*
     * Method main() merupakan titik awal program.
     */
    public static void main(String[] args) {

        /*
         * Membuat Scanner untuk menerima input
         * dari pengguna melalui keyboard.
         */
        Scanner input = new Scanner(System.in);

        /*
         * Membuat array Lagu dengan kapasitas 100 objek.
         *
         * Array ini digunakan untuk menyimpan kumpulan
         * objek Lagu sesuai instruksi tugas.
         */
        Lagu[] playlist = new Lagu[100];

        /*
         * Membuat objek Admin dan Member.
         *
         * Keduanya menggunakan array playlist yang sama.
         * Dengan demikian, lagu yang ditambahkan oleh Admin
         * dapat dilihat dan digunakan oleh Member.
         */
        Admin admin = new Admin(
                "Admin Playlist",
                playlist
        );

        Member member = new Member(
                "Member Playlist",
                playlist
        );

        /*
         * Membuat referensi bertipe User yang menunjuk
         * kepada objek Admin dan Member.
         *
         * Bagian ini digunakan untuk menunjukkan
         * penerapan polymorphism.
         */
        User userAdmin = admin;
        User userMember = member;

        /*
         * Menampilkan judul utama program.
         */
        System.out.println("==========================================");
        System.out.println("       SISTEM MANAJEMEN PLAYLIST");
        System.out.println("==========================================");
        System.out.println();

        /*
         * Memanggil tampilkanAkses() melalui referensi User.
         *
         * Java akan menjalankan method sesuai objek sebenarnya,
         * yaitu Admin dan Member.
         */
        userAdmin.tampilkanAkses();
        userMember.tampilkanAkses();

        boolean berjalan = true;

        /*
         * Perulangan utama digunakan agar program dapat
         * terus digunakan sampai pengguna memilih menu Keluar.
         */
        while (berjalan) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("              MENU UTAMA");
            System.out.println("==========================================");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Member");
            System.out.println("3. Keluar");
            System.out.println("==========================================");
            System.out.print("Pilih menu: ");

            String pilihan = input.nextLine();

            switch (pilihan) {

                case "1":

                    // Membuka menu khusus Admin
                    menuAdmin(admin, input);
                    break;

                case "2":

                    // Membuka menu khusus Member
                    menuMember(member, input);
                    break;

                case "3":

                    // Mengubah kondisi agar perulangan berhenti
                    berjalan = false;

                    System.out.println();
                    System.out.println("Program selesai.");
                    System.out.println("Terima kasih.");
                    break;

                default:

                    // Menampilkan pesan jika menu tidak tersedia
                    System.out.println();
                    System.out.println("Menu tidak tersedia.");
                    System.out.println(
                            "Silakan pilih menu 1, 2, atau 3."
                    );
            }
        }

        /*
         * Menutup Scanner setelah program selesai.
         */
        input.close();
    }

    /*
     * Method menuAdmin() digunakan untuk menjalankan
     * fungsi-fungsi yang dapat dilakukan oleh Admin.
     */
    public static void menuAdmin(
            Admin admin,
            Scanner input) {

        boolean kembali = false;

        /*
         * Perulangan digunakan agar Admin dapat melakukan
         * beberapa aktivitas sebelum kembali ke menu utama.
         */
        while (!kembali) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("              MENU ADMIN");
            System.out.println("==========================================");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Daftar Lagu");
            System.out.println("3. Kembali ke Menu Utama");
            System.out.println("==========================================");
            System.out.print("Pilih menu: ");

            String pilihan = input.nextLine();

            switch (pilihan) {

                case "1":

                    System.out.println();
                    System.out.println("==========================================");
                    System.out.println("              TAMBAH LAGU");
                    System.out.println("==========================================");

                    // Meminta Admin memasukkan judul lagu
                    System.out.print("Masukkan judul lagu : ");
                    String judul = input.nextLine();

                    // Meminta Admin memasukkan nama artis
                    System.out.print("Masukkan nama artis  : ");
                    String artis = input.nextLine();

                    double durasi = 0;
                    boolean durasiValid = false;

                    /*
                     * Memastikan durasi yang dimasukkan berupa angka
                     * dan memiliki nilai lebih dari nol.
                     */
                    while (!durasiValid) {

                        System.out.print(
                                "Masukkan durasi (menit): "
                        );

                        try {

                            /*
                             * Mengubah input String menjadi double.
                             */
                            durasi = Double.parseDouble(
                                    input.nextLine()
                            );

                            if (durasi > 0) {

                                durasiValid = true;

                            } else {

                                System.out.println(
                                        "Durasi harus lebih dari 0."
                                );
                            }

                        } catch (NumberFormatException e) {

                            /*
                             * Menangani kesalahan apabila input
                             * durasi bukan berupa angka.
                             */
                            System.out.println(
                                    "Input durasi harus berupa angka."
                            );
                        }
                    }

                    /*
                     * Membuat objek Lagu berdasarkan data
                     * yang dimasukkan Admin.
                     */
                    Lagu laguBaru = new Lagu(
                            judul,
                            artis,
                            durasi
                    );

                    /*
                     * Mengirim objek Lagu ke method tambahLagu()
                     * untuk disimpan ke dalam array playlist.
                     */
                    admin.tambahLagu(laguBaru);

                    break;

                case "2":

                    // Admin melihat daftar lagu yang tersimpan
                    admin.lihatPlaylist();

                    break;

                case "3":

                    // Kembali ke menu utama
                    kembali = true;
                    break;

                default:

                    // Menampilkan pesan jika pilihan tidak tersedia
                    System.out.println();
                    System.out.println("Menu tidak tersedia.");
            }
        }
    }

    /*
     * Method menuMember() digunakan untuk menjalankan
     * fungsi-fungsi yang dapat dilakukan oleh Member.
     */
    public static void menuMember(
            Member member,
            Scanner input) {

        boolean kembali = false;

        /*
         * Perulangan digunakan agar Member dapat menggunakan
         * beberapa fitur sebelum kembali ke menu utama.
         */
        while (!kembali) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("             MENU MEMBER");
            System.out.println("==========================================");
            System.out.println("1. Lihat Daftar Lagu");
            System.out.println("2. Cari Lagu");
            System.out.println("3. Lihat Detail Lagu");
            System.out.println("4. Hitung Rata-rata Durasi");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.println("==========================================");
            System.out.print("Pilih menu: ");

            String pilihan = input.nextLine();

            switch (pilihan) {

                case "1":

                    // Member melihat seluruh daftar lagu
                    member.lihatPlaylist();

                    break;

                case "2":

                    System.out.println();
                    System.out.println("==========================================");
                    System.out.println("               CARI LAGU");
                    System.out.println("==========================================");

                    // Meminta judul lagu yang ingin dicari
                    System.out.print("Masukkan judul lagu: ");
                    String judulCari = input.nextLine();

                    // Mencari lagu berdasarkan judul
                    member.cariLagu(judulCari);

                    break;

                case "3":

                    System.out.println();
                    System.out.println("==========================================");
                    System.out.println("            DETAIL LAGU");
                    System.out.println("==========================================");

                    // Meminta judul lagu yang ingin dilihat detailnya
                    System.out.print("Masukkan judul lagu: ");
                    String judulDetail = input.nextLine();

                    // Menampilkan detail lagu
                    member.lihatDetailLagu(judulDetail);

                    break;

                case "4":

                    // Menghitung rata-rata durasi seluruh lagu
                    member.hitungRataRataDurasi();

                    break;

                case "5":

                    // Kembali ke menu utama
                    kembali = true;
                    break;

                default:

                    // Menampilkan pesan jika pilihan tidak tersedia
                    System.out.println();
                    System.out.println("Menu tidak tersedia.");
            }
        }
    }
}