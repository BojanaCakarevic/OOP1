package TreciZadatak;

public class PolovniKombi extends PolovnoVozilo {

	private int brSedista;

	public PolovniKombi(int starost, int brSedista) {
		super(starost);
		this.brSedista = brSedista;
	}

	@Override
	int cena() {
		return baznaCena() + 50 * brSedista;
	}

	@Override
	String opisVozila() {
		return "Kombi starosti" + getStarost() + " ima " + brSedista + " sedista";
	}

	@Override
	public String toString() {
		return "PolovniKombi [brSedista=" + brSedista + ", starost= " + getStarost() + "]";
	}

	
	
}
