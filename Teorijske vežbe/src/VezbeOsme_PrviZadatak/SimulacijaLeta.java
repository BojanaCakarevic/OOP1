package VezbeOsme_PrviZadatak;

public class SimulacijaLeta {

	public static void main(String[] args) {
		SpisakPutnika sp = new SpisakPutnika();
		boolean spisak = sp.ucitajSpisak("res\\putnici.txt");
		if (spisak) {
			try {
				Putnik[] p = sp.getPutnici();
				Let l = new Let("1324", 2, p);
				System.out.println("Tezina izgubljenog prtljaga je " + l.izgubljenPrtljag());
			} catch (VisakTereta izuzetak) {
				System.out.println(izuzetak.getMessage());
			}
		}
	}

}
