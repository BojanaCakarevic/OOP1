package SestiZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class OmiljeniSajtovi {
	
	private static WebSajt[] omiljeni;

	public OmiljeniSajtovi(String fajl) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fajl));
		int brSajtova = Integer.parseInt(br.readLine().trim());
		omiljeni = new WebSajt[brSajtova];
		
		for(int i = 0; i < brSajtova; i++) {
			String[] prviDeo = br.readLine().split(",");
			
			String adresa = prviDeo[0].trim();
			Blog.Post[] postovi = new Blog.Post[Integer.parseInt(prviDeo[1].trim())];
			
			for(int k = 0; k < postovi.length; k++) {
				String[] linija = br.readLine().split(",");
				postovi[k] = new Blog.Post(linija[0].trim(), Integer.parseInt(linija[1].trim()), 
					Integer.parseInt(linija[2].trim()));
				
			} omiljeni[i] = new Blog(adresa, postovi);
		}br.close();
	}
	
	public WebSajt gdeDaPostavimReklamu(double raspoloziviNovac) {
		WebSajt rezultat = null;
		for(WebSajt s : omiljeni) {
			if(s.cenaReklameNaSajtu() <= raspoloziviNovac) {
				if(rezultat == null || rezultat.cenaReklameNaSajtu() < s.cenaReklameNaSajtu()) {
					rezultat = s;
				}
			}
		} return rezultat;
	}
	
	
	
}
