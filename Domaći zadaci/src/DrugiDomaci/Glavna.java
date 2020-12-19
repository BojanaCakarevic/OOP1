package DrugiDomaci;

import java.io.IOException;

public class Glavna {

	public static void main(String[] args) throws IOException {
		Forum forum = new Forum("res\\objave.txt");
		System.out.println("Najpopularnija objava je " + forum.najpopularnijaObjava("razno"));
		forum.statistika();
	}

}
