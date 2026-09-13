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
 * Class PlaylistOOP merupakan class utama yang digunakan
 * untuk menjalankan program manajemen playlist.
 */
public class PlaylistOOP {

    /*
     * Method main() merupakan titik awal program.
     * Program membuat array Lagu untuk menyimpan objek lagu,
     * kemudian membuat objek Admin dan Member yang menggunakan
     * array playlist yang sama.
     */
    public static void main(String[] args) {

        // Membuat Scanner untuk menerima input dari pengguna
        Scanner input = new Scanner(System.in);

        // Membuat array Lagu dengan kapasitas maksimal 100 lagu
        Lagu[] playlist = new Lagu[100];

        // Membuat objek Admin dan Member
        Admin admin = new Admin("Admin Playlist", playlist);
        Member member = new Member("Member Playlist", playlist);

        /*
         * Membuat referensi bertipe User untuk menunjukkan
         * penerapan polymorphism.
         */
        User userAdmin = admin;
        User userMember = member;

        // Menampilkan informasi hak akses Admin dan Member
        System.out.println("==========================================");
        System.out.println("       SISTEM MANAJEMEN PLAYLIST");
        System.out.println("==========================================");
        System.out.println();

        userAdmin.tampilkanAkses();
        userMember.tampilkanAkses();

        boolean berjalan = true;

        /*
         * Perulangan utama digunakan agar program terus berjalan
         * sampai pengguna memilih menu Keluar.
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
                    // Menghentikan perulangan dan keluar dari program
                    berjalan = false;

                    System.out.println();
                    System.out.println("Program selesai.");
                    System.out.println("Terima kasih.");
                    break;

                default:
                    // Menampilkan pesan jika pilihan menu tidak tersedia
                    System.out.println();
                    System.out.println("Menu tidak tersedia.");
                    System.out.println("Silakan pilih menu 1, 2, atau 3.");
            }
        }

        // Menutup Scanner setelah program selesai
        input.close();
    }

    /*
     * Method menuAdmin() digunakan untuk menampilkan menu
     * dan menjalankan fungsi-fungsi yang dapat dilakukan Admin.
     */
    public static void menuAdmin(Admin admin, Scanner input) {

        boolean kembali = false;

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
                     * Perulangan digunakan untuk memastikan
                     * durasi yang dimasukkan berupa angka.
                     */
                    while (!durasiValid) {

                        System.out.print("Masukkan durasi (menit): ");

                        try {

                            durasi = Double.parseDouble(input.nextLine());

                            if (durasi > 0) {

                                durasiValid = true;

                            } else {

                                System.out.println(
                                        "Durasi harus lebih dari 0."
                                );
                            }

                        } catch (NumberFormatException e) {

                            System.out.println(
                                    "Input durasi harus berupa angka."
                            );
                        }
                    }

                    /*
                     * Membuat objek Lagu berdasarkan data yang
                     * dimasukkan oleh Admin.
                     */
                    Lagu laguBaru = new Lagu(judul, artis, durasi);

                    // Menambahkan objek Lagu ke dalam array playlist
                    admin.tambahLagu(laguBaru);

                    break;

                case "2":

                    // Admin melihat seluruh lagu dalam playlist
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
     * Method menuMember() digunakan untuk menampilkan menu
     * dan menjalankan fungsi-fungsi yang dapat dilakukan Member.
     */
    public static void menuMember(Member member, Scanner input) {

        boolean kembali = false;

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

                    // Member melihat seluruh lagu dalam playlist
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

                    // Memanggil method pencarian lagu milik Member
                    member.cariLagu(judulCari);

                    break;

                case "3":

                    System.out.println();
                    System.out.println("==========================================");
                    System.out.println("            DETAIL LAGU");
                    System.out.println("==========================================");

                    // Meminta judul lagu untuk melihat detailnya
                    System.out.print("Masukkan judul lagu: ");
                    String judulDetail = input.nextLine();

                    // Menampilkan informasi lengkap lagu
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