package VezbeDevete_PrviZadatak;

public interface RadnaOrganizacija {
	void zaposli(String id, String ime, int plata) throws    
    RadnaOrganizacijaException;
	void otpusti(String id) throws RadnaOrganizacijaException;
}
