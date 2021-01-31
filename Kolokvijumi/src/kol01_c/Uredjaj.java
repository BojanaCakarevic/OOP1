package kol01_c;

public abstract class Uredjaj {

	public double procesor;
	public int ram;
	public boolean kamera;
	public double cena;
	public String boja;

	public Uredjaj(String boja, double procesor, int ram, double cena, boolean kamera) {
		this.procesor = procesor;
		this.ram = ram;
		this.kamera = kamera;
		this.cena = cena;
		setBoja(inicijalizujBoju());
	}

	protected abstract String inicijalizujBoju();

	abstract boolean jePotrebanServis();

	public double getProcesor() {
		return procesor;
	}

	public void setProcesor(double procesor) {
		this.procesor = procesor;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public boolean isKamera() {
		return kamera;
	}

	public void setKamera(boolean kamera) {
		this.kamera = kamera;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

}
