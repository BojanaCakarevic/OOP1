package kolokvijum01_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prodavnica implements Servis {
	
	private Uredjaj[] uredjaji;
	private Uredjaj[] zaServis = new Uredjaj[3];

	public Prodavnica(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brUredjaja = Integer.parseInt(br.readLine().trim());
		uredjaji = new Uredjaj[brUredjaja];
		
		for (int i = 0; i < brUredjaja; i ++) {
			String[] s = br.readLine().split(",");
			String tip = s[0].trim();
			String boja = s[1].trim();
			double procesor = Double.parseDouble(s[2].trim());
			int ram = Integer.parseInt(s[3].trim());
			double cena = Double.parseDouble(s[4].trim());
			boolean kamera = s.length == 6 ? (s[5].equals("da") ? true : false) : false;
			
			if (tip.equals("telefon")){
				uredjaji[i] = new Telefon (procesor, ram, cena, boja);
			} else if (tip.equals("laptop"))
				uredjaji[i] = new Laptop(procesor, ram, kamera, cena, boja);
			else
				uredjaji[i] = new DesktopRacunar(procesor, ram, cena, boja);
		}
		
		br.close();
	}

	@Override
	public boolean popravi() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double prodaj() {
		double ukupno = 0.0;
		int brojac = 0;
		
		for (int i = 0; i < uredjaji.length; i ++) {
			ukupno += uredjaji[i].getCena();
			brojac++;
		}
		return ukupno / brojac;
	}
	
}
