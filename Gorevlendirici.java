import java.util.*;

public class Gorevlendirici {
    private Queue<Proses> gercekZamanliKuyruk;
    private Queue<Proses> kullaniciProsesKuyruk;
    private BellekYoneticisi bellekYoneticisi;
    private KaynakYoneticisi kaynakYoneticisi;

    public Gorevlendirici(BellekYoneticisi bellekYoneticisi, KaynakYoneticisi kaynakYoneticisi) {
        this.gercekZamanliKuyruk = new LinkedList<>();
        this.kullaniciProsesKuyruk = new LinkedList<>();
        this.bellekYoneticisi = bellekYoneticisi;
        this.kaynakYoneticisi = kaynakYoneticisi;
    }

    public void prosesEkle(Proses proses) {
        if (proses.getPriority() == 0) {
            if (bellekYoneticisi.bellekTahsisEt(proses) && kaynakYoneticisi.kaynaklariKontrolEt(proses)) {
                gercekZamanliKuyruk.add(proses);
            } else {
                System.out.println("Bellek veya kaynak yetersiz: Proses eklenemiyor - ID: " + proses.getId());
            }
        } else {
            if (bellekYoneticisi.bellekTahsisEt(proses) && kaynakYoneticisi.kaynaklariKontrolEt(proses)) {
                kullaniciProsesKuyruk.add(proses);
            } else {
                System.out.println("Bellek veya kaynak yetersiz: Proses eklenemiyor - ID: " + proses.getId());
            }
        }
    }

    public void prosesleriIsle() {
        isleGercekZamanliProsesler();
        isleKullaniciProsesleri();
    }

    private void isleGercekZamanliProsesler() {
        while (!gercekZamanliKuyruk.isEmpty()) {
            Proses proses = gercekZamanliKuyruk.poll();
            process(proses);
        }
    }

    private void isleKullaniciProsesleri() {
        while (!kullaniciProsesKuyruk.isEmpty()) {
            Proses proses = kullaniciProsesKuyruk.poll();
            process(proses);
        }
    }

    private void process(Proses proses) {
        proses.setStatus("RUNNING");
        System.out.println(proses); // Proses bilgisini yazdır
        try {
            Thread.sleep(proses.getBurstTime() * 1000); // burstTime saniye beklet
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        proses.setStatus("COMPLETED");
        kaynakYoneticisi.kaynaklariIadeEt(proses);
        bellekYoneticisi.bellekIadeEt(proses);
    }
}
