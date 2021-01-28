package PV04_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Poliklinika {

	Lekar[] lekari;
	
	public Poliklinika() throws IOException {
		ucitajLekare("res\\lekari.txt");
		ucitajPacijente("res\\pacijenti.txt");
	}
	
	public void ucitajLekare(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brLekara = Integer.parseInt(br.readLine().trim());
		lekari = new Lekar[brLekara];
		
		for (int i = 0; i < brLekara; i ++) {
		String ime = br.readLine();
		String prezime = br.readLine();
		String tip = br.readLine();
		if (tip.equals("pedijatar"))
			lekari[i] = new Pedijatar(ime, prezime);
		else
			lekari[i] = new Pulmolog(ime, prezime);
		} br.close();
	}
	
	public void ucitajPacijente(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brPacijenata = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < brPacijenata; i++) {
			String ime = br.readLine();
			String prezime = br.readLine();
			int godine = Integer.parseInt(br.readLine());
			
			Pacijent p = new Pacijent(ime, prezime, godine);
			boolean dodeljen = false;
			while (!dodeljen)
				if (lekari[rng.nextInt(lekari.length)].prihvati(p))
					dodeljen = true;
		} br.close();
	}
	
	Random rng = new Random();
	
	public Pulmolog najmanjaPlata() {
		Pulmolog tek = null;
		for (int i = 0; i < lekari.length; i ++) {
			if(lekari[i] instanceof Pulmolog ) {
				if (tek == null || tek.plata() > lekari[i].plata() ) {
					tek = (Pulmolog) lekari[i];
				}
			}
		} return tek;
	}
	
}
