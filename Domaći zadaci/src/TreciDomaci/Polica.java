package TreciDomaci;

public class Polica {
	private String ime;
	private int brRedova;
	private double maksOpterecenje, trenutnoOpterecenje;
	private Tegla[] tegle;
	private int brTegli;

	public Polica(String ime, int brRedova, double maksOpterecenje) {
		this.ime = ime;
		this.brRedova = brRedova;
		this.maksOpterecenje = maksOpterecenje;
		setTrenutnoOpterecenje(trenutnoOpterecenje);

		this.tegle = new Tegla[10];
		this.brTegli = 0;
	}

	public double getTrenutnoOpterecenje() {
		return trenutnoOpterecenje;
	}

	public void setTrenutnoOpterecenje(double trenutnoOpterecenje) {
		this.trenutnoOpterecenje = trenutnoOpterecenje;
	}

	public String getIme() {
		return ime;
	}

	public int getBrRedova() {
		return brRedova;
	}

	public double getMaksOpterecenje() {
		return maksOpterecenje;
	}

	public Tegla[] getTegle() {
		return tegle;
	}

	public int getBrTegli() {
		return brTegli;
	}
	
	public void setBrTegli(int brTegli) {
		this.brTegli = brTegli;
	}

	public boolean dodajTeglu(Tegla t) {
		if (brTegli + 1 < tegle.length) {
			tegle[brTegli++] = t;
			trenutnoOpterecenje += t.getTezina();
			return true;
		} else
			return false;
	}

	public double ukupnaZapremina() {
		double zapremina = 0.0;
		for (int i = 0; i < tegle.length; i++) {
			zapremina += tegle[i].getZapremina();
		}
		return zapremina;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + ime;
	}

}
