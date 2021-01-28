package PV04_03;

public class Pulmolog extends Lekar {

	public Pulmolog(String imeLekara, String prezimeLekara) {
		super(imeLekara, prezimeLekara, 100);
	}

	@Override
	public int plata() {
		return getBrPacijenata() * 500;
	}

	@Override
	public boolean prihvati(Pacijent p) {
		if (getBrPacijenata() < getMaks() && p.getGodine() <= 18) {
			getPacijenti()[getBrPacijenata() + 1] = p;
			return true;
		} else
			return false;
	}

}
