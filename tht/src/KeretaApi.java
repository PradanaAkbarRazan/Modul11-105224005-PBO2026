public class KeretaApi {
    private String kode;
    private String nama;
    private String rute;
    private int sisaKursi;

    public KeretaApi(String kode, String nama, String rute, int sisaKursi) {
        this.kode = kode;
        this.nama = nama;
        this.rute = rute;
        this.sisaKursi = sisaKursi;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public String getRute() { return rute; }
    public int getSisaKursi() { return sisaKursi; }
    
    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }
}