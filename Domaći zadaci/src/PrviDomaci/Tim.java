package PrviDomaci;

public class Tim {
	private Kosarkas[] kosarkasi;

	public Tim(Kosarkas[] kosarkasi) {
		this.kosarkasi = kosarkasi;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < kosarkasi.length; i++) {
			s += kosarkasi[i].toString() + "\n";
		}
		return s;
	}

	String najkorisnijiIgracNaTerenu() {
		String najkorisniji = "";
		double maks = 0.0;
		for (int i = 0; i < kosarkasi.length; i++) {
			if (kosarkasi[i].getKorisnost() >= maks)
				maks = kosarkasi[i].getKorisnost();
			najkorisniji = kosarkasi[i].getImeiprezime();
		}
		return najkorisniji;
	}

}
