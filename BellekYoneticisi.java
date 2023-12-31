public class BellekYoneticisi {
	private int toplamBellek;
    private int kullanilabilirBellek;

    public BellekYoneticisi(int toplamBellek) {
        this.toplamBellek = toplamBellek;
        this.kullanilabilirBellek = toplamBellek;
    }

    /**
     * Proses için bellek tahsis etmeye çalışır.
     * @param proses Bellek tahsis edilmek istenen proses.
     * @return Bellek tahsis edilip edilemediğini gösteren boolean değer.
     */
    public synchronized boolean bellekTahsisEt(Proses proses) {
        if (proses.getMemory() <= kullanilabilirBellek) {
            kullanilabilirBellek -= proses.getMemory();
            System.out.println("Bellek tahsis edildi: Proses ID = " + proses.getId() + ", Kullanılan Bellek = " + proses.getMemory());
            return true;
        } else {
            System.out.println("Yeterli bellek yok: Proses ID = " + proses.getId());
            return false;
        }
    }

    /**
     * Prosesin kullandığı belleği iade eder.
     * @param proses Belleği iade edilecek proses.
     */
    public synchronized void bellekIadeEt(Proses proses) {
        kullanilabilirBellek += proses.getMemory();
        System.out.println("Bellek iade edildi: Proses ID = " + proses.getId() + ", İade Edilen Bellek = " + proses.getMemory());
    }

    /**
     * Toplam ve kullanılabilir bellek bilgilerini döndürür.
     * @return Toplam ve kullanılabilir bellek bilgisini içeren bir String.
     */
    public String bellekDurumu() {
        return "Toplam Bellek: " + toplamBellek + ", Kullanılabilir Bellek: " + kullanilabilirBellek;
    }
}
