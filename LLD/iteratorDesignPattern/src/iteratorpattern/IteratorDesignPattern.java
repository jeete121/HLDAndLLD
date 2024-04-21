package iteratorpattern;

import java.util.Arrays;
import java.util.List;

public class IteratorDesignPattern {

	public static void main(String[] args) {

		List<Book> booksList = Arrays.asList(new Book(100, "Science"), new Book(200, "Maths"), new Book(300, "GK"),
				new Book(400, "Drawing"));

		Library<Book> lib = new Library<Book>(booksList);
		Iterator<Book> iterator = lib.createIterator();

		while (iterator.hasNext()) {

			Book book = iterator.next();
			System.out.println(book.getBookName());
			System.out.println(book.getPrice());
		}
	}

}