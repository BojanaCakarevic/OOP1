package DrugiZadatak;

public class Radnik {
	private String id;
	private int radnistaz;
	private double plata;
	private Radnik nadredjeni;

	public Radnik(String id, int radnistaz, double plata, Radnik nadredjeni) {
		this.id = id;
		this.radnistaz = radnistaz;
		this.plata = plata;
		this.nadredjeni = nadredjeni;
	}

	public String getId() {
		return id;
	}

	public int getRadnistaz() {
		return radnistaz;
	}

	public double getPlata() {
		return plata;
	}

	public Radnik getNadredjeni() {
		return nadredjeni;
	}

	public String toString() {
		return "Radnik " + id + " ima radni staz od " + radnistaz + " godina, i platu " + plata + " dinara.";
	}

}
