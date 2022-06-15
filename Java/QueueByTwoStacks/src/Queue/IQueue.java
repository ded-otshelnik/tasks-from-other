package Queue;

import java.util.Iterator;

public interface IQueue<T> extends Iterable<T> {
    void enqueue(T item);
    T dequeue();
    Iterator<T> iterator();
    boolean empty();
}
