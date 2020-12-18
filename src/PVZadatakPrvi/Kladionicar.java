package PVZadatakPrvi;

public class Kladionicar {
	private String ime, igra;
	private int stanje;

	public Kladionicar(String ime, String igra, int stanje) {
		this.ime = ime;
		setIgra(igra);
		this.stanje = stanje;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getIgra() {
		return igra;
	}

	public void setIgra(String igra) {
		if (igra.equals("poker") || igra.equals("ajnc") || igra.equals("rulet"))
			this.igra = igra;
		else
			this.igra = "poker";
	}

	public int getStanje() {
		return stanje;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Kladionicar " + ime + " koji igra " + igra + " na racunu ima stanje od " + stanje + " dinara.";
	}
}
