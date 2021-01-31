package kol01_b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Kafana implements Sanker{
	
	private Pivo[] pivo;
	private String ime, adresa;
	private int ukupnoPosluzenihPiva;
	
	public Kafana(String fajl, String ime, String adresa) throws IOException {
		this.ime = ime;
		this.adresa = adresa;
		
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brPiva = Integer.parseInt(br.readLine().trim());
		pivo = new Pivo[brPiva];
		
		for (int i = 0; i < brPiva; i ++) {
			String[] s = br.readLine().split(";");
			String proizvodjac = s[0].trim();
			String tip = s[1].trim();
			
			if (tip.equals("psenicno"))
				pivo[i] = new PsenicnoPivo(proizvodjac, tip);
			else if (tip.equals("kraft"))
				pivo[i] = new KraftPivo(proizvodjac, tip);
			else
				pivo[i] = new CrvenoPivo(proizvodjac, tip);
			} br.close();
	}

	@Override
	public void posluziPivo() {
		ukupnoPosluzenihPiva = 0;
		System.out.println("Sluzim piva...");
		for (int i = 0; i < pivo.length; i++) {
			if (!pivo[i].jeIzlapelo()) {
				ukupnoPosluzenihPiva++;
				System.out.println(pivo[i].getTip());
			}}
	}
	
	public int getUkupnoPosluzenihPiva() {
		return ukupnoPosluzenihPiva;
	}
	
	public double prosecnaJacina() {
		double ukupno = 0.0;
		double brojac = 0.0;
		for (int i = 0; i < pivo.length; i ++) {
			ukupno += pivo[i].getJacina();
			brojac++;
		}
		return ukupno/brojac;
	}

	@Override
	public String toString() {
		return "Kafana ime=" + ime 
				+ ", ukupnoPosluzenihPiva=" + ukupnoPosluzenihPiva + "]";
	}

	
}
