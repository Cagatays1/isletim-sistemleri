
public class KaynakYoneticisi {
	private int mevcutYazicilar;
    private int mevcutTarayicilar;
    private int mevcutModemler;
    private int mevcutCds;

    public KaynakYoneticisi(int yazicilar, int tarayicilar, int modemler, int cds) {
        this.mevcutYazicilar = yazicilar;
        this.mevcutTarayicilar = tarayicilar;
        this.mevcutModemler = modemler;
        this.mevcutCds = cds;
    }

    // Prosesin kaynak taleplerini kontrol et
    public boolean kaynaklariKontrolEt(Proses proses) {
        if (proses.getYazicilar() <= this.mevcutYazicilar && 
            proses.getTarayicilar() <= this.mevcutTarayicilar &&
            proses.getModemler() <= this.mevcutModemler && 
            proses.getCds() <= this.mevcutCds) {
            // Kaynakları tahsis et
            this.mevcutYazicilar -= proses.getYazicilar();
            this.mevcutTarayicilar -= proses.getTarayicilar();
            this.mevcutModemler -= proses.getModemler();
            this.mevcutCds -= proses.getCds();
            return true;
        }
        return false;
    }

    // Proses bittikten sonra kaynakları iade et
    public void kaynaklariIadeEt(Proses proses) {
        this.mevcutYazicilar += proses.getYazicilar();
        this.mevcutTarayicilar += proses.getTarayicilar();
        this.mevcutModemler += proses.getModemler();
        this.mevcutCds += proses.getCds();
    }

}
