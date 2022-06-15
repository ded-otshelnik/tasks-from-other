package Queue.Queue_v2;

import java.util.Iterator;
class List<T> implements Iterable<T>{
    private Node front;
    private Node end;
    class Node {
        T value;
        Node next;
        public Node(T value){
            this.value=value;
            next=null;
        }
    }
    public List(){
        front=null;
        end=null;
    }
    public void add(T value){
        Node temp = new Node(value);
        if(front==null && end==null){
            front=temp;
            end=temp;
            return;
        }
        end.next=temp;
        end=end.next;
    }
    public T remove(){
        if(front.next==null){
            var removed=front;
            front=null;
            end=null;
            return removed.value;
        }
        Node temp=front;
        while(temp.next!=end){
            temp=temp.next;
        }
        temp.next=null;
        var removed= end;
        end=temp;
        return removed.value;
    };
    public String toString(){
        Node curr=front;
        StringBuilder result=new StringBuilder("");
        while(curr!=null){
            result.append(curr.value+"\n");
            curr=curr.next;
        }
        return result.toString();
    }
    public ListIterator iterator(){
        return new ListIterator();
    }
    public T getEnd(){
        return end!=null?end.value:null;
    }
    public T getFront(){
        return front!=null?front.value:null;
    }

    class ListIterator implements Iterator<T>{
        Node curr;
        public ListIterator(){
            curr=front;
        }
        @Override
        public T next(){
            Node result=curr;
            curr=curr.next;
            return result.value;
        }

        @Override
        public boolean hasNext() {
            return curr!=null;
        }
    }

}

