package deque;

public class LinkedListDeque<T> {
     Node sen;
     int size;
    class Node
    {
        private Node next;
        private Node prev;
        private T item;
        public Node(Node p,T i,Node n)
        {
            next=n;
            item=i;
            prev=p;
        }
    }
    public LinkedListDeque()
    {
        sen=new Node(null,null,null);
        sen.prev=sen;
        sen.next=sen;
        size=0;
    }
    public void addFirst(T val)
    {
        Node cur=new Node(sen,val,sen.next);
        sen.next=cur;
        cur.next.prev=cur;
        //sen.next=new Node(sen,val,sen.next);
        size++;
    }
    public void addLast(T val)
    {
        Node cur=new Node(sen.prev,val,sen);
        sen.prev=cur;
        cur.prev.next=cur;
        //sen.prev.next=new Node(sen.prev,val,sen);
        size++;
    }
    public T removeLast()
    {
        if(sen.prev!=sen) {

            Node cur = sen.prev;
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            size--;
            return cur.item;

        }
        else return null;
    }
    public T removeFirst()
    {
        if(sen.next!=sen) {

            Node cur = sen.next;
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            size--;
            return cur.item;
        }
        else return null;

    }
    public int size()
    {
        return size;
    }
    public T get(int idx)
    {
        Node cur=sen.next;
        int cnt=0;
        while(cur!=sen)
        {
            if(cnt==idx)
                return cur.item;
            cnt++;
            cur=cur.next;

        }
        return null;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void printDeque()
    {
        if(size>=1) {
            Node cur = sen.next;
            while (cur != sen) {
                System.out.print(cur.item + " ");
                cur=cur.next;
            }
            System.out.println();

        }
    }
    private Node rec(Node cur,int cnt)
    {
        if(cur==sen)
            return null;
        if(cnt==0)
            return cur;
        else return rec(cur.next,cnt-1);

    }
    public T getRecursive(int index)
    {
        return rec(sen.next,index).item;
    }
}
