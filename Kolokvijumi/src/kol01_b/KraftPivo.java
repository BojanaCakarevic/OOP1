package kol01_b;

public class KraftPivo extends Pivo {
	
		private boolean jePitko;

	public KraftPivo(String proizvodjac, String tip) {
		super(" ", 0, " ", "kraft");
		setProizvodjac(proizvodjac);
		setJacina(inicijalizujJacinu());
		setBoja(inicijalizujBoju());
		this.jePitko = !jeIzlapelo();
	}
	
	@Override
	boolean jeIzlapelo() {
		if (Osobine.rng.nextInt() < Osobine.rng.nextInt() * 20 + 70)
			return false;
		else
			return true;
	}

	@Override
	int inicijalizujJacinu() {
		return Osobine.rng.nextInt() * 5 + 6;
	}

}
