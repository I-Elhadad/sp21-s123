package deque;

import java.util.Comparator;

public class ArrayDeque<T>implements Deque<T> {
    private T[] items;
    private int size;
    int l;
    int r;

    public ArrayDeque()
    {
        items=(T[])new Object[8];
        size=0;
        l=0;
        r=7;
    }
    private void resize(int capacity)
    {
        T[] a=(T[])new Object[capacity];
        int idx=0;
        int track=r+1;
        while(idx<size)
        {
            a[idx]=items[(track)%items.length];
            idx++;
            track++;

        }
        r=capacity-1;
        l=idx;
        items=a;

    }
    @Override

     public void addLast(T item)
    {
        if(size==items.length)
        {
            resize(size*2);
        }
        items[l++]=item;
        l%=items.length;
        size++;
    }
    @Override
    public void addFirst(T item)
    {
        if(size==items.length)
        {
            resize(size*2);
        }
        items[r--]=item;
        r=(r+items.length)%items.length;
        size++;
    }
    @Override
    public int size()
    {
        return size;
    }
    @Override
    public T get(int index)
    {
        return items[(r+index+1)%items.length];
    }
    @Override
    public T removeFirst()
    {
        if(size>0) {
            if(items.length/size>=4) {
                resize(items.length / 2);
            }
            size--;
            r++;
            r%=items.length;
            return items[r];
        }
        return null;
    }
    @Override
    public T removeLast()
    {
        if(size>0) {
        if(items.length/size>=4) {
            resize(items.length / 2);
        }
            size--;
            l--;
            l=(l+items.length)%items.length;
            return items[l];
        }

        else return null;
    }
//    @Override
//    public boolean isEmpty()
//    {
//        if(size==0)return true;
//        else return false;
//    }
    @Override
    public void printDeque()
    {
        for(int i=r;i<size;i++)
        {
            System.out.print(items[i%items.length]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       ArrayDeque <Integer> obj1=new ArrayDeque<>();
        obj1.addFirst(0);
        obj1.get(0)   ;
        obj1.addFirst(2);
        obj1.removeFirst()    ;
        obj1.removeFirst()   ;
        obj1.addLast(5);
        obj1.addLast(6);
        obj1.addFirst(7);
        obj1.removeFirst();
        obj1.removeLast();
    }
}



