package Online_prodavnica;

import java.util.Random;

public class Nike extends Patike {

	public Nike(String marka, int broj) {
		super(marka, broj);
	}

	@Override
	protected String inicijalizujTip() {
		Random r = new Random();
		int procenat = r.nextInt(100);
		if (procenat <= 70)
			return "DUBOKE";
		return "PLITKE";
	}

}
