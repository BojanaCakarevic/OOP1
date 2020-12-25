package SedmiZadatak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Uciteljica implements Nastavnik {
	private DomaciRad[] pregledaniZadaci;
	private String pregledaniPredmeti;

	@Override
	public void odrziRoditeljski() {
		System.out.println("\n RODITELJSKI ");
		if (pregledaniZadaci == null || pregledaniPredmeti == null)
			System.out.print("Uciteljica prica o ekskurziji.");
		else {
			System.out.println("Pregledani zadaci su iz predmeta  " + pregledaniPredmeti + ".");
			ispisiZadatke();
			anulirajPolja();
		}
		System.out.println("\n");
	}

	private void ispisiZadatke() {
		for (int i = 0; i < pregledaniZadaci.length; i++)
			System.out.println(pregledaniZadaci[i]);
	}

	private void anulirajPolja() {
		pregledaniPredmeti = null;
		pregledaniZadaci = null;
	}

	@Override
	public void pregledajZadatke(String predmet) {
		try (BufferedReader br = new BufferedReader(new FileReader(predmet))) {

			dodajPredmetUPregledane(predmet);
			String[] resenja = uzmiResenja(br.readLine(), predmet);
			String s = br.readLine();

			while (s != null) {
				try {
					pregledajZadatak(s, resenja, predmet);
				} catch (IOException | NijePredatDomaci | FaliZadatak e) {
					System.out.println(e.getMessage());
				}
				s = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println(predmet + " ne postoji");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

	private String[] uzmiResenja(String s, String predmet) throws IOException {
		String[] elementi = s.split(",");
		int brojZadataka = Integer.parseInt(elementi[0].trim());
		String[] resenja = new String[elementi.length - 1];
		if (resenja.length != brojZadataka) {
			throw new IOException("Neispravna prva linija u fajlu " + predmet);
		}
		for (int i = 1; i < elementi.length; i++) {
			resenja[i - 1] = elementi[i].trim();
		}
		return resenja;
	}

	private void dodajPredmetUPregledane(String predmet) {
		pregledaniPredmeti = pregledaniPredmeti == null ? predmet : pregledaniPredmeti + ", " + predmet;
	}

	private void pregledajZadatak(String linija, String[] resenja, String predmet)
			throws IOException, NijePredatDomaci, FaliZadatak {
		String[] elementiLinije = linija.split(",");
		if (elementiLinije.length == 0) {
			throw new IOException("Neispravna linija u fajlu " + predmet + ":" + " " + linija);
		} else if (elementiLinije.length == 1) {
			throw new NijePredatDomaci(elementiLinije[0].trim(), predmet);
		} else {
			String[] zadaci = new String[elementiLinije.length - 1];
			for (int i = 1; i < elementiLinije.length; i++) {
				zadaci[i - 1] = elementiLinije[i].trim();
			}
			DomaciRad domaciRad = new DomaciRad(elementiLinije[0].trim(), zadaci);
			if (resenja.length != zadaci.length) {
				throw new FaliZadatak(domaciRad);
// dodati ocenjivanje i dodavanje zadatka
			}
		}
	}

}