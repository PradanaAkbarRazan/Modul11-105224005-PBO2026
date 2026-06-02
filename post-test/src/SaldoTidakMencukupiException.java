class SaldoTidakMencukupiException extends Exception {
    private double kekurangan;

    public SaldoTidakMencukupiException(double kekurangan) {
        super("Transaksi gagal: Saldo tidak mencukupi!");
        this.kekurangan = kekurangan;
    }

    // Mengembalikan nilai nominal kekurangan saldo
    public double getKekurangan() {
        return kekurangan;
    }
}
