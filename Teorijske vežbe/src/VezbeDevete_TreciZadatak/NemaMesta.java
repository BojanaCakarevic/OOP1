package VezbeDevete_TreciZadatak;

public class NemaMesta extends Exception {
	private Disk d;

	public NemaMesta(Disk d) {
		super("Nema mesta za " + d);
		this.d = d;
	}

	public Disk getDisk() {
		return d;
	}
}
