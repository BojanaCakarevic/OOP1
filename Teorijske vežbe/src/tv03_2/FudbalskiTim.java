package tv03_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FudbalskiTim {

	Fudbaler[] fudbaleri;
	
	public FudbalskiTim(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brFudbalera = Integer.parseInt(br.readLine().trim());
		fudbaleri = new Fudbaler[brFudbalera];
		
		for (int i = 0; i < brFudbalera; i++ ) {
			String[] s = br.readLine().split(",");
			
			String tip = s[0].trim();
			String prezime = s[1].trim();
			boolean pp = s[2].trim().compareTo("P")  == 0;
			
			if (tip.equals("G")) {
				int brGolova = Integer.parseInt(s[3].trim());
				fudbaleri[i] = new Golman (prezime, pp, brGolova);
			} else if (tip.equals("O")) {
				double km = Double.parseDouble(s[3].trim());
				int brKartona = Integer.parseInt(s[4].trim());
				fudbaleri[i] = new OdbrambeniIgrac(prezime, pp, km ,brKartona);
			}  else if (tip.equals("S")) {
				double km = Double.parseDouble(s[3].trim());
				int brAsistencija = Integer.parseInt(s[4].trim());
				fudbaleri[i] = new SredisnjiIgrac(prezime, pp, km ,brAsistencija);
			}  else{
				double km = Double.parseDouble(s[3].trim());
				int postignutiGolovi = Integer.parseInt(s[4].trim());
				fudbaleri[i] = new Napadac(prezime, pp, km , postignutiGolovi);
			}
		} 
		br.close();
	}
	
	Fudbaler[] izdvojRezerve() {
		int uRezervi = 0;
		
		for ( int i = 0; i < fudbaleri.length; i ++) {
			if (! fudbaleri[i].isPrvaPostava())
				uRezervi++;
		}
		
		Fudbaler[] rezerva = new Fudbaler[uRezervi];
		int brojac = 0;
		for (int i = 0; i < fudbaleri.length; i ++) {
			if ( ! fudbaleri[i].isPrvaPostava())
				rezerva[brojac++] = fudbaleri[i]; 
		}
			return rezerva;
	}
	
	SredisnjiIgrac najboljiSredisnjiIgracUrezervi() {
		SredisnjiIgrac najbolji = null;
		
		for (int i = 0; i < fudbaleri.length; i ++) {
			if (fudbaleri[i] instanceof SredisnjiIgrac && ! fudbaleri[i].isPrvaPostava() ) {
				SredisnjiIgrac s = (SredisnjiIgrac) fudbaleri[i];
			
				if (najbolji == null)
					najbolji = s;
				else {
					if (najbolji.getBrAsistencija() <= s.getBrAsistencija())
						najbolji = s;
					}
				}
		} return najbolji;
	}
	
}
