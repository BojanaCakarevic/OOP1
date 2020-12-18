package PrviDomaci;

public class Glavna {

	public static void main(String[] args) {
		Tim tim = new Tim(new Kosarkas[] { new Kosarkas("Laza Lazic", "bek", 30.4),
				new Kosarkas("Pera Peric", "krilo", 3.9), new Kosarkas("Dimitrije Stefanovic", "centar", 25.45),
				new Kosarkas("Antonije Pesic", "bek", 32.9), new Kosarkas("Milan Antonovic", "krilo", 12.8) });
		System.out.println(tim);
		System.out.println("Najkorisniji igrac na terenu trenutno je " + tim.najkorisnijiIgracNaTerenu());

	}

}
