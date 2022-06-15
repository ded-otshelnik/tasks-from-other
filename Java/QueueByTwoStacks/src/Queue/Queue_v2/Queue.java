package Queue.Queue_v2;

import Queue.IQueue;
import java.util.Iterator;

public class Queue<T> implements Iterable<T>, IQueue<T> {
    class QueueIterator implements Iterator<T> {
        Stack<T> stack;
        public QueueIterator(){
            if(!s1.empty()) {
                if (stack == null) {
                    stack = new Stack<T>();
                }
                for (var i : s1) {
                    stack.push(i);
                }
            }
            if(!s2.empty()){
                var temp =  s2.clone();
                if (stack == null) {
                    stack = new Stack<T>();
                }
                for(var i:temp){
                    stack.push(i);
                }
            }
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
        s1=new Stack<T>();
        s2=new Stack<T>();
    }
    public void enqueue(T item){
        s1.push(item);
    }
    public T dequeue(){
        if (s2.empty())
            while (!s1.empty()) {
                T element = s1.pop();
                s2.push (element);
            }
        return s2.pop();
    }
    public boolean empty(){
        return s1.empty()&&s2.empty();
    }
    public QueueIterator iterator(){
        return new QueueIterator();
    }
}
