package VezbeOsme_PrviZadatak;

public class VisakTereta extends Exception {

	private static final long serialVersionUID = 1L;

	public VisakTereta(String nazivLeta) {
		super("Visak tereta je na letu " + nazivLeta);
	}
}
