# Membuat Program 24 Solver dengan Metode Algoritma Brute Force
Disusun untuk memenuhi Tugas Kecil 1 IF2211 Strategi Algoritma "Penyelesaian Permainan Kartu 24 dengan *Algoritma Brute Force*".

## Daftar Isi
* [Deskripsi Singkat Program](#deskripsi-singkat-program)
* [Struktur Program](#struktur-program)
* [Requirement Program](#struktur-program)
* [Cara Kompilasi Program](#cara-kompilasi-program)
* [Cara Menjalankan Program](#cara-menjalankan-program)
* [Author](#author)

## Deskripsi Singkat Program
Program untuk mencari semua kemungkinan operasi dari empat bilangan untuk menghasilkan nilai 24. Terdapat dua opsi input pada program, yaitu input manual dan input random. Untuk input manual, program akan meminta empat input string.
## Struktur Program
bash
.
│   README.md
│
├───bin
│       Tucil1_13521031.jar
│
├───doc
│       Tucil1_K3_13521031_Fahrian Afdholi.pdf
│       
├───src
│       Main.java
│       Priority.java
│       Tools.java
│       SplashScreen.java
│       Results.java
|       |
|       |
|       └─── META-INF
|             MANIFEST.MF
│
|
|
└───test
        inputKeyboard1.txt
        inputKeyboard2.txt
        inputKeyboard3.txt
        random1.txt
        random2.txt
        random3.txt

## Requirement Program
* JDK

## Cara Kompilasi Program
1. Pastikan anda sudah memiliki JDK (rekomendasi JDK 19)
2. Jalankan program main.java yang berada pada folder src atau Tucil1_13521031.jar pada file bin
3. Program akan berjalan dengan seharusnya

## Cara Menjalankan Program
1. Pastikan Anda telah berhasil melakukan kompilasi pada program.
2. Saat program berhasil dijalankan, anda akan diminta apakah program menerim input manual dari user atau dipilih secara random oleh program. Ikuti instruksi dari program. 
3. Jika anda memilih input manual, maka anda akan diminta memasukkan 4 buah string dari salah satu {'A', '2', '3', ..., 'J', 'Q', 'K'}. Jika tidak sesuai maka program akan meminta ulang input.
4. Setelah program berhasil menemukan solusi, user akan diminta input apakah user ingin menyimpan hasil solusi dalam bentuk file txt. Tekan y untuk mengeksport output program.

## Author
* Nama: Fahrian Afdholi
* NIM: 13521031
* Prodi/Jurusan: STEI/Teknik Informatika
* Profile Github: [Fahrian Afdholi](https://github.com/fchrgrib)
