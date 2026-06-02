public class Pelanggan {
    private int stokKopi = 5;

    public void daftarMember(int umur) {
        if (umur < 17) {
            throw new IllegalArgumentException("Maaf, umur Anda belum mencukupi untuk menjadi Member VIP.");
        }
        System.out.println("Pendaftaran Member VIP Berhasil!");
    }

    public void pesanKopi(int jumlahPesanan) {
        if (jumlahPesanan > stokKopi) {
            throw new KopiHabisException("Error: Stok kopi tidak mencukupi! Sisa stok saat ini: " + stokKopi);
        }
        stokKopi -= jumlahPesanan;
        System.out.println("Berhasil memesan " + jumlahPesanan + " gelas kopi.");
    }
}