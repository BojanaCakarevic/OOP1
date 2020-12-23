package TreciDomaci;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Spajz {

	private Polica[] polica;

	public Spajz() throws IOException {
		ucitajPolice("res\\police.txt");
		ucitajTegle("res\\tegle.txt");
	}

	public void ucitajPolice(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brPolica = Integer.parseInt(br.readLine().trim());
		polica = new Polica[brPolica];

		for (int i = 0; i < brPolica; i++) {
			String[] s = br.readLine().split(",");

			String ime = s[0].trim();
			int brRedova = Integer.parseInt(s[1].trim());

			if (ime.length() > 5)
				polica[i] = new PlasticnaPolica(ime, brRedova);
			else
				polica[i] = new Polica(ime, brRedova, 10);
		}
		br.close();
	}

	public void ucitajTegle(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brTegli = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < brTegli; i++) {
			String[] s = br.readLine().split(",");

			double zapremina = Double.parseDouble(s[0].trim());
			double tezina = Double.parseDouble(s[1].trim());
			String sadrzaj = s[2].trim();

			Tegla t = new Tegla(zapremina, tezina, sadrzaj);
		}
		br.close();
	}

	public double tezina() {
		double ukupno = 0.0;
		for (int i = 0; i < polica.length; i++) {
			ukupno += polica[i].getTrenutnoOpterecenje();
		}
		return ukupno;
	}

	public PlasticnaPolica najteza() {
		PlasticnaPolica najteza = null;
		double opterecenje = 0.0;
		for (int i = 0; i < polica.length; i++) {
			if (polica[i] instanceof PlasticnaPolica) {
				PlasticnaPolica pom = (PlasticnaPolica) polica[i];
				if (pom.getTrenutnoOpterecenje() < 2.5) {
					if (najteza == null || pom.getTrenutnoOpterecenje() > opterecenje) {
						najteza = pom;
						opterecenje = pom.getTrenutnoOpterecenje();
					}
				}
			}
		}
		return najteza;
	}

}
