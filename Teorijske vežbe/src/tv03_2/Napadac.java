package tv03_2;

public final class Napadac extends IgracUPolju {
	
	private int postignutiGolovi;

	public Napadac(String ime, boolean prvaPostava, double km, int postignutiGolovi) {
		super(ime, prvaPostava, km);
		this.postignutiGolovi = postignutiGolovi;
	}

	public int getPostignutiGolovi() {
		return postignutiGolovi;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Tokom sezona postigne " + postignutiGolovi + " golova.";
	}

}
