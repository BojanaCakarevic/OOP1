package PetiZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Glavno {

	private Voce[] ucitajVoce(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brVoca = Integer.parseInt(br.readLine().trim());
		Voce[] voce = new Voce[brVoca];
		for (int i = 0; i < brVoca; i++) {
			String[] s = br.readLine().split(",");
			String naziv = s[0].trim();
			double zapremina = Double.parseDouble(s[1].trim());
			if (s.length == 3) {
				boolean crvljivo = s[2].trim().equals("da");
				if (crvljivo)
					voce[i] = new Jabuka("Jabuka", zapremina, crvljivo);
				else
					voce[i] = new Jabuka("Jabuka", zapremina, crvljivo);
			} else if (naziv.equals("Ananas"))
				voce[i] = new Ananas("Ananas", zapremina);
			else
				voce[i] = new Voce(naziv, zapremina);
		}
		br.close();
		return voce;
	}

	public static void main(String[] args) throws IOException {
		Sokovnik sokovnik = new Sokovnik(new Glavno().ucitajVoce("res\\voce.txt"), 1.0);
		sokovnik.cedi();
	}

}
