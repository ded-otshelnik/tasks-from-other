import java.util.Iterator;

class List implements Iterable<Integer>{
    Node front;
    Node end;
    class Node {
        int value;
        Node next;
        public Node(int value){
            this.value=value;
            next=null;
        }
    }
    public List(){
        front=null;
        end=null;
    }
    public void add(int value){
        Node temp = new Node(value);
        if(front==null && end==null){
            front=temp;
            end=temp;
            return;
        }
        end.next=temp;
        end=end.next;
    }
    public void remove(){
        if(front.next==null && end.next==null){
            front=null;
            end=null;
            return;
        }
        Node temp=front;
        while(temp.next!=end){
            temp=temp.next;
        }
        temp.next=null;
        end=temp;
    };
    public boolean removeAt(int value){
        Node temp=front;
        while(temp.next.value!=value && temp!=null){
            temp=temp.next;
        }
        if(temp==null){
            return false;
        }
        Node removed = temp.next;
        temp.next=removed.next;
        return true;
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
    public List unique(){
        List result=new List();
        Node curr=front;
        while(curr!=null){
            if(!result.contains(curr.value)){
                result.add(curr.value);
            }
            curr=curr.next;
        }
        return result;
    }
    private boolean contains(int value)
    {
        Node curr=front;
        if(curr==null){
            return false;
        }
        while(curr!=null){
            if(curr.value==value){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }
    public ListIterator iterator(){
        return new ListIterator();
    }

    class ListIterator implements Iterator<Integer>{
        Node curr;
        public ListIterator(){
            curr=front;
        }
        @Override
        public Integer next(){
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
