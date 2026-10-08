# Minpro-3-PBO-SistemPengelolaanPaketEkspedisi
MUHAMMAD ARHAM ANUGRAH - 2509116044

---

## Deskripsi Singkat Program

Sistem Pengelolaan Paket Ekspedisi merupakan program berbasis Java (CLI) yang dibuat untuk membantu pencatatan dan pengelolaan data paket pada layanan pengiriman. Program ini dapat mengelola paket dari beberapa jasa ekspedisi sekaligus, yaitu **J&T**, **JNE**, dan **SiCepat**, sehingga pengguna tidak perlu membuat sistem yang berbeda untuk setiap perusahaan ekspedisi.

Setiap paket menyimpan informasi nomor resi, nama pengirim, tanggal masuk, status, berat paket, serta data penerima, ekspedisi (beserta jenis layanannya), dan kurir. Program menyediakan fitur CRUD (Create, Read, Update, Delete): menambah paket baru, menampilkan semua paket, mencari paket berdasarkan ID atau nomor resi, mengubah status/data penerima/data kurir, dan menghapus paket.

Pada Minpro 3 ini program dikembangkan dengan menambahkan **abstraction** (abstract class dan abstract method), **polymorphism** (overriding dan overloading), serta **interface** sebagai nilai tambah. Selain itu program kini dapat menghitung **biaya kirim** setiap paket, di mana rumus ongkir berbeda untuk setiap ekspedisi dan layanan (nilai tarif pada program adalah nilai contoh/fiktif).

---

## Struktur Package

Program menerapkan struktur **MVC** yang dibagi ke dalam empat package:

```
Minpro3/
└── src/main/java/
    ├── main/
    │   └── Minpro3.java                  -> entry point (main), membuat data dummy dan menjalankan view
    ├── model/
    │   ├── Person.java                   -> abstract class (induk Kurir, Penerima, PengelolaPaket)
    │   ├── Kurir.java
    │   ├── Penerima.java
    │   ├── PengelolaPaket.java           -> implements PenyimpananPaket
    │   ├── PenyimpananPaket.java         -> INTERFACE (nilai tambah)
    │   ├── Ekspedisi.java                -> abstract class (induk JNE, JNT, SiCepat)
    │   ├── JNE.java
    │   ├── JNT.java
    │   ├── SiCepat.java
    │   └── Paket.java
    ├── controller/
    │   └── ManajemenPaketController.java -> penghubung view dan model
    └── view/
        └── ManajemenPaketView.java       -> input/output dan menu program
```

Package **main** berisi `Minpro3.java` sebagai titik awal program. Package **model** berisi seluruh class data dan logika bisnis (termasuk abstract class dan interface). Package **controller** berisi `ManajemenPaketController` yang meneruskan permintaan dari view ke model. Package **view** berisi `ManajemenPaketView` yang menangani seluruh tampilan menu, input, validasi input, dan output ke pengguna.

<img width="447" height="418" alt="image" src="https://github.com/user-attachments/assets/ca30f10c-d8d2-4e1b-9674-4505c110f424" />

---

## Alur Program

**1.** Program dijalankan melalui `Minpro3.java` (package `main`). Di sini dibuat objek `PengelolaPaket`, satu data dummy paket (ekspedisi JNE layanan REG), lalu `ManajemenPaketController` dan `ManajemenPaketView`. Program kemudian masuk ke menu utama yang berisi 6 pilihan: tambah paket, tampilkan semua paket, cari paket, update paket, hapus paket, dan keluar.

<img width="1077" height="590" alt="image" src="https://github.com/user-attachments/assets/08360d48-7e9b-4a59-870e-186b138c6dab" />


**2.** Menu **1 - Tambah Paket (Create)**. Pengguna mengisi ID paket, nomor resi, nama pengirim, dan tanggal masuk (format `DD-MM-YYYY`). Setelah itu mengisi data penerima (ID, nama, alamat, kode pos, nomor HP), lalu data ekspedisi (ID ekspedisi, memilih J&T/JNE/SiCepat, dan memilih jenis layanan sesuai ekspedisi). Selanjutnya pengguna mengisi berat paket (kg), data kurir (ID, nama, nomor HP, jenis kendaraan), dan memilih status paket.

