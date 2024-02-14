package deque;

public class LinkedListDeque<T>implements Deque<T> {
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
    @Override
    public void addFirst(T val)
    {
        Node cur=new Node(sen,val,sen.next);
        sen.next=cur;
        cur.next.prev=cur;
        //sen.next=new Node(sen,val,sen.next);
        size++;
    }
    @Override
    public void addLast(T val)
    {
        Node cur=new Node(sen.prev,val,sen);
        sen.prev=cur;
        cur.prev.next=cur;
        //sen.prev.next=new Node(sen.prev,val,sen);
        size++;
    }
    @Override
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
    @Override
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
    @Override
    public int size()
    {
        return size;
    }
    @Override
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
    @Override
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
    private class DequeSetIterator implements Iterator<T> {
        private int wizPos;

        public DequeSetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem =get(wizPos) ;
            wizPos += 1;
            return returnItem;
        }
    }
    public Iterator<T> iterator() {
        return new DequeSetIterator();
    }
    public interface Iterator<T> {
        boolean hasNext();
        T next();
    }

    public T getRecursive(int index)
    {
        return rec(sen.next,index).item;
    }
}
