package VezbeDevete_PrviZadatak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimulacijaFirme {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			Firma firma = new Firma(10);
			br = new BufferedReader(new FileReader("res\\radnicii.txt"));

			String s;
			int brojLinija = 0;

			while ((s = br.readLine()) != null) {
				++brojLinija;
				boolean ok = obradiAkciju(firma, s);
				if (ok) {
					System.out.println("Greska u liniji " + brojLinija);
				}
			}
			firma.stampajNiz();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public static boolean obradiAkciju(Firma firma, String akcija) {
		String[] t = akcija.split(",");
		String tipAkcije = t[0].trim();
		if (tipAkcije.equals("zaposli")) {
			if (t.length != 4) {
				System.out.println("Greska");
				return false;
			}
			try {
				String id = t[1].trim();
				String ime = t[2].trim();
				int plata = Integer.parseInt(t[3].trim());
				firma.zaposli(id, ime, plata);
			} catch (NumberFormatException nfe) {
				System.out.println("Format plate nije ispravan");
				return false;
			} catch (RadnaOrganizacijaException roe) {
				System.out.println(roe.OpisGreske());
				return false;
			}
			return true;
		} else if (tipAkcije.equals("otpusti")) {
			if (t.length != 2) {
				System.out.println("Greska");
				return false;
			}
			String id = t[1].trim();
			try {
				firma.otpusti(id);
			} catch (RadnaOrganizacijaException roe) {
				System.out.println(roe.OpisGreske());
				return false;
			}
			return true;
		} else {
			System.out.println("Greska");
			return false;
		}
	}

}
