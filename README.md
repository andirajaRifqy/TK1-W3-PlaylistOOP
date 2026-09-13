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

## Pengujian Laporan

Pengujian laporan menggunakan satu lagu:
- Judul: `33x`
- Artis: `Perunggu`
- Durasi: `7.14` menit

Urutan pengujian manual:
1. Login sebagai Admin.
2. Tambah lagu `33x`, `Perunggu`, `7.14`.
3. Lihat daftar playlist.
4. Kembali ke menu utama.
5. Login sebagai Member.
6. Lihat daftar lagu.
7. Cari `33x`.
8. Lihat detail `33x`.
9. Hitung rata-rata durasi.
10. Kembali ke menu utama dan keluar.

Hasil yang diharapkan mencakup:
- Lagu berhasil ditambahkan: `33x`.
- Lagu muncul pada daftar playlist.
- Pencarian Member menemukan `33x`.
- Detail menunjukkan `Perunggu` dan durasi `7.14 menit`.
- Jumlah lagu: `1`.
- Total durasi: `7.14 menit`.
- Rata-rata: `7.14 menit`.

## Bukti Eksekusi

Screenshot hasil run ada pada folder `evidence/` 
