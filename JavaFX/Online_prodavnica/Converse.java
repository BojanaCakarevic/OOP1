package Online_prodavnica;

import java.util.Random;

public class Converse extends Nike {

	public Converse(String marka, int broj) {
		super(marka, broj);
	}

	protected int inicijalizujCenu() {
		return (int) (super.inicijalizujCenu() * 1.1);
	}

	protected String inicijalizujBoju() {
		Random r = new Random();
		int procenat = r.nextInt(2);
		if (procenat == 0)
			return "BELA";
		if (procenat == 1)
			return "CRNA";
		if (procenat == 2)
			return "CRVENA";
		if (procenat == 3)
			return "ZUT";
		return "KREM";
	}

}
