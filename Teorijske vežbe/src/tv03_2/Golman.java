package tv03_2;

public final class Golman extends Fudbaler {

	public Golman(String ime, boolean prvaPostava, int brGolova) {
		super(ime, prvaPostava);
		this.brGolova = brGolova;
	}

	private int brGolova;

	public int getBrGolova() {
		return brGolova;
	}

	@Override
	public String toString() {
		return "Golman " + super.toString() + " ima " + brGolova + " golova.";
	}
}
