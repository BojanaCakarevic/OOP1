package VezbeOsme_PrviZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SpisakPutnika {
	
	private Putnik[] putnici;

	public Putnik[] getPutnici() {
		return putnici;
	}

	public boolean ucitajSpisak(String fajl) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fajl));
			int brojPutnika = Integer.parseInt(br.readLine());
			putnici = new Putnik[brojPutnika];

			for (int i = 0; i < brojPutnika; i++) {
				String[] s = br.readLine().split(",");

				if (s.length == 3) {
					String ime = s[0].trim();
					double rucni = Double.parseDouble(s[1].trim());
					double predati = Double.parseDouble(s[2].trim());

					putnici[i] = new Putnik(ime, new RucniPrtljag(rucni), new PredatiPrtljag(predati));

				} else {
					System.out.println("Fajl " + fajl + " nije ispravno formatiran.");
					return false;
				}
			}
			return true;
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			return false;
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
			return false;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			return false;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					System.out.println(ioe.getMessage());
				}
			}
		}
	}
}
