package TreciZadatak;

public class PolovnoAuto extends PolovnoVozilo {

	private int brVrata;

	public PolovnoAuto(int starost, int brVrata) {
		super(starost);
		this.brVrata = brVrata;
	}

	@Override
	int cena() {
		if (brVrata > 3)
			return baznaCena();
		else
			return (int) 0.95 * baznaCena();
	}

	@Override
	String opisVozila() {
		return "Automobil sa " + brVrata + " ima starost " + getStarost();
	}

	@Override
	public String toString() {
		return "PolovnoAuto [brVrata=" + brVrata + "]";
	}

	
}
