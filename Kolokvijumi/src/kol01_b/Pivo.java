package kol01_b;

public abstract class Pivo {

	private int jacina;
	private String boja, tip, proizvodjac;
	
	public Pivo (String proizvodjac, int jacina, String boja, String tip) {
		this.proizvodjac = proizvodjac;
		setJacina(inicijalizujJacinu());
		setBoja(inicijalizujBoju());
		this.tip = tip;
	}
	
	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	abstract int inicijalizujJacinu();

	abstract boolean jeIzlapelo();
	
	public String inicijalizujBoju() {
		if (Osobine.rng.nextInt(3) == 0)
			return Osobine.BOJA[0];
		else if (Osobine.rng.nextInt(3) == 1 )
			return Osobine.BOJA[1];
		else 
			return Osobine.BOJA[2];
	}
	
	public int getJacina() {
		return jacina;
	}
	public void setJacina(int jacina) {
		this.jacina = jacina;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public String toString() {
		return "Pivo [jacina=" + jacina + ", boja=" + boja + ", tip=" + tip + "]";
	}

}
