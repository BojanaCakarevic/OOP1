package SedmiZadatak;

public class FaliZadatak extends Exception {

	private DomaciRad domaciRad;

	public FaliZadatak(DomaciRad rad) {
		this.domaciRad = rad;
	}

	@Override
	public String getMessage() {
		return "Nama dovoljno predatih zadataka za rad - " + domaciRad;
	}

}
