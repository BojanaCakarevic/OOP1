package kol01_a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProdavnicaPatika {

	private Patike[] patike;
	
	public ProdavnicaPatika(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brPatika = Integer.parseInt(br.readLine().trim());
		patike = new Patike[brPatika];
		
		for (int i = 0; i < brPatika; i ++) {
			String[] s = br.readLine().split(",");
			int broj = Integer.parseInt(s[0].trim());
			String brend = s[1].trim();
			
			if (brend.equals("Nike"))
				patike[i] = new Nike(broj, brend);
			else if (brend.equals("Adidas"))
				patike[i] = new Adidas(broj, brend);
			else
				patike[i] = new Converse(broj, brend);
		} br.close();
	}
	
	public void prosecnaCena() {
		int sumad = 0;
		int sumao = 0;
		int brojd = 0;
		int brojo = 0;
		for (int i = 0; i < patike.length; i ++) {
			if (patike[i].getVrsta().equals(Osobine.VRSTA[1])) {
				sumad += patike[i].getCena();
				brojd++;
			} else {
				sumao += patike[i].getCena();
				brojo++;
			}
		}
		System.out.println("Prosecna cena decijih patika je " + sumad / brojd);
		System.out.println("Prosecna cena patika za odrasle je  " + sumao / brojo);
		System.out.println("Prosecna cena svih parika je  " + (sumad + sumao) / (brojd + brojo));
	}
	
	public static void main(String[] args) throws IOException {
		ProdavnicaPatika pp = new ProdavnicaPatika("res\\patike.txt");
		pp.prosecnaCena();
	}
	
}
