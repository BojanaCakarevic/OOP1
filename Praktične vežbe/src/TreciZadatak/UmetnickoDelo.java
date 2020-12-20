package TreciZadatak;

public class UmetnickoDelo {
	private String naziv;
	private int godina;
	private double cena;

	public UmetnickoDelo(String naziv, int godina, double cena) {
		this.naziv = naziv;
		this.godina = godina;
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public int getGodina() {
		return godina;
	}

	public double getCena() {
		return cena;
	}

	public String toString() {
		return "Delo " + naziv + " iz godina " + godina + " kosta " + (int) (cena * 100) / 100.0 + " eura.";
	}

}
