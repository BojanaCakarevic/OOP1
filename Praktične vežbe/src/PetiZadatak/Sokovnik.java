package PetiZadatak;

public class Sokovnik implements Kontejner, Cedaljka {

	private Voce[] voce;
	private int brojVoca;
	private double ukupnaZapremina;

	public Sokovnik(Voce[] voce, double ukupnaZapremina) {
		this.voce = new Voce[voce.length];
		this.brojVoca = 0;
		this.ukupnaZapremina = ukupnaZapremina;
		double ubaceno = 0.0;
		for (int i = 0; i < voce.length && ubaceno + voce[i].getZapremina() <= ukupnaZapremina; i++) {
			if (voce[i] instanceof Jabuka && ((Jabuka) voce[i]).isCrvljiva()) {
				continue;
			} else {
				this.voce[brojVoca++] = voce[i];
				ubaceno += voce[i].getZapremina();
			}
		}
	}

	@Override
	public void cedi() {
		System.out.println("Cedi se...");
		for (int i = 0; i < brojVoca; i++) {
			System.out.println(voce[i++]);
		}
	}

	@Override
	public double zapremina() {
		return ukupnaZapremina;
	}

	@Override
	public int komada() {
		return brojVoca;
	}

}
