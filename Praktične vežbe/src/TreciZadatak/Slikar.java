package TreciZadatak;
import java.util.Scanner;


public class Slikar extends Umetnik {

	private Scanner scanner;

	public Slikar(String ime) {
		super(ime, 5);
	}

	@Override
	public double vrednost() {
		scanner = new Scanner( System.in );
		 System.out.print("Unesite trenutnu godinu: ");
		int  trenutnaGodina = scanner.nextInt(); 
			double ukupno = 0.0;
			for (int i = 0; i < getBrojDela(); i++) {
				double uvecanaCena = (getDela()[i].getCena() * 0.15);
				ukupno += getDela()[i].getCena() + ( uvecanaCena * (trenutnaGodina - getDela()[i].getGodina()));
			}
			return ukupno;
		}
	}


