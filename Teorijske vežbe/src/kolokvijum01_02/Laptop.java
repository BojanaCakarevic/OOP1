package kolokvijum01_02;

public class Laptop extends Uredjaj {

	private String pokvaren;

	public Laptop(double jacinaProcesora, int kolicinaRAMa, boolean kamera, double cena, String boja) {
		this.setJacinaProcesora(jacinaProcesora);
		this.setKolicinaRAMa(kolicinaRAMa);
		this.setKamera(kamera);
		this.setCena(cena);
		this.setBoja(boja);
	}
	
	public String getPokvaren() {
		return pokvaren;
	}

	public void setPokvaren(String pokvaren) {
		this.pokvaren = pokvaren;
	}

	@Override
	boolean jePotrebanServis() {

		if (this.pokvaren == null) {
			if (Util.rng.nextDouble() < 0.05) {
				this.pokvaren = Util.VEROVATNOCA[Util.rng.nextInt(3)];
				System.out.printf("Komponenta je pokvarena, potreban servis", this.pokvaren);
			} else
				this.pokvaren = " ";
		}
			return this.pokvaren != " ";
	}

}
