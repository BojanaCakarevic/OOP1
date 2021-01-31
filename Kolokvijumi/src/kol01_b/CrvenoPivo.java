package kol01_b;

public class CrvenoPivo extends Pivo {
	
	private boolean jePitko;

	public CrvenoPivo(String proizvodjac, String tip) {
		super(" ", 0, " ", "crveno");
		setProizvodjac(proizvodjac);
		setJacina(inicijalizujJacinu());
		setBoja(Osobine.BOJA[2]);
		this.jePitko = !jeIzlapelo();
	}

	@Override
	boolean jeIzlapelo() {
		if (Osobine.rng.nextInt(5) == 0)
			return false;
		else
			return true;
	}

	@Override
	int inicijalizujJacinu() {
		return 7;
	}

}
