package VezbeSedme_CezarovaSifra;

public class Glavna {

	public static void main(String[] args) {
		Sifra cs = new CezarovaSifra(4);
		
		String sifruj = cs.sifruj("ajmo na rucak");
		System.out.println(sifruj);
		
		String desifruj = cs.desifruj(sifruj);
		System.out.println(desifruj);
	
	}

}
