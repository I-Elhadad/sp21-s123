package deque;
//import afu.org.checkerframework.checker.igj.qual.I;

public class ArrayDeque<T> {
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
    void resize(int capacity)
    {
        T[] a=(T[])new Object[capacity];
        int idx=0;
        for(int i=r;i<=l;i++)
        {
            a[idx]=items[i];
            idx++;
        }
        r=capacity-1;
        items=a;
    }

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
    public int size()
    {
        return size;
    }
    public T get(int index)
    {
        return items[(r+index+1)%items.length];
    }
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
    public T removeLast()
    {
        if(size>=1&&items.length/size>=4) {
            resize(items.length / 2);
        }
        if(size>0) {
            size--;
            l--;
            l=(l+items.length)%items.length;
            return items[l];
        }

        else return null;
    }
    public boolean isEmpty()
    {
        if(size==0)return true;
        else return false;
    }
    public void printDeque()
    {
        for(int i=r;i<size;i++)
        {
            System.out.print(items[i%items.length]+" ");
        }
        System.out.println();
    }





}

