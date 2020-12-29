package VezbeDevete_DrugiZadatak;

public class RemoveException extends SetException {

	private static final long serialVersionUID = 1L;

	public RemoveException(Object argument) {
		super(argument, argument + " not in the set");
	}
}