package TreciDomaci;

import java.io.IOException;

public class Glavna {
	public static void main(String[] args) throws IOException {

		Spajz s = new Spajz();

		System.out.println("Ukupna tezina zaliha je " + s.tezina());

		System.out.println("Plasticna polica sa najvecim opterecenjem je " + s.najteza());

	}
}
