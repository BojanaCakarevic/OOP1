package TreciDomaci;

public class PlasticnaPolica extends Polica {

	private double maksOpterecenje;

	protected PlasticnaPolica(String ime, int brRedova) {
		super(ime, brRedova, 4.0);
	}

	public double getMaksOpterecenje() {
		return maksOpterecenje;
	}

	@Override
	public boolean dodajTeglu(Tegla t) {
		if ((getBrTegli() + 1 < getTegle().length) && (getTrenutnoOpterecenje() + t.getTezina() <= 2.5)) {
			getTegle()[getBrTegli() + 1] = t;
			setBrTegli(getBrTegli() + 1);
			setTrenutnoOpterecenje(getTrenutnoOpterecenje() + t.getTezina());
			return true;
		} else
			return false;
	}

}
