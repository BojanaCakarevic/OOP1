package VezbeDevete_TreciZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DJ {
	public static void main(String[] args) {
		SuperPlejer s = new SuperPlejer(5);
		boolean greskaFajl = false;

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("res\\diskovi.txt"));
			String linija = null;
			boolean gotovo = false;

			while ((linija = br.readLine()) != null && !gotovo) {
				String[] tok = linija.split(",");
				if (tok.length != 3) {
					System.out.println("Neispravna linija " + linija);
				} else {
					String izvodjac = tok[0].trim();
					try {
						int trajanje = Integer.parseInt(tok[1].trim());
						int kvalitet = Integer.parseInt(tok[2].trim());
						s.dodaj(new Disk(izvodjac, trajanje, kvalitet));
					} catch (NumberFormatException nfe) {
						System.out.println("Neispravna linija " + linija);
					} catch (NemaMesta nm) {
						System.out.println(nm.getMessage());
						gotovo = true;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Greska u radu sa fajlom");
			greskaFajl = true;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}

		if (!greskaFajl) {
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("Runda " + (i + 1));
					s.sviraj();
				}
			} catch (NemaDiskova nd) {
				System.out.println(nd.toString());
			}

			System.out.println(s.getBrojDiskova());
		}
	}
}
