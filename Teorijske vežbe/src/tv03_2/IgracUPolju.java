package tv03_2;

public class IgracUPolju extends Fudbaler {

	public IgracUPolju(String ime, boolean prvaPostava, double km) {
		super(ime, prvaPostava);
		this.km = km;
	}

	private double km;

	public double getKm() {
		return km;
	}
	
	public String toString() {
		return super.toString() + ", pretrci  " + km + "km.";
	}
	
}
