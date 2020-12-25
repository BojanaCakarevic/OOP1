package SedmiZadatak;

public interface Nastavnik {
	void odrziRoditeljski();

	void pregledajZadatke(String predmet) throws NijePredatDomaci, FaliZadatak;
}
