import java.util.ArrayList;
import java.util.List;

public class ReservasiController {
    private List<KeretaApi> daftarKereta;

    public ReservasiController() {
        daftarKereta = new ArrayList<>();
        // Inisialisasi data awal di memori sesuai soal
        daftarKereta.add(new KeretaApi("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public void tampilkanJadwal() {
        System.out.println("\n--- JADWAL KERETA API JAVA EXPRESS ---");
        for (KeretaApi k : daftarKereta) {
            System.out.println("Kode: " + k.getKode() + " | Nama: " + k.getNama() + 
                               " | Rute: " + k.getRute() + " | Sisa Kursi: " + k.getSisaKursi());
        }
    }

    public void pesanTiket(String kode, String nik, String nama, int jumlah) 
            throws RuteTidakDitemukanException, TiketHabisException { 
        
        // Validasi NIK 
        if (nik == null || nik.length() != 16 || !nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException("NIK tidak valid! Harus berjumlah tepat 16 karakter dan hanya berisi angka.");
        }

        // Cari kereta berdasarkan kode 
        KeretaApi keretaPilihan = null;
        for (KeretaApi k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                keretaPilihan = k;
                break;
            }
        }

        // Validasi Rute/Kode 
        if (keretaPilihan == null) {
            throw new RuteTidakDitemukanException("Kode kereta '" + kode + "' tidak ditemukan dalam sistem.");
        }

        // Validasi Sisa Kursi
        if (jumlah > keretaPilihan.getSisaKursi()) {
            throw new TiketHabisException(keretaPilihan.getNama(), keretaPilihan.getSisaKursi());
        }

        // Proses berhasil 
        keretaPilihan.kurangiKursi(jumlah);
        System.out.println("\n[INFO] Pemesanan tiket untuk " + nama + " berhasil!");
    }
}