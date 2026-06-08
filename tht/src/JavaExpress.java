import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservasiController controller = new ReservasiController();
        boolean isRunning = true;

        System.out.println("Selamat Datang di Sistem Reservasi JAVA EXPRESS!");

        try {
            while (isRunning) {
                // Menu utama
                System.out.println("\n MENU UTAMA ");
                System.out.println("1. Lihat Jadwal Kereta");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1-3): ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan sisa baris baru

                    switch (pilihan) {
                        case 1:
                            controller.tampilkanJadwal();
                            break;
                        case 2:
                            System.out.print("Masukkan Kode Kereta : ");
                            String kode = scanner.nextLine();
                            System.out.print("Masukkan NIK (16 digit): ");
                            String nik = scanner.nextLine();
                            System.out.print("Masukkan Nama Penumpang: ");
                            String nama = scanner.nextLine();
                            System.out.print("Masukkan Jumlah Tiket  : ");
                            int jumlah = scanner.nextInt();
                            scanner.nextLine(); 

                            // Proses Pemesanan
                            controller.pesanTiket(kode, nik, nama, jumlah);
                            break;
                        case 3:
                            System.out.println("Keluar dari aplikasi...");
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }

                } catch (InputMismatchException e) { // Tangkap error jika input harusnya angka tapi diisi huruf
                    System.out.println("\n[ERROR] Input tidak valid! Harap masukkan angka.");
                    scanner.nextLine(); // Membersihkan buffer memori agar tidak infinite loop
                } catch (DataPenumpangTidakValidException e) { // Tangkap custom error NIK
                    System.out.println("\n[ERROR VALIDASI] " + e.getMessage());
                } catch (RuteTidakDitemukanException | TiketHabisException e) { // Tangkap custom error Kereta
                    System.out.println("\n[ERROR RESERVASI] " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("\n[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage());
                }
            }
        } finally { // Blok yang dijamin pasti tereksekusi saat keluar dari sistem
            System.out.println("[INFO] Membersihkan resource memori. Selesai.");
            scanner.close();
        }
    }
}