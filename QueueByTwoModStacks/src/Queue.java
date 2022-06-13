import java.util.*;

public class Queue<T> implements Iterable<T>{
    class QueueIterator implements Iterator<T> {
        Stack<T> stack;
        public QueueIterator(){
            if(s2.empty()){}
            stack = (Stack<T>)s2.clone();
        }
        @Override
        public boolean hasNext(){
            return !stack.empty();
        }

        @Override
        public T next() {
            return stack.pop();
        }
    }
    Stack<T> s1,s2;
    public Queue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void enqueue(T item){
        s1.push(item);
    }
    public void dequeue(){
        if (s2.empty())
            while (!s1.empty()) {
                T element = s1.pop();
                s2.push (element);
            }
        T result = s2.peek();
        s2.pop();
    }
    public QueueIterator iterator(){
        return new QueueIterator();
    }
}
