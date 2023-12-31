import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
        try {
            String dosyaYolu = "giris.txt"; // giriş.txt dosyasının yolu
            List<Proses> prosesListesi = ProsesOkuyucu.prosesleriOku(dosyaYolu);

            BellekYoneticisi bellekYoneticisi = new BellekYoneticisi(1024); // Örnek bellek boyutu
            KaynakYoneticisi kaynakYoneticisi = new KaynakYoneticisi(5, 3, 2, 1); // Kaynak yöneticisi başlatma
            Gorevlendirici gorevlendirici = new Gorevlendirici(bellekYoneticisi, kaynakYoneticisi); // Kaynak yöneticisi ekleniyor

            for (Proses proses : prosesListesi) {
                gorevlendirici.prosesEkle(proses);
            }

            gorevlendirici.prosesleriIsle();
            raporla(prosesListesi);
            System.out.println(bellekYoneticisi.bellekDurumu());

        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Bir hata oluştu: " + e.getMessage());
        }
    }
	// Raporlama için yeni bir metod
    private static void raporla(List<Proses> prosesListesi) {
        System.out.println("Pid\tvarış\toncelik\tcpu\tMBytes\tprn\tscn\tmodem\tcd\tstatus");
        System.out.println("============================================================");
        for (Proses proses : prosesListesi) {
            System.out.println(proses);
        }
    }
    
}
