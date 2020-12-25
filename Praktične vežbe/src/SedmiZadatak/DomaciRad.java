package SedmiZadatak;

import java.util.Arrays;

public class DomaciRad {
	private String ime;
	private String[] resenja;
	private int ocena;

	public DomaciRad(String ime, String[] resenja) {
		this.ime = ime;
		this.resenja = resenja;
		this.ocena = 1;
		setOcena(ocena);
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		if (ocena > 0 && ocena <= 5)
			this.ocena = ocena;
		else
			this.ocena = -1;
	}

	public String getIme() {
		return ime;
	}

	public String[] getResenja() {
		return resenja;
	}

	@Override
	public String toString() {
		return "DomaciRad [ime " + ime + ", zadatak " + Arrays.toString(resenja) + ", ocena " + ocena + "]";
	}

}
