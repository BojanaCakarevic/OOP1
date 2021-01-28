package PV04_03;

public class Pedijatar extends Lekar {

	public Pedijatar(String imeLekara, String prezimeLekara) {
		super(imeLekara, prezimeLekara, 200);
	}

	@Override
	public int plata() {
		int brMladjih = 0;
		int bonus = 0;
		for (int i = 0; i < getBrPacijenata(); i ++) {
			if (getPacijenti()[i].getGodine() < 5)
				brMladjih++;
		}
		bonus = brMladjih + 100;
		return getBrPacijenata() * 300 + bonus;
	}
	
	

}
