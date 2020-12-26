package VezbeOsme_PrviZadatak;

public class PredatiPrtljag extends Prtljag {

	public PredatiPrtljag(double tezina) {
		super(tezina);
	}

	@Override
	boolean izgubljen() {
		return Math.random() <= 0.1;
	}

}
