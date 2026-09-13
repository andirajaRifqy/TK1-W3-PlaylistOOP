# TK1 Week 3 - PlaylistOOP

Tugas Kelompok ke-1 mata kuliah **Data Structures and Algorithm Analysis**.
Program Java ini merupakan sistem manajemen playlist musik sederhana yang menerapkan **array** dan konsep **Object-Oriented Programming (OOP)**: encapsulation, inheritance, dan polymorphism.

## Anggota Kelompok
1. DYNOTAMA PARAYU INDRAWASTRA - 2902824861
2. RIZKY HAIDAR ZAKY - 2902825744
3. M. RIFQY ANDIRAJA DJAMIL - 2902825302
4. GOFAR CHAIRULLOH ANNAM - 2902853363

## Struktur Program

```text
src/
└── playlistoop/
    ├── Lagu.java
    ├── User.java
    ├── Admin.java
    ├── Member.java
    └── PlaylistOOP.java
```

## Fitur
- Admin menambahkan lagu ke playlist.
- Admin melihat daftar lagu.
- Member melihat daftar lagu.
- Member mencari lagu berdasarkan judul.
- Member melihat detail lagu.
- Member menghitung rata-rata durasi playlist.
- Lagu disimpan dalam array `Lagu[]` dengan kapasitas 100.
- `Admin` dan `Member` mewarisi `User`.
- `tampilkanAkses()` di-override untuk menunjukkan runtime polymorphism.

## Menjalankan di GitHub Codespaces

Buka repository melalui **Code > Codespaces > Create codespace on main**.

Di Terminal jalankan:

```bash
mkdir -p out
javac -d out src/playlistoop/*.java
java -cp out playlistoop.PlaylistOOP
```

## Skenario Pengujian Laporan

Pengujian laporan menggunakan satu lagu:
- Judul: `Laskar Pelangi`
- Artis: `Nidji`
- Durasi: `4.10` menit

Urutan pengujian manual:
1. Login sebagai Admin.
2. Tambah lagu `Laskar Pelangi`, `Nidji`, `4.10`.
3. Lihat daftar playlist.
4. Kembali ke menu utama.
5. Login sebagai Member.
6. Lihat daftar lagu.
7. Cari `Laskar Pelangi`.
8. Lihat detail `Laskar Pelangi`.
9. Hitung rata-rata durasi.
10. Kembali ke menu utama dan keluar.

### Pengujian otomatis dengan input yang sama

File `test-input.txt` sudah berisi urutan input di atas. Jalankan:

```bash
java -cp out playlistoop.PlaylistOOP < test-input.txt
```

Hasil yang diharapkan mencakup:
- Lagu berhasil ditambahkan: `Laskar Pelangi`.
- Lagu muncul pada daftar playlist.
- Pencarian Member menemukan `Laskar Pelangi`.
- Detail menunjukkan `Nidji` dan durasi `4.10 menit`.
- Jumlah lagu: `1`.
- Total durasi: `4.10 menit`.
- Rata-rata: `4.10 menit`.

## Bukti Eksekusi

Tambahkan screenshot hasil run pada folder `evidence/` dan cantumkan link repository ini pada laporan kelompok.
