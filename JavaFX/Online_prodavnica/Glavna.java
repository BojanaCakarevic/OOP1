package Online_prodavnica;

import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws IOException {
		ProdavnicaPatika prodavnica = new ProdavnicaPatika("res\\patike.txt");
		prodavnica.ispisi();
	}

}
