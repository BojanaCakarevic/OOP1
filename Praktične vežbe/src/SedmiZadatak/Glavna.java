package SedmiZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Glavna {

	public static void main(String[] args) {
		BufferedReader br = null;
		try{
			obradiAkcije(br);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	private static void obradiAkcije(BufferedReader br) throws IOException {
		br = new BufferedReader(new FileReader("res\\akcije.txt"));
		Uciteljica uciteljica = new Uciteljica();
		String s = br.readLine();
		while(s != null) {
			izvrsiAkciju(uciteljica, s);
			s = br.readLine();
		}
	}
	
	private static void izvrsiAkciju(Uciteljica uciteljica, String s) {
		String[] elementiLinije = s.split(" ");
		if(elementiLinije[0].trim().equals("roditeljski")) {
			uciteljica.odrziRoditeljski();
		} else if(elementiLinije.length == 2 && elementiLinije[0].trim().equals("pregledaj")) {
			uciteljica.pregledajZadatke(elementiLinije[1].trim());
		} else {
			System.out.println("Neispravna linija u fajlu" + s);
		}
	}

}
