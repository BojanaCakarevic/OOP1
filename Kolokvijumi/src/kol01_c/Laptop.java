package kol01_c;

public class Laptop extends Uredjaj {

	private String kvar;

	public Laptop(String boja, double procesor, int ram, double cena, boolean kamera) {
		super(boja, cena, ram, cena, kamera);
	}

	public String getKvar() {
		return kvar;
	}

	public void setKvar(String kvar) {
		this.kvar = kvar;
	}

	@Override
	protected String inicijalizujBoju() {
		return Osobine.BOJA[Osobine.rng.nextInt(3)];
	}

	@Override
	boolean jePotrebanServis() {
		if (Osobine.rng.nextInt(100) <= 5) {
			this.kvar = Osobine.KVAR[Osobine.rng.nextInt(3)];
			System.out.println("Komponenta je pokvarena, potreban servis");
			return true;
		} else {
			System.out.println("Nije potrebna popravka, nema kvara");
			return false;
		}
	}

}
