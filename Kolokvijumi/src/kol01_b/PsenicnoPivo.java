package kol01_b;

public class PsenicnoPivo extends Pivo {
	
	private boolean jePitko;

	public PsenicnoPivo(String proizvodjac, String tip) {
		super(" ", 0, " ", "psenicno");
		setProizvodjac(proizvodjac);
		setBoja(inicijalizujBoju());
		setJacina(inicijalizujJacinu());
		this.jePitko = !jeIzlapelo();
	}

	@Override
	boolean jeIzlapelo() {
		if (Osobine.rng.nextInt(100) <= 90)
			return false;
		else
			return true;
	}

	@Override
	int inicijalizujJacinu() {
		return Osobine.rng.nextInt() + 5;
	}
	
	@Override
	public String inicijalizujBoju() {
		if (Osobine.rng.nextInt(5) == 1)
			return Osobine.BOJA[0];
		else
			return Osobine.BOJA[1];
	}


}
