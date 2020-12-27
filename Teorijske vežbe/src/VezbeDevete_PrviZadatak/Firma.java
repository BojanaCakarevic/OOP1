package VezbeDevete_PrviZadatak;

public class Firma implements RadnaOrganizacija {

	private class Radnik {
		String id, ime;
		int plata;

		public Radnik(String id, String ime, int plata) {
			this.id = id;
			this.ime = ime;
			this.plata = plata;
		}

		@Override
		public String toString() {
			return "Radnik id - " + id + ", ima ime " + ime + ", i platu " + plata;
		}
	}

	private int maksZaposlenih, brojZaposlenih;
	private Radnik[] radnici;

	public void zaposli(String id, String ime, int plata) throws RadnaOrganizacijaException {
		if (brojZaposlenih == maksZaposlenih)
			throw new RadnaOrganizacijaException(RadnaOrganizacijaException.TipGreske.ZAPOSLJAVANJE,
					"Firma vec ima dovoljno zaposlenih.");
		if (pretrazi(id) != -1)
			throw new RadnaOrganizacijaException(RadnaOrganizacijaException.TipGreske.ZAPOSLJAVANJE,
					"Ovaj radnik vec postoji.");
		radnici[brojZaposlenih++] = new Radnik(id, ime, plata);
	}

	public void otpusti(String id) throws RadnaOrganizacijaException {
		if (brojZaposlenih == 0)
			throw new RadnaOrganizacijaException(RadnaOrganizacijaException.TipGreske.OTPUSTANJE,
					"U firmi trenutno nema radnika");
		int pozicija = pretrazi(id);
		if (pozicija == -1)
			throw new RadnaOrganizacijaException(RadnaOrganizacijaException.TipGreske.OTPUSTANJE,
					"Ovaj radnik ne postoji");

		for (int i = pozicija; i < brojZaposlenih - 1; i++) {
			radnici[i] = radnici[i + 1];
		}
		--brojZaposlenih;
	}

	public Firma(int maksZaposlenih) {
		this.maksZaposlenih = maksZaposlenih;
		brojZaposlenih = 0;
		radnici = new Radnik[maksZaposlenih];
	}

	private int pretrazi(String id) {
		for (int i = 0; i < brojZaposlenih; i++) {
			if (radnici[i].id.equals(id))
				return i;
		}
		return -1;
	}

	public void stampajNiz() {
		System.out.println("Svi zaposleni:");
		for (int i = 0; i < brojZaposlenih; i++)
			System.out.println(radnici[i]);
	}

}
