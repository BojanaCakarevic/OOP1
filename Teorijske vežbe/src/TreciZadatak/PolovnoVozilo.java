package TreciZadatak;

public abstract class PolovnoVozilo {
	private int starost;

	public PolovnoVozilo(int starost) {
		this.starost = starost;
	}

	public int getStarost() {
		return starost;
	}

	abstract int cena();

	abstract String opisVozila();

	protected int baznaCena() {
		if (starost > 20)
			return 400;
		else
			return 70 * starost;
	}

	@Override
	public String toString() {
		return "PolovnoVozilo [starost=" + starost + "]";
	}

}
