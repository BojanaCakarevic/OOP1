package PrviDomaci;

public class Kosarkas {
	private String imeiprezime, pozicija;
	double korisnost;

	public Kosarkas(String imeiprezime, String pozicija, double korisnost) {
		this.imeiprezime = imeiprezime;
		setPozicija(pozicija);
		this.korisnost = korisnost;
	}

	public String getImeiprezime() {
		return imeiprezime;
	}

	public void setImeiprezime(String imeiprezime) {
		this.imeiprezime = imeiprezime;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		if (pozicija.equals("bek") || pozicija.equals("krilo") || pozicija.equals("centar"))
			this.pozicija = pozicija;
		else
			this.pozicija = "bek";
	}

	public double getKorisnost() {
		return korisnost;
	}

	public void setKorisnost(double korisnost) {
		this.korisnost = korisnost;
	}

	@Override
	public String toString() {
		return "Kosarkas " + imeiprezime + " je na poziciji " + pozicija + " i indeks njegove korisnosti je "
				+ korisnost + ".";
	}

}
