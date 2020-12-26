package VezbeOsme_PrviZadatak;

public class Putnik {
	private String ime;
	private RucniPrtljag rucni;
	private PredatiPrtljag predati;

	public Putnik(String ime, RucniPrtljag rucni, PredatiPrtljag predati) {
		this.ime = ime;
		this.rucni = rucni;
		this.predati = predati;
	}

	public String getIme() {
		return ime;
	}

	public RucniPrtljag getRucni() {
		return rucni;
	}

	public PredatiPrtljag getPredati() {
		return predati;
	}

	@Override
	public String toString() {
		return "Putnik [ime=" + ime + ", rucni=" + rucni + ", predati=" + predati + "]";
	}

}
