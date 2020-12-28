package PetiZadatak;

public class Jabuka extends Voce {

	public Jabuka(String naziv, double zapremina, boolean crvljiva) {
		super("Jabuka", zapremina);
		this.crvljiva = crvljiva;
	}

	private boolean crvljiva;

	public boolean isCrvljiva() {
		return crvljiva;
	}
}
