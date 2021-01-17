package Online_prodavnica;

import java.util.Random;

public class Adidas extends Patike {

	public Adidas(String marka, int broj) {
		super(marka, broj);
	}

	@Override
	protected String inicijalizujTip() {
		Random r = new Random();
		int procenat = r.nextInt(100);
		if (procenat <= 60)
			return "DUBOKE";
		return "PLITKE";
	}

}