<img width="870" height="645" alt="image" src="https://github.com/user-attachments/assets/fcf833d0-c8e0-48d0-9115-628be94785c2" />

<img width="1108" height="827" alt="image" src="https://github.com/user-attachments/assets/e02b72cf-2403-4b65-8b51-4a9654ed2b1a" />

**3.** Menu **2 - Tampilkan Semua Paket (Read)**. Program menampilkan seluruh paket beserta ekspedisi, layanan, berat, **biaya kirim**, serta informasi penerima dan kurir. Biaya kirim dihitung otomatis sesuai rumus ekspedisi yang dipakai paket.

<img width="1097" height="683" alt="image" src="https://github.com/user-attachments/assets/e1a5afa5-8b38-4e24-b7a3-336d05ffdebb" />

**4.** Menu **3 - Cari Paket (Read)**. Pengguna memilih pencarian berdasarkan ID paket atau nomor resi. Jika data ditemukan, program menampilkan detail paket; jika tidak, tampil pesan "Paket tidak ditemukan!".

<img width="1052" height="487" alt="image" src="https://github.com/user-attachments/assets/f5584dea-6fd5-476a-8171-6daeacd87852" />

<img width="940" height="489" alt="image" src="https://github.com/user-attachments/assets/c556bf68-0c3d-4665-a94b-86b494c0fe29" />

**5.** Menu **4 - Update Paket (Update)**. Pengguna memasukkan nomor resi, lalu memilih data yang diubah: status, data penerima, atau data kurir. Pengguna dapat memilih keluar jika tidak jadi mengubah data.

<img width="1046" height="729" alt="image" src="https://github.com/user-attachments/assets/a8e0f310-b0c0-4f91-b791-5733e45e405f" />

**6.** Menu **5 - Hapus Paket (Delete)**. Pengguna memasukkan ID paket yang ingin dihapus.

<img width="868" height="401" alt="image" src="https://github.com/user-attachments/assets/5604896d-4c5c-4b99-8d22-7f24a6334019" />

**7.** Menu **6 - Keluar**. Program menampilkan "Program selesai." dan berhenti.

<img width="884" height="332" alt="image" src="https://github.com/user-attachments/assets/338bdb16-b4e7-45d6-aedd-e91272241f29" />

**Validasi input.** Pilihan menu dan input angka (ID, pilihan) divalidasi agar hanya menerima angka. Nomor HP hanya menerima angka, tanggal masuk wajib berformat `DD-MM-YYYY` dan harus berupa tanggal yang valid, dan berat paket wajib berupa angka lebih dari 0. Pilihan menu di luar 1-6 menampilkan pesan "Pilihan menu tidak tersedia!".

---


## Penerapan Encapsulation dan Inheritance

### Encapsulation

Seluruh atribut pada class model dibuat `private` dan hanya dapat diakses melalui getter dan setter yang bersifat `public`. Contohnya pada `Person` (`id`, `nama`, `nomorHp`), `Paket` (`idPaket`, `noResi`, `status`, `beratKg`, dan lainnya), `Ekspedisi`, `Kurir` (`jenisKendaraan`), dan `Penerima` (`alamat`, `kodePos`). Dengan cara ini data tidak dapat diubah sembarangan dari luar class, dan hanya data yang memang boleh berubah (misalnya status paket) yang disediakan setter-nya. Pada `PengelolaPaket`, daftar paket juga bersifat `private final` sehingga hanya bisa dikelola melalui method `tambahPaket`, `cariPaket`, dan `hapusPaket`.

<img width="830" height="792" alt="image" src="https://github.com/user-attachments/assets/6327615c-c1e2-4b81-b6b4-59aed6b4f00f" />

<img width="444" height="186" alt="image" src="https://github.com/user-attachments/assets/3f368f4a-07b2-4b88-8d87-7339317196ee" />

### Inheritance

Pewarisan diterapkan pada dua hierarki.

