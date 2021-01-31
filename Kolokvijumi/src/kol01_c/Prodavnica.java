package kol01_c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prodavnica implements Servis {

	private Uredjaj[] uredjaji;
	private Uredjaj[] zaServis = new Uredjaj[3];

	public Prodavnica(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brUredjaja = Integer.parseInt(br.readLine().trim());
		uredjaji = new Uredjaj[brUredjaja];

		for (int i = 0; i < brUredjaja; i++) {
			String[] s = br.readLine().split(",");
			String tip = s[0].trim();
			String boja = s[1].trim();
			double procesor = Double.parseDouble(s[2].trim());
			int ram = Integer.parseInt(s[3].trim());
			double cena = Double.parseDouble(s[4].trim());
			boolean kamera = s.length == 6 ? (s[5].trim().equals("da") ? true : false) : false;

			if (tip.equals("laptop"))
				uredjaji[i] = new Laptop(boja, procesor, ram, cena, kamera);
			else if (tip.equals("desktop"))
				uredjaji[i] = new DesktopRacunar(boja, procesor, ram, cena, kamera);
			else
				uredjaji[i] = new Telefon(boja, procesor, ram, cena, kamera);
		}
		br.close();
	}

	double prodaj() {
		int brojac = 0;
		double ukupno = 0.0;
		int brZaServis = 0;
		for (int i = 0; i < uredjaji.length; i++) {
			if (!uredjaji[i].jePotrebanServis()) {
				ukupno += uredjaji[i].cena;
				brojac++;
			} else if (brZaServis < zaServis.length) {
				zaServis[brZaServis++] = uredjaji[i];
			}
		}
		return ukupno / brojac;
	}

	@Override
	public boolean popravi() {
		for (int i = 0; i < zaServis.length; i++) {
			if (zaServis[i] instanceof Telefon) {
				if (Osobine.rng.nextInt(100) <= 80)
					return true;
			} else {
				if (Osobine.rng.nextInt(100) <= 75)
					return true;
			}
		}
		return false;
	}

}
