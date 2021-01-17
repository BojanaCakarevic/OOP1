package Online_prodavnica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProdavnicaPatika {

	private Patike[] patike;

	public ProdavnicaPatika(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));

		int brPatika = Integer.parseInt(br.readLine().trim());
		patike = new Patike[brPatika];

		for (int i = 0; i < brPatika; i++) {
			String[] s = br.readLine().split(",");

			if (s[0].equals("Nike"))
				patike[i] = new Nike(s[0].trim(), Integer.parseInt(s[1].trim()));
			else if (s[0].equals("Adidas"))
				patike[i] = new Adidas(s[0].trim(), Integer.parseInt(s[1].trim()));
			else 
				patike[i] = new Converse(s[0].trim(), Integer.parseInt(s[1].trim()));
		}
		br.close();
	}
	
	public void ispisi() {
		for(int i = 0; i < patike.length; i ++) {
			System.out.print(patike[i]);
		}
	}
	
	public double prosecnaCenaDecijih() {
		int ukupna = 0;
		int brojac = 0;
		for (int i = 0; i < patike.length; i++) {
			if (patike[i].getVrsta().equals("DECIJE")) {
				ukupna += patike[i].getCena();
				brojac++;
			}
		}
		double prosek = ukupna / brojac;
		return prosek;
	}
	
}
