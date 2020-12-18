package ZadatakDrugi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RadnaOrganizacija {
	private Radnik[] radnici;
	
	public RadnaOrganizacija(String spisak) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(spisak));
		
		int brRadnika = Integer.parseInt(br.readLine());
		radnici = new Radnik[brRadnika];
	
		for(int i = 0; i < brRadnika; i++) {
			String[] s = br.readLine().split(",");
			
			String id = s[0].trim();
			int radniStaz = Integer.parseInt(s[1].trim());
			double plata = Double.parseDouble(s[2].trim());
				
			if(s.length == 4) {
			    String idNadr = s[3].trim();
			    Radnik nadredjeni = pronadjiNadredjenog(idNadr);
			    if(nadredjeni == null) {
			    	br.close();
			    	throw new IOException("Greska u ulaznom fajlu.");
			    }
				radnici[i] = new Radnik(id, radniStaz, plata, nadredjeni);
			} else
				radnici[i] = new Direktor(id, radniStaz, plata);
		}
		br.close();
	}
	
	private Radnik pronadjiNadredjenog(String idNadr) {
		for(int i = 0; i < radnici.length; i++) {
			if(radnici[i].getId().compareTo(idNadr) == 0) 
				return radnici[i];
		}
		return null;
	}
	
	void stampajSveNadredjene(String id) {
		Radnik radnik = null;
		for(int i = 0; i < radnici.length; i++) {
			if(radnici[i].getId().compareTo(id) == 0) {
				radnik = radnici[i];
				break;
			}
		}
		
		if(radnik == null)
			System.out.println("Radnik " + id + " ne postoji.");
		else if( radnik instanceof Direktor)
			System.out.println("Radnik " + id + " je direktor.");
		else {
			System.out.println("Nadredjeni radnika " + id + " su: ");
			Radnik nadredjeni = radnik.getNadredjeni();
			while (nadredjeni != null) {
				System.out.println(nadredjeni.getId());
				nadredjeni = nadredjeni.getNadredjeni();
			}
		}
	}
	
	void plataNadredjenogManja() {
		for(int i = 0; i < radnici.length; i++) {
			Radnik radnik = radnici[i];
			if(!(radnik instanceof Direktor)) {
				Radnik nadredjeni = radnik.getNadredjeni();
				if(radnik.getPlata() > nadredjeni.getPlata()) {
					int razlika = (int) ((int) radnik.getPlata() - nadredjeni.getPlata());
					System.out.println("Radnik " + radnik.getId() + " ima za " + razlika + 
							" dinara vecu platu od svog nadredjenog, " +
							nadredjeni.getId());
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		RadnaOrganizacija ro = new RadnaOrganizacija("res\\radnici.txt");
		ro.stampajSveNadredjene("Rale");
		ro.plataNadredjenogManja();
	}
	
}
