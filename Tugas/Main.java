import java.util.Scanner;

public class Main {
    public static void menu(){
        System.out.println("\n=== Menu Antrian Layanan KRS ===");
        System.out.println("1. Tambah Mahasiswa ke Antrian");
        System.out.println("2. Proses KRS Mahasiswa");
        System.out.println("3. Lihat Mahasiswa Terdepan");
        System.out.println("4. Lihat Semua Antrian");
        System.out.println("5. Lihat Mahasiswa Terakhir");
        System.out.println("6. Jumlah Antrian");
        System.out.println("7. Jumlah yang Sudah Proses KRS");
        System.out.println("8. Jumlah kuota yang Belum Proses KRS oleh DPA");
        System.out.println("9. Cek Antrian Kosong");
        System.out.println("10. Cek Antrian Penuh");
        System.out.println("11. Kosongkan Antrian");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLayananKRS antrian = new AntrianLayananKRS(10);
        int pilihan;

        do {
            menu();
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi: ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    antrian.layaniKRS();
                    break;
                case 3:
                    antrian.tampilkanTerdepan();
                    break;
                case 4:
                    antrian.tampilkanSemua();
                    break;
                case 5:
                    antrian.tampilkanAkhir();
                    break;
                case 6:
                    System.out.println("Jumlah dalam antrian: " + antrian.getJumlahAntrian());
                    break;
                case 7:
                    System.out.println("Jumlah yang sudah proses KRS: " + antrian.getJumlahKRS());
                    break;
                case 8:
                    System.out.println("Jumlah yang belum dilayani proses KRS: " + antrian.getJumlahBelumKRS());
                    break;
                case 9:
                    System.out.println("Antrian " + (antrian.isEmpty()? "kosong" : "tidak kosong"));
                    break;
                case 10:
                    System.out.println("Antrian " + (antrian.isFull()? "penuh" : "tidak penuh"));
                    break;
                case 11:
                    antrian.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}