package VezbeOsme_PrviZadatak;

public class Let {
	private String naziv;
	private int nosivost;
	private Putnik[] putnici;

	public Let(String naziv, int nosivost, Putnik[] putnici) throws VisakTereta {
		this.naziv = naziv;
		this.nosivost = nosivost;
		this.putnici = putnici;

		int ukupno = 0;
		for (int i = 0; i < putnici.length; i++) {
			ukupno += putnici[i].getPredati().getTezina();
			ukupno += putnici[i].getRucni().getTezina();
			if (ukupno > nosivost)
				throw new VisakTereta(naziv);
		}
	}

	public int izgubljenPrtljag() {
		int ukupno = 0;

		for (int i = 0; i < putnici.length; i++) {
			PredatiPrtljag pp = putnici[i].getPredati();
			if (pp.izgubljen()) {
				ukupno += pp.getTezina();
			}
		}
		return ukupno;
	}

	@Override
	public String toString() {
		return "Naziv leta je " + naziv + ", a nosivost " + nosivost;
	}

}
