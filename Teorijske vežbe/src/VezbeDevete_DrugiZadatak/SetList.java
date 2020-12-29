package VezbeDevete_DrugiZadatak;

public class SetList<T> implements SetInterface<T> {
	private class ListElement {
		T elem;
		ListElement next;

		public ListElement(T elem) {
			this.elem = elem;
		}
	}

	private ListElement head;

	public boolean member(T t) {
		ListElement curr = head;
		while (curr != null) {
			if (curr.elem.equals(t))
				return true;
			curr = curr.next;
		}
		return false;
	}

	public void add(T t) throws SetException {
		boolean in = member(t);
		if (in)
			throw new AddException(t);
		ListElement newElem = new ListElement(t);
		newElem.next = head;
		head = newElem;
	}

	@Override
	public void remove(T t) throws SetException {
		ListElement curr = head;
		ListElement prev = null;
		boolean found = false;

		while (curr != null && !found) {
			if (curr.elem.equals(t)) {
				found = true;
				if (curr == head)
					head = head.next;
				else
					prev.next = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		if (!found)
			throw new RemoveException(t);
	}

	@Override
	public void print() {
		if (head == null)
			System.out.println("Empty list");
		else {
			ListElement curr = head;
			while (curr != null) {
				System.out.println(curr.elem + " ");
				curr = curr.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SetInterface<Integer> s = new SetList<Integer>();
		int addFailed = 0, removeFailed = 0;

		for (int i = 0; i < 20; i++) {
			int num = (int) (Math.random() * 10);
			try {
				s.add(num);
			} catch (SetException e) {
				++addFailed;
			}
		}
		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 10);
			try {
				s.remove(num);
			} catch (SetException e) {
				++removeFailed;
			}
		}
		int added = 20 - addFailed;
		int removed = 10 - removeFailed;
		System.out.println(added + ", " + removed);
	}

}
