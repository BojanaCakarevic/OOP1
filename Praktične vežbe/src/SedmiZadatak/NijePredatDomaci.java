package SedmiZadatak;

public class NijePredatDomaci extends Exception {

	public NijePredatDomaci(String ime, String predmet) {
		super(ime + " fali domaci iz - " + predmet);
	}
}
