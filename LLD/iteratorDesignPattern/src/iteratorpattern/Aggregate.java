package iteratorpattern;

public interface Aggregate<T> {

	Iterator<T> createIterator();
}