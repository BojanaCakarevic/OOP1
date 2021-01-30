package kol01_a;


public abstract class Patike {

	private String tip, vrsta, boja;
	private double cena;
	private int broj;
	private String brend;
	
	public Patike(String tip, String vrsta, String boja, double cena, int broj, String brend) {
		this.tip = tip;
		this.vrsta = vrsta;
		this.boja = boja;
		this.cena = cena;
		this.broj = broj;
		this.brend = brend;
	}

	public String getTip() {
		return tip;
	}
	
	public String inicijalizujBoju() {
		if (Osobine.rng.nextInt(3) == 0)
			return Osobine.BOJA[0];
		else if (Osobine.rng.nextInt(3) == 1)
			return Osobine.BOJA[1];
		else
			return Osobine.BOJA[2];
	}
	
	public String inicijalizujVrstu() {
		if (Osobine.rng.nextInt(5) == 0)
			return Osobine.VRSTA[0];
		else
			return Osobine.VRSTA[1];
	}
	
	public double inicijalizujCenu() {
		if (vrsta.equals(Osobine.VRSTA[1]))
			return Osobine.rng.nextInt() * 500 + 2000;
		else
			return Osobine.rng.nextInt() * 5000 + 7000;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getBrend() {
		return brend;
	}

	public void setBrend(String brend) {
		this.brend = brend;
	}

	@Override
	public String toString() {
		return "Patike [tip=" + tip + ", vrsta=" + vrsta + ", boja=" + boja + ", cena=" + (int)(cena * 100) / 100.0 + ", broj=" + broj
				+ ", brend=" + brend + "]";
	}
	
}
