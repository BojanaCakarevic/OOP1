package Online_prodavnica;

import java.util.Random;

abstract public class Patike {
	
	private String tip, vrsta, boja, marka;
	private int cena, broj;
	
	public Patike(String marka, int broj) {
		this.marka = marka;
		this.broj = broj;
		setTip(inicijalizujTip());
		setBoja(inicijalizujBoju());
		setVrsta(inicijalizujVrstu());
		setCena(inicijalizujCenu());
	}
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	@Override
	public String toString() {
		return "Patike [tip=" + tip + ", vrsta=" + vrsta + ", boja=" + boja + ", marka=" + marka + ", cena=" + cena
				+ ", broj=" + broj + "] \n";
	}

	protected abstract String inicijalizujTip();
	
	protected String inicijalizujBoju() {
		Random r = new Random();
		int procenat = r.nextInt(3);
		
		if (procenat == 0) 
			return "BELA";
		else if (procenat == 1)
			return "CRNA";
		return "CRVENA";
	}
	
	protected String inicijalizujVrstu() {
		Random r = new Random();
		int procenat = r.nextInt(100);
		if(procenat <= 100)
			return "ODRASLI";
		return "DECIJE";
	}
	
	protected int inicijalizujCenu() {
		if(this.vrsta.equals("ODRASLI")) {
			Random r = new Random();
			int cena = 7000;
			cena += r.nextInt()*cena;
			return cena;
		} else {
			return cena;
		}
	}
	
}
