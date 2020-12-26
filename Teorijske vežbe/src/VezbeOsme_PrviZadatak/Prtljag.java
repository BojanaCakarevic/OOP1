package VezbeOsme_PrviZadatak;

public abstract class Prtljag {
	private double tezina;

	public Prtljag(double tezina) {
		if (tezina < 0)
			throw new IllegalArgumentException("Negativna kilaza.");
		this.tezina = tezina;
	}

	public double getTezina() {
		return tezina;
	}

	abstract boolean izgubljen();

}