**Hierarki Person.** `Kurir`, `Penerima`, dan `PengelolaPaket` mewarisi `Person`. Atribut umum (`id`, `nama`, `nomorHp`) cukup ditulis sekali di `Person`, sedangkan atribut khusus ditambahkan di tiap subclass: `jenisKendaraan` pada `Kurir`, `alamat` dan `kodePos` pada `Penerima`, serta `daftarPaket` pada `PengelolaPaket`.

**Hierarki Ekspedisi.** `JNE`, `JNT` (J&T), dan `SiCepat` mewarisi `Ekspedisi` yang menyimpan data umum ekspedisi (`idEkspedisi`, `namaEkspedisi`, `jenisLayanan`). Setiap subclass memanggil constructor induk dengan `super(...)`.

<img width="400" height="45" alt="image" src="https://github.com/user-attachments/assets/beeeef4c-65a1-4308-9fd1-fb0dde127ea0" /> <img width="409" height="73" alt="image" src="https://github.com/user-attachments/assets/7bf0cf97-05b0-4b88-9e9b-86463f52e60a" />

<img width="648" height="72" alt="image" src="https://github.com/user-attachments/assets/0fa1e5f2-6236-44d6-b1e0-e272102de2f4" />

<img width="505" height="52" alt="image" src="https://github.com/user-attachments/assets/a2f26891-2080-4c97-b358-40a2439daf53" /> <img width="512" height="107" alt="image" src="https://github.com/user-attachments/assets/e7961d0d-3a62-46ea-8a30-8df19a2c6536" />

---

## Penerapan Polymorphism dan Abstraction

### Abstraction

Abstraction diterapkan pada dua class dengan **abstract class** dan **abstract method**.

**1. `Person` (abstract class).** `Person` tidak pernah dibuat objeknya secara langsung, yang ada selalu `Kurir`, `Penerima`, atau `PengelolaPaket`. Karena itu `Person` dijadikan abstract class dengan abstract method `getPeran()`. Method ini tidak memiliki isi dan wajib diimplementasikan semua subclass, karena setiap jenis orang pasti memiliki peran, tetapi jawabannya berbeda-beda.

**2. `Ekspedisi` (abstract class).** JNE, J&T, dan SiCepat sama-sama ekspedisi dengan data yang sama, tetapi rumus ongkirnya berbeda. Karena itu `Ekspedisi` memiliki abstract method `hitungOngkir(double beratKg)`, dan rumus sebenarnya diserahkan kepada `JNE`, `JNT`, dan `SiCepat`. Konsekuensinya `Ekspedisi` tidak bisa lagi dibuat objeknya langsung dan harus dibuat sebagai salah satu turunannya (misalnya `new JNE(1, "REG")`).

<img width="612" height="84" alt="image" src="https://github.com/user-attachments/assets/a0683cda-0d09-41fe-bd69-9ea3d51910fa" />

<img width="406" height="65" alt="image" src="https://github.com/user-attachments/assets/469e42ec-a6da-4f99-8529-35060b4343c7" />

<img width="667" height="412" alt="image" src="https://github.com/user-attachments/assets/e9b37e85-694a-435c-96f2-0441ead885de" />

### Polymorphism - Overriding

Overriding terjadi ketika subclass menulis ulang method milik induknya (ditandai `@Override`).

- `getPeran()` pada `Kurir`, `Penerima`, dan `PengelolaPaket` mengimplementasikan abstract method milik `Person` (masing-masing mengembalikan "Kurir", "Penerima", dan "Pengelola Paket").
- `getInfo()` pada `Kurir`, `Penerima`, dan `PengelolaPaket` menimpa `getInfo()` milik `Person`. Setiap subclass memanggil `super.getInfo()` lalu menambahkan data khasnya: kendaraan untuk kurir, alamat dan kode pos untuk penerima, dan total paket untuk pengelola.
- `hitungOngkir(double beratKg)` pada `JNE`, `JNT`, dan `SiCepat` mengimplementasikan abstract method milik `Ekspedisi` dengan tarif per kilogram yang berbeda sesuai jenis layanan (misalnya REG/YES/OKE pada JNE, Cargo/Reguler/Ekonomi pada J&T, dan BEST/REGULAR/HALU pada SiCepat).

