package iteratorpattern;

import java.util.List;

public class BookIterator<T> implements Iterator<T> {

	private List<T> books;
	private int index = 0;

	BookIterator(List<T> books) {

		this.books = books;
	}

	@Override
	public boolean hasNext() {

		return index < books.size();
	}

	@Override
	public T next() {

		if (this.hasNext()) {
			return books.get(index++);
		}
		return null;
	}
}