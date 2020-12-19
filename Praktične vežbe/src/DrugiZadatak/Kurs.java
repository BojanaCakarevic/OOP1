package DrugiZadatak;

public class Kurs {
	private String jezik, nivo;
	private int brPolaznika;

	public Kurs(String jezik, String nivo, int brPolaznika) {
		this.jezik = jezik;
		setNivo(nivo);
		setBrPolaznika(brPolaznika);
	}

	public String getJezik() {
		return jezik;
	}

	public void setJezik(String jezik) {
		this.jezik = jezik;
	}

	public String getNivo() {
		return nivo;
	}

	public void setNivo(String nivo) {
		if (nivo.equals("osnovni") || nivo.equals("srednji") || nivo.equals("napredni"))
			this.nivo = nivo;
		else
			this.nivo = "osnovni";
	}

	public int getBrPolaznika() {
		return brPolaznika;
	}

	public void setBrPolaznika(int brPolaznika) {
		if (brPolaznika < 0)
			this.brPolaznika = 0;
		else
			this.brPolaznika = brPolaznika;
	}

	public String toString() {
		return "Jezik " + jezik + " na " + nivo + " nivou ima " + brPolaznika + "polaznika";
	}

}
