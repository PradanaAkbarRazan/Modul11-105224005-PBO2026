import java.util.InputMismatchException;
import java.util.Scanner;

public class CafeJavaBean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SIMULASI SISTEM KASIR CAFE JAVA BEAN\n");

        // Input Harga Menu
        System.out.println("Input Harga Menu");
        int[] hargaMenu = new int[3];

        try {
            for (int i = 0; i < 4; i++) {
                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                hargaMenu[i] = scanner.nextInt(); 
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harga harus berupa angka!");
            scanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Kapasitas memori harga sudah penuh!");
        }

        System.out.println(); 

        // Inisialisasi Objek dari kelas lain
        Pelanggan pelangganVIP = new Pelanggan();
        MesinKasir kasir = new MesinKasir();

        // Registrasi Member VIP
        System.out.println("Soal 2: Registrasi Member VIP");
        try {
            pelangganVIP.daftarMember(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Tertangkap Error: " + e.getMessage());
        }

        System.out.println();

        // Pemesanan Kopi
        System.out.println("Pemesanan Kopi");
        try {
            pelangganVIP.pesanKopi(10);
        } catch (KopiHabisException e) {
            System.out.println("Tertangkap Error: " + e.getMessage());
        }

        System.out.println();

        // Proses Pembayaran
        System.out.println("Proses Pembayaran");
        try {
            kasir.bayar(50000, 30000);
        } catch (UangKurangException e) {
            System.out.println("Tertangkap Error: " + e.getMessage());
        }

        System.out.println();

        // Cetak Struk & Penutupan
        System.out.println("Cetak Struk & Penutupan");
        try {
            kasir.cetakStruk(false);
        } catch (Exception e) {
            System.out.println("Tertangkap Error: " + e.getMessage());
        } finally {
            System.out.println("\nTerima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
            scanner.close();
        }
    }
}