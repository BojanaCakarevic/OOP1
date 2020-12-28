package PetiZadatak;

public class Voce {
	private String naziv;
	private double zapremina;

	public Voce(String naziv, double zapremina) {
		this.naziv = naziv;
		this.zapremina = zapremina;
	}

	public String getNaziv() {
		return naziv;
	}

	public double getZapremina() {
		return zapremina;
	}

	@Override
	public String toString() {
		return naziv + " ima zapreminu zapremina " + zapremina;
	}

}
