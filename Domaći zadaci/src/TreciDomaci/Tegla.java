package TreciDomaci;

public class Tegla {
	private double zapremina, tezina;
	private String sadrzaj;

	public Tegla(double zapremina, double tezina, String sadrzaj) {
		this.zapremina = zapremina;
		this.tezina = tezina;
		this.sadrzaj = sadrzaj;
	}

	public double getZapremina() {
		return zapremina;
	}

	public double getTezina() {
		return tezina;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	@Override
	public String toString() {
		return "Tegla zapremine " + zapremina + " ima tezinu " + (int)(tezina*100)/100.0  + ", a sadrzaj joj je: " + sadrzaj ;
	}

}
