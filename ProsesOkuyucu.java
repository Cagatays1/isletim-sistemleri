import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ProsesOkuyucu {
	public static List<Proses> prosesleriOku(String dosyaYolu) throws IOException {
	    List<Proses> prosesListesi = new ArrayList<>();
	    BufferedReader br = new BufferedReader(new FileReader(dosyaYolu));
	    String satir;

	    while ((satir = br.readLine()) != null) {
	        String[] parcalar = satir.split(", ");
	        if (parcalar.length != 8) {
                throw new IllegalArgumentException("Hatalı veri formatı. Satırda eksik veya fazla veri var: " + satir);
            }
	      
	        int id = Integer.parseInt(parcalar[0]); // ID
	        int varisZamani = Integer.parseInt(parcalar[1]); // Varış Zamanı
	        //int prosesSuresi = Integer.parseInt(parcalar[2]); // Proses Süresi
	        int oncelik = Integer.parseInt(parcalar[2]); // Öncelik
	        int bellek = Integer.parseInt(parcalar[3]); // Bellek
	        int yazicilar = Integer.parseInt(parcalar[4]); // Yazıcılar
	        int tarayicilar = Integer.parseInt(parcalar[5]); // Tarayıcılar
	        int modemler = Integer.parseInt(parcalar[6]); // Modemler
	        int cds = Integer.parseInt(parcalar[7]); // CD sürücüleri

	        Proses proses = new Proses(id, varisZamani, oncelik, bellek, yazicilar, tarayicilar, modemler,cds);
	        prosesListesi.add(proses);
	    }

	    br.close();
	    return prosesListesi;
	}

}
