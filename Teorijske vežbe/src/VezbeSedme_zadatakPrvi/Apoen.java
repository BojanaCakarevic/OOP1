package VezbeSedme_zadatakPrvi;

public enum Apoen {
	JEDAN(1, "1$"),
	DVA(2, "2$"),
	PET(5, "5$"),
	DESET(10, "10$"),
	DVADESET_PET(25, "25$"),
	PEDESET(50, "50$"),
	STO(100, "100$");
	
	private int vrednost;
	private String opis;
	
	private Apoen(int vrednost, String opis) {
		this.vrednost = vrednost;
		this.opis = opis;
	}

	public int getVrednost() {
		return vrednost;
	}

	public String getOpis() {
		return opis;
	}
}
