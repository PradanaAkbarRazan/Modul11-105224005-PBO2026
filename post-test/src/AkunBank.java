class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;
    private static final double LIMIT_HARIAN = 10000000.0; // Limit 10 juta

    public AkunBank(String nomorRekening, double saldoAwal) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldoAwal;
        this.totalTransferHariIni = 0;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            throw new SaldoTidakMencukupiException(nominal - saldo);
        }
        saldo -= nominal;
        System.out.println("Tarik tunai berhasil sejumlah Rp" + nominal + ". Saldo saat ini: Rp" + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal) throws SaldoTidakMencukupiException, BatasTransferHarianException {
     
        if (nominal > saldo) {
            throw new SaldoTidakMencukupiException(nominal - saldo);
        }
        if (totalTransferHariIni + nominal > LIMIT_HARIAN) {
            throw new BatasTransferHarianException("Transfer gagal: Melebihi limit transfer harian (Rp 10.000.000).");
        }
    
        this.saldo -= nominal;
        this.totalTransferHariIni += nominal;
        tujuan.saldo += nominal;
        
        System.out.println("Transfer ke " + tujuan.getNomorRekening() + " berhasil sejumlah Rp" + nominal + ".");
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }
}