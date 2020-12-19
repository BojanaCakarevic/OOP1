package DrugiZadatak;

import java.io.IOException;

public class Glavna {
	public static void main(String[] args) throws IOException {
		SkolaJezika skolaJezika = new SkolaJezika("res\\kursevi.txt");
		String najnaprednijiJezik = skolaJezika.najnaprednijiJezik();
		System.out.println("Najnapredniji jezik je " + najnaprednijiJezik);
		skolaJezika.unaprediGrupu("engleski", "osnovni");
	}
}
