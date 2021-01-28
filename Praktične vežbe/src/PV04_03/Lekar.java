package PV04_03;

public abstract class Lekar {

	private String imeLekara, prezimeLekara;
	private Pacijent[] pacijenti;
	private int brPacijenata;
	private int maks;

	public Lekar(String imeLekara, String prezimeLekara, int maks) {
		this.imeLekara = imeLekara;
		this.prezimeLekara = prezimeLekara;
		this.pacijenti = new Pacijent[maks];
		this.brPacijenata = 0;
	}

	public String getImeLekara() {
		return imeLekara;
	}

	public String getPrezimeLekara() {
		return prezimeLekara;
	}

	public Pacijent[] getPacijenti() {
		return pacijenti;
	}

	public int getBrPacijenata() {
		return brPacijenata;
	}

	public int getMaks() {
		return maks;
	}

	public boolean prihvati(Pacijent p) {
		if (brPacijenata < maks) {
			pacijenti[brPacijenata + 1] = p;
			brPacijenata++;
			return true;
		} else
			return false;
	}

	public abstract int plata();

	public String toString() {
		return getClass().toString();
	}

}
