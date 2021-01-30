package kol01_a;

public class Converse extends Nike {

	public Converse(int broj, String brend) {
		super(broj, "Converse");
		setCena(inicijalizujCenu() * 1.1);
		setBoja(inicijalizujBoju());
	}

	@Override
	public String inicijalizujBoju() {
		if (Osobine.rng.nextInt(2) == 0)
			return Osobine.BOJA[0];
		else if (Osobine.rng.nextInt(2) == 1)
			return Osobine.BOJA[1];
		else if (Osobine.rng.nextInt(2) == 2)
			return Osobine.BOJA[2];
		else if (Osobine.rng.nextInt(2) == 3)
			return Osobine.BOJA[3];
		else 
			return Osobine.BOJA[4];
	}
	
}
