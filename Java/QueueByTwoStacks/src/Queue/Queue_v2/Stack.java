package Queue.Queue_v2;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private List<T> list;
    private T top;
    public Stack(){
        list=new List<T>();
    }
    public T pop(){
        var temp=list.remove();
        top=list.getEnd();
        return temp;
    }
    public void push(T value){
        list.add(value);
        top=value;
    }
    public T peek(){
        T temp=(T)top;
        return top;
    }
    public boolean empty(){
        return list.getFront()==null;
    }
    public Stack<T> clone(){
        Stack<T> clone= new Stack<T>();
        for(var i:list){
            clone.push(i);
        }
        return clone;
    }
    public StackIterator iterator(){
        return new StackIterator();
    }
    class StackIterator implements Iterator<T> {
        List<T> copy;
        List.ListIterator curr;
        public StackIterator(){
            curr= list.iterator();
            copy=new List<T>();
            var temp=new List<T>();
            for(var i:list){
                temp.add(i);
            }
            while(temp.getEnd()!=null){
                copy.add(temp.remove());
            }
        }
        @Override
        public T next(){
            if(curr.hasNext()){
                return (T)curr.next();
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return curr.hasNext();
        }
    }
}
