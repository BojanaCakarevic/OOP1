package TreciZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Galerija {
	private Umetnik[] umetnici;
	
	public Galerija() throws IOException {
		ucitajUmetnike("res\\umetnici.txt");
		ucitajDela("res\\dela.txt");
	}
	
	public void ucitajUmetnike(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brUmetnika = Integer.parseInt(br.readLine());
		umetnici = new Umetnik[brUmetnika];
		
		for(int i = 0; i < brUmetnika; i++) {
			String[] s = br.readLine().split(",");
			String naziv = s[0].trim();
			
			if(s.length == 2) {
				int maks = Integer.parseInt(s[1].trim());
				umetnici[i] = new Umetnik(naziv, maks);
			} else
				umetnici[i] = new Slikar(naziv);
		}
		br.close();
	}
	
	public void ucitajDela(String imeFajla) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(imeFajla));
		int brDela = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i < brDela; i++) {
			String umetnik = br.readLine().trim();
			UmetnickoDelo delo = new UmetnickoDelo(
					br.readLine().trim(), Integer.parseInt(br.readLine().trim()),
					Double.parseDouble(br.readLine().trim()));
			
			nadjiUmetnika(umetnik).izlozi(delo);
		}
		br.close();
	}
	
	private Umetnik nadjiUmetnika(String ime) {
		for(int i = 0; i < umetnici.length; i++) {
			if(umetnici[i].getIme().equals(ime))
				return umetnici[i];
		}
		return null;
	}
	
	
	public double prosecnaVrednost() {
		double suma = 0.0;
		int broj = 0;
		for(int i = 0; i < umetnici.length; i++) {
			suma += umetnici[i].vrednost();
			broj += umetnici[i].getBrojDela();
		}
		double prosek = (int)(suma/broj*100)/100.0;
		return prosek;
	}
	
}
