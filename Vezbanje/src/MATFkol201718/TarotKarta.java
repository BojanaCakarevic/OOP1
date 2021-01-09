package MATFkol201718;


public class TarotKarta {
	private int vreme;
	private String opis, poreklo;

	public TarotKarta(int vreme, String opis, String poreklo) {
		setVreme(vreme);
		this.opis = opis;
		this.poreklo = poreklo;
	}

	public int getVreme() {
		return vreme;
	}

	public void setVreme(int vreme) {
		if (vreme == -1 || vreme == 0 || vreme == 1)
			this.vreme = vreme;
		else
			this.vreme = 0;
	}

	public String getOpis() {
		return opis;
	}

	public String getPoreklo() {
		return poreklo;
	}

	@Override
	public String toString() {
		String vremeString = "";
		if (vreme == 0)
			vremeString = "sadasnjost";
		if (vreme == -1)
			vremeString = "proslost";
		if (vreme == 1)
			vremeString = "buducnost";
		return "[tarot karta] vreme: " + vremeString + ", opis: " + opis + ", poreklo: " + poreklo;
	}
}
