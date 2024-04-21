package iteratorpattern;

import java.util.List;

public class Library<T> {

	private List<T> booksList;

	Library(List<T> booksList) {

		this.booksList = booksList;
	}

	public Iterator<T> createIterator() {

		return new BookIterator<T>(booksList);
	}
}