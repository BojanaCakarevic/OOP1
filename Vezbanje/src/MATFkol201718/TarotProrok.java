package MATFkol201718;


public class TarotProrok extends Prorok {
	private TarotKarta[] karte;
	private int i;

	public TarotProrok(String ime, int ostvarenaPror, int ukupnoPror, TarotKarta[] karte) {
		super(ime, ostvarenaPror, ukupnoPror);
		this.karte = karte;
	}

	public TarotKarta[] getKarte() {
		return karte;
	}

	TarotKarta izvuciKartu() {
		TarotKarta tk = karte[i];
		i = (i + 1) % karte.length;
		return tk;
	}

	String proreci(TarotKarta tk) {
		String vreme = "sadasnjost";
		if (tk.getVreme() == 1)
			vreme = "buducnost";
		if (tk.getVreme() == -1)
			vreme = "proslost";
		return vreme + " " + tk.getOpis();
	}

	@Override
	public String toString() {
		return "[tarot prorok]" + super.toString() + ", poseduje karata " + karte.length;
	}

}
