package DrugiZadatak;

public final class Direktor extends Radnik {
	public Direktor(String id, int radnistaz, double plata) {
		super(id, radnistaz, plata, null);
	}

	public String toString() {
		return "Direktor " + super.toString();
	}
}
