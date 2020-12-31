package VezbeDevete_TreciZadatak;

public class Disk {
	private String izvodjac;
	private int trajanje, kvalitetMaterijala;

	public Disk(String izvodjac, int trajanje, int kvalitetMaterijala) {
		this.izvodjac = izvodjac;
		this.trajanje = trajanje;
		this.kvalitetMaterijala = kvalitetMaterijala;
	}

	public boolean unisten() {
		return kvalitetMaterijala == 0;
	}

	public void smanjiKvalitet() {
		if (kvalitetMaterijala > 0)
			kvalitetMaterijala--;
	}

	public String toString() {
		return izvodjac + ", " + trajanje + ", " + kvalitetMaterijala;
	}
}
