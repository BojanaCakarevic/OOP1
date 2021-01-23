package tv03_2;

public final class SredisnjiIgrac extends IgracUPolju {

	private int brAsistencija;
	
	public SredisnjiIgrac(String ime, boolean prvaPostava, double km, int brAsistencija) {
		super(ime, prvaPostava, km);
		this.brAsistencija = brAsistencija;
	}

	public int getBrAsistencija() {
		return brAsistencija;
	}

	@Override
	public String toString() {
		return super.toString() + " Tokom sezone ima " + brAsistencija + " asistencija";
	}
	
}
