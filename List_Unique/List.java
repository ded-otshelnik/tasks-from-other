package List_Unique;

class List {
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
        end.next=temp;
        end=temp;
    }
    public void remove(){
        Node curr=front;
        while(curr.next!=end){
            curr=curr.next;
        }
        curr.next=null;
        end=curr;
    };
    public boolean removeAt(int value){
        Node curr=front;
        while(curr.next.value!=value && curr!=null){
            curr=curr.next;
        }
        if(curr==null){
            return false;
        }
        Node removed = curr.next;
        curr.next=removed.next;
        return true;
    };
    public String show(){
        Node curr=front;
        StringBuilder result=new StringBuilder("");
        while(curr.next!=null){
            result.append(curr.value+"\n");
            curr=curr.next;
        }
        return result.toString();
    }
    public List unique(){
        List result=new List();
        Node curr=front;
        while(curr.next!=null){
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
        while(curr.next!=null){
            if(curr.value==value){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }

}
