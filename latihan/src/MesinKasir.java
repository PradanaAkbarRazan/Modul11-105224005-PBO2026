public class MesinKasir {
    public void bayar(int totalBelanja, int uangDiberikan) throws UangKurangException {
        if (uangDiberikan < totalBelanja) {
            int kekurangan = totalBelanja - uangDiberikan;
            throw new UangKurangException("Error: Uang yang diberikan kurang sebesar Rp " + kekurangan);
        }
        System.out.println("Pembayaran berhasil! Kembalian: Rp " + (uangDiberikan - totalBelanja));
    }

    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (!statusPrinter) {
            throw new Exception("Printer error: Kertas struk habis!");
        }
        System.out.println("Struk berhasil dicetak.");
    }
}