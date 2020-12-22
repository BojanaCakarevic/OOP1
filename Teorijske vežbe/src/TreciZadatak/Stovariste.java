package TreciZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stovariste {

	private PolovnoVozilo[] vozilo;

	public Stovariste(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brojVozila = Integer.parseInt(br.readLine().trim());
		vozilo = new PolovnoVozilo[brojVozila];

		for (int i = 0; i < brojVozila; i++) {
			String[] s = br.readLine().split(",");

			String tip = s[0].trim();
			int starost = Integer.parseInt(s[1].trim());
			int broj = Integer.parseInt(s[2].trim());

			if (tip.compareTo("auto") == 0)
				vozilo[i] = new PolovnoAuto(starost, broj);
			else
				vozilo[i] = new PolovniKombi(starost, broj);
		}
		br.close();
	}

	public PolovniKombi[] najjeftinijiKombi() {
		PolovniKombi najjeftiniji = null;
		int brojac = 0;

		for (int i = 0; i < vozilo.length; i++) {
			if (vozilo[i] instanceof PolovniKombi) {
				PolovniKombi pk = (PolovniKombi) vozilo[i];

				if (najjeftiniji == null || pk.cena() < najjeftiniji.cena()) {
					najjeftiniji = pk;
					brojac = 1;
				} else if (pk.cena() == najjeftiniji.cena())
					brojac++;
			}
		}
		
		if (brojac == 0)
			return null;
		else if (brojac == 1) {
			PolovniKombi[] m = { najjeftiniji };
			return m;
		} else {
			PolovniKombi[] m = new PolovniKombi[brojac];
			int j = 0;
			for (int i = 0; i < vozilo.length; i++) {
				if (vozilo[i] instanceof PolovniKombi) {
					PolovniKombi pk = (PolovniKombi) vozilo[i];
					if (pk.cena() == najjeftiniji.cena())
						m[j++] = pk;
				}
			}
			return m;
		}
	}

	public static void main(String[] args) throws IOException {
		Stovariste stovariste = new Stovariste("res\\vozila.txt");
		PolovniKombi[] kombi = stovariste.najjeftinijiKombi();
		if (kombi == null)
			System.out.println("U ponudi nema kombija.");
		else {
			for (int i = 0; i < kombi.length; i++) {
				System.out.println(kombi[i]);
			}
		}
	}

}
