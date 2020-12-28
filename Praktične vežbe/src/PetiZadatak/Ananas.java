package PetiZadatak;

public class Ananas extends Voce {

	public Ananas(String naziv, double zapremina) {
		super("Ananas", zapremina);
	}

	@Override
	public double getZapremina() {
		return super.getZapremina() * 0.5;
	}

}
