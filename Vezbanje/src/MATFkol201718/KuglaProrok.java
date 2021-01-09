package MATFkol201718;

public class KuglaProrok extends Prorok {

	private String tip;

	public void setTip(String tip) {
		if (tip.equals("monociklicni") || tip.equals("tetragonalni") || tip.equals("kineski"))
			this.tip = tip;
		else
			this.tip = "kineski";
	}

	private static String[] reciProrocanstvo = { "Godine 2020. bice 2020. godina!",
			"Sledece godine iPhone ce biti jos skuplji.", "Sutra ce biti vrucina.",
			"Godine 2018. na kolokvijumu iz OOP-a nece biti polimorfizma" };

	public KuglaProrok(String ime, int ostvarenaPror, int ukupnoPror, String tip) {
		super(ime, ostvarenaPror, ukupnoPror);
		this.tip = tip;
	}

	public String getTip() {
		return tip;
	}

	public static int i;

	String prorekni() {
		String prorocanstvo = reciProrocanstvo[i];
		i = (i + 1) % reciProrocanstvo.length;
		return prorocanstvo;
	}

	@Override
	public String toString() {
		return "[kugla prorok] " + super.toString() + " tip kristala: " + tip;
	}
}
