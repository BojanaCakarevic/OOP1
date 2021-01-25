package kolokvijum01_02;

public abstract class Uredjaj {

	private double jacinaProcesora;
	private int kolicinaRAMa;
	private boolean kamera;
	private double cena;
	private String boja;
	
	public double getJacinaProcesora() {
		return jacinaProcesora;
	}

	public void setJacinaProcesora(double jacinaProcesora) {
		this.jacinaProcesora = jacinaProcesora;
	}

	public int getKolicinaRAMa() {
		return kolicinaRAMa;
	}

	public void setKolicinaRAMa(int kolicinaRAMa) {
		this.kolicinaRAMa = kolicinaRAMa;
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
		if (boja.equals("crna") || boja.equals("bela") || boja.equals("siva"))
			this.boja = boja;
		else
			this.boja = "bela";
	}

	abstract boolean jePotrebanServis();

	@Override
	public String toString() {
		return "Uredjaj [jacinaProcesora=" + jacinaProcesora + ", kolicinaRAMa=" + kolicinaRAMa + ", kamera=" + kamera
				+ ", cena=" + cena + ", boja=" + boja + "]";
	}
	
}
