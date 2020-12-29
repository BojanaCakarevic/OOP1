package VezbeDevete_DrugiZadatak;

public class AddException extends SetException {

	private static final long serialVersionUID = 1L;

	public AddException(Object argument) {
		super(argument, argument + " already in the set");
	}
}