<img width="701" height="176" alt="image" src="https://github.com/user-attachments/assets/cdb06681-c963-44ec-813e-865721dc0e81" />

### Polymorphism - Overloading

Overloading terjadi ketika beberapa method memiliki nama yang sama tetapi parameter berbeda dalam satu class.

- `cariPaket(int id)` dan `cariPaket(String resi)` pada `PengelolaPaket` (dan diteruskan pada `ManajemenPaketController`). Java memilih versi yang dipanggil berdasarkan tipe argumen: angka untuk pencarian ID, teks untuk pencarian nomor resi.
- `hitungOngkir(double beratKg)` dan `hitungOngkir(double beratKg, double nilaiBarang)` pada `Ekspedisi`. Versi kedua menambahkan biaya asuransi 0,2% dari nilai barang di atas ongkir dasar.
- Constructor `Paket` memiliki dua versi: versi lengkap dengan parameter `beratKg`, dan versi tanpa berat yang otomatis memakai berat 1 kg.

<img width="524" height="314" alt="image" src="https://github.com/user-attachments/assets/a31cc3ae-521c-4daf-a50a-6f31591ceadf" />


### Polymorphism - Penerapan saat program berjalan

Polymorphism terlihat nyata di dua tempat.

**Biaya kirim.** Pada `Paket`, atribut `ekspedisi` bertipe `Ekspedisi`, tetapi objek aslinya bisa berupa `JNE`, `JNT`, atau `SiCepat`. Method `hitungBiayaKirim()` cukup memanggil `ekspedisi.hitungOngkir(beratKg)`, dan Java memilih rumus yang sesuai dengan objek aslinya saat program berjalan, tanpa percabangan `if` pada class `Paket`. Jika kelak ada ekspedisi baru, cukup dibuat satu class baru turunan `Ekspedisi` tanpa mengubah class `Paket`.

**Informasi penerima dan kurir.** Pada `ManajemenPaketView.tampilkanDetailPaket()`, penerima dan kurir dimasukkan ke dalam satu array bertipe `Person`, kemudian `getInfo()` dipanggil dalam satu perulangan. Hasilnya berbeda untuk setiap elemen karena Java menjalankan `getInfo()` milik `Penerima` dan `Kurir` sesuai objek aslinya.

<img width="431" height="71" alt="image" src="https://github.com/user-attachments/assets/66a27af3-935a-4da8-b18a-a21cc66dac17" />

---

## Penerapan Nilai Tambah: Interface

Nilai tambah yang diterapkan pada project ini adalah **interface**, yaitu `PenyimpananPaket` pada package `model`.

Sebelumnya controller bergantung langsung pada class `PengelolaPaket` yang menyimpan data dalam `ArrayList`. Dengan interface, controller hanya mengenal kontrak "sesuatu yang dapat menambah, mencari, dan menghapus paket", tanpa peduli bagaimana datanya disimpan. Jika kelak penyimpanan diganti (misalnya ke file atau database), cukup dibuat class baru yang mengimplementasikan `PenyimpananPaket` tanpa mengubah controller dan view. Pendekatan ini disebut *loose coupling*.

`PengelolaPaket` sudah mewarisi `Person`, sedangkan Java tidak mengizinkan pewarisan dari dua class. Interface memungkinkan `PengelolaPaket` tetap mewarisi `Person` sekaligus memenuhi kontrak penyimpanan paket. Method `cariPaket` pada interface juga merupakan overloading (parameter `int` dan `String`).

<img width="750" height="410" alt="image" src="https://github.com/user-attachments/assets/89d04941-0b8a-4530-a4dc-11b9359ab5b4" />

<img width="779" height="79" alt="image" src="https://github.com/user-attachments/assets/10dd71cc-5efb-48d1-91e5-c71739f8c871" />

<img width="689" height="306" alt="image" src="https://github.com/user-attachments/assets/b3b49ebe-c707-4088-b51e-ba67cc4de16b" />



















