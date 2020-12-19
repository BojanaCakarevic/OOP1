package PrviZadatak;

public class Glavna {
	public static void main(String[] args) {
		Kazino kazino = new Kazino(new Kladionicar[] { new Kladionicar("Pera", "ajnc", 13200),
				new Kladionicar("Mika", "ajnc", 9000), new Kladionicar("Marko", "poker", -6700),
				new Kladionicar("Darko", "rulet", -8000), new Kladionicar("Janko", "rulet", -5000) });
		System.out.println(kazino);
		System.out.println(kazino.najprofitnijaIgra());
	}
}
