Iterator Design Pattern (Behavioral Design Pattern)


Lets look a this below diagram once and understand the need for ITERATOR PATTERN.



                           Iterable
                              |extends
                              |
                           Collection
                              |extends
            __________________|___________________
           |                  |                   |
           |                  |                   |    implemets
       ____Queue             List                Set-------------------
impl  |      |                |implemets          |            |       |  
ements|      |extends      ___|_________          |extends    HashSet LinkedHash
Priority     |            |   |         |          SortedSet              Set
Queue       Deque         |   |         |           |
             |implemets   | ArrayList  Vector       |extends
             |________    |             |          NavigableSet
             |        |   |             |extends    |
             |        |   |            Stack        |implemets
        ArrayDeque   LinkedList                   TreeSet




public class LinkedHashSetExample {

public static void main(String[] args) {

Set<Integer> intSet = new LinkedHashSet<>();
intSet.add(2);
intSet.add(77);
intSet.add(82);
intSet.add(63);
intSet.add(5);

Iterator<Integer> iterable = intSet.iterator();

while(iterable.hasNext()) {
  int val = iterable.next();
  System.out.println(val);
}

}

}

Its a behavioral Design Pattern, that provides a way to access element of a Collection sequentially without exposing the underlying representation of the collection.


Aggregate<<Interface>>                    Iterator<<Interface>>
+createIterator():Iterator<T>              +hasNext(): boolean
    |                                      +next(): T
    |                                        |
    |is-a                                    |is-a
    |                                        |
ConcreteAggregate   <<creates>>           ConcreteIterator
-items: List<T>    ----------------------> collection: Collection<T>
+createIterator():Iterator<T>              position: int
                                           +hasNext(): boolean
                                           +next(): T







public interface Aggregate {

Iterator createIterator();
}


public interface Iterator {
 boolean hasNext();
 Object next();
}

public class Library {

private List<Book> booksList;

Library(List<Book> booksList) {

this.booksList = booksList;
}

public Iterator createIterator() {

return new BookIterator(booksList);
}
}


public class BookIterator implements Iterator {

private List<Book> books;
private int index = 0;

BookIterator(List<Book> books) {

this.books = books;
}

@Override
public boolean hasNext() {

  return index<books.length();
}

@Override
public Object next() {
  
if(this.hasNext())
  {
    return books.get(index++);
  }
}
}



public class Book {

private int price;
private String bookName;

Book(int price,String bookName) {
this.price = price;
this.bookName = bookName; 
}

public int getPrice() {
 return price;
}

public String getBookName() {

return bookName;
}
}



public class Client {

public static void main(String[] args) {

List<Book> booksList = Arrays.asList(
new Book(100,"Science"),
new Book(200,"Maths"),
new Book(300,"GK"),
new Book(400,"Drawing")
);

Library lib = new Library(booksList);
Iterator iterator = lib.createIterator();

while(iterator.hasNext()) {

Book book = (Book)iterator.next();
System.out.println(book.getBookName());
}
}

}