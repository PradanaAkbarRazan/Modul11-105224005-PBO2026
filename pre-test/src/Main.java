import java.util.InputMismatchException;
import java.util.Scanner;

class Kalkulator {
    public int bagi(int pembilang, int penyebut) throws ArithmeticException {
  
        return pembilang / penyebut; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kalkulator kalkulator = new Kalkulator(); // Pembuatan objek Kalkulator

        System.out.println("Program Kalkulator Pembagian");

        try {
            System.out.print("Masukkan angka pertama (pembilang): ");
            int pembilang = input.nextInt();

            System.out.print("Masukkan angka kedua (penyebut): ");
            int penyebut = input.nextInt();

            int hasil = kalkulator.bagi(pembilang, penyebut);
            System.out.println("Hasil pembagian: " + hasil);

        } catch (ArithmeticException e) {
      
            System.out.println("\n[ERROR] Terjadi kesalahan: Tidak dapat melakukan pembagian dengan angka 0!");
            
        } catch (InputMismatchException e) {
         
            System.out.println("\n[ERROR] Input tidak valid: Harap pastikan Anda hanya memasukkan angka!");
            
        } finally {
     
            input.close(); 
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}