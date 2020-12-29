package VezbeDevete_DrugiZadatak;

public interface SetInterface<T> {
	
	void add(T t) throws SetException;

	void remove(T t) throws SetException;

	boolean member(T t);

	void print();
}
