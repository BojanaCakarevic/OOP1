package PVZadatakPrvi;

public class Kazino {
	private Kladionicar[] kladionicari;

	public Kazino(Kladionicar[] kladionicari) {
		this.kladionicari = kladionicari;
	}

	@Override
	public String toString() {
		String s = " ";
		for (int i = 0; i < kladionicari.length; i++) {
			s += kladionicari[i].toString() + "\n";
		}
		return s;
	}

	String najprofitnijaIgra() {
		int ajnc = 0;
		int rulet = 0;
		int poker = 0;
		for (int i = 0; i < kladionicari.length; i++) {
			if (kladionicari[i].getIgra().equals("ajnc") && kladionicari[i].getStanje() < 0) {
				ajnc++;
			} else if (kladionicari[i].getIgra().equals("rulet") && kladionicari[i].getStanje() < 0)
				rulet++;
			else if (kladionicari[i].getStanje() < 0)
				poker++;
		}
		if (ajnc >= poker && ajnc >= rulet)
			return "Najprofitnija igra je ajnc.";
		else if (rulet >= poker && rulet >= ajnc)
			return "Najprofitnija igra je rulet.";
		else
			return "Najprofitnija igra je poker.";
	}
}
