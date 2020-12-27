package VezbeDevete_PrviZadatak;

public class RadnaOrganizacijaException extends Exception {

	private static final long serialVersionUID = 1L;

	public enum TipGreske {
		ZAPOSLJAVANJE, OTPUSTANJE;
	}

	private TipGreske t;
	private String opis;

	public RadnaOrganizacijaException(TipGreske t, String opis) {
		super(opis);
		this.t = t;
		this.opis = opis;
	}

	public TipGreske getT() {
		return t;
	}

	public String OpisGreske() {
		if (t == TipGreske.ZAPOSLJAVANJE)
			return "Greska je nastala pri zaposljavanju " + opis;
		else
			return "Greska nastala pri otpustanju " + opis;
	}

}
