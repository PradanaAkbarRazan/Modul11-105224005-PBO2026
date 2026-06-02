public class Main3 {
    public static void main(String[] args) {

        AkunBank akunNasabah = new AkunBank("12332178", 5000000);
        AkunBank akunTujuan = new AkunBank("87654123", 0);

        try {
            System.out.println("Memulai Simulasi Transaksi ATM");
            akunNasabah.tarikTunai(5000000); 
            akunNasabah.transfer(akunTujuan, 15000000); 

        } catch (SaldoTidakMencukupiException e) {
            System.out.println("Error Ditangkap: " + e.getMessage());
            System.out.println("Anda memiliki kekurangan dana sebesar: Rp" + e.getKekurangan());
            
        } catch (BatasTransferHarianException e) {
            System.out.println("Error Ditangkap: " + e.getMessage());
            
        } finally {
            System.out.println("\nSesi transaksi ATM kamu telah diakhiri. Kartu dikeluarkan otomatis.");
        }
    }
}