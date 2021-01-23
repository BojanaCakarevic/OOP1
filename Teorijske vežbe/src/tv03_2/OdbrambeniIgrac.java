package tv03_2;

public final class OdbrambeniIgrac extends IgracUPolju {

	private int brKartona;
	
	public OdbrambeniIgrac(String ime, boolean prvaPostava, double km, int brKartona) {
		super(ime, prvaPostava, km);
		this.brKartona = brKartona;
	}

	public int getBrKartona() {
		return brKartona;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Tokom sezone dobije " + brKartona + " kartona";
	}

}
