package VezbeDevete_DrugiZadatak;

public class SetException extends Exception {

	private static final long serialVersionUID = 1L;
	private Object argument;

	public SetException(Object argument, String errorMes) {
		super(errorMes);
	}

	public Object getAgrument() {
		return argument;
	}
}
