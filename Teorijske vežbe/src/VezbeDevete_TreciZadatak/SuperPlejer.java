package VezbeDevete_TreciZadatak;

public class SuperPlejer implements Plejer, KutijaZaDiskove {

	private class DiskList {
		Disk disk;
		DiskList sledeci;

		public DiskList(Disk disk) {
			this.disk = disk;
		}
	}

	private int maxBrojDiskova;
	private int brojDiskova;
	private DiskList prviDisk;

	public SuperPlejer(int maxBrojDiskova) {
		this.maxBrojDiskova = maxBrojDiskova;
	}

	public void dodaj(Disk d) throws NemaMesta {
		if (brojDiskova == maxBrojDiskova)
			throw new NemaMesta(d);

		DiskList noviDisk = new DiskList(d);
		noviDisk.sledeci = prviDisk;
		prviDisk = noviDisk;
		++brojDiskova;
	}

	public void sviraj() throws NemaDiskova {
		if (prviDisk == null)
			throw new NemaDiskova();

		boolean jedanDobar = false;
		DiskList tek = prviDisk;
		DiskList pret = null;

		while (tek != null) {
			Disk d = tek.disk;
			if (d.unisten()) {
				if (tek == prviDisk) {
					prviDisk = prviDisk.sledeci;
					tek = prviDisk;
				} else {
					pret.sledeci = tek.sledeci;
					tek = tek.sledeci;
				}
				--brojDiskova;
			} else {
				System.out.println("Sviram " + d);
				jedanDobar = true;
				d.smanjiKvalitet();
				pret = tek;
				tek = tek.sledeci;
			}
		}

		if (!jedanDobar) {
			throw new NemaDiskova();
		}
	}

	public void stampaj() {
		if (prviDisk == null) {
			System.out.println("Prazna kutija");
			return;
		}

		DiskList d = prviDisk;
		while (d != null) {
			System.out.println(d.disk);
			d = d.sledeci;
		}
	}

	public int getBrojDiskova() {
		return brojDiskova;
	}

}
