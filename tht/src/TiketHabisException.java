public class TiketHabisException extends Exception {
    public TiketHabisException(String namaKereta, int sisaKursi) {
        super("Maaf, tiket habis! Kereta " + namaKereta + " hanya tersisa " + sisaKursi + " kursi.");
    }
}