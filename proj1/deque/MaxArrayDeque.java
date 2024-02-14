package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> obj;
    public MaxArrayDeque(Comparator<T> obj)
    {
        this.obj = obj;
    }

    public T max(Comparator<T> c)
    {
        int idx = 0;
        for (int i = 0;  i < size() ; i++)
        {
            T a = get(i) ; T b = get(idx);
            if(c.compare(a , b) > 0)
            {
                idx = i;
            }
        }
        return get(idx);
    }

    public T max()
    {
        return max(obj);
    }

    public static void main(String[] args) {
       // MaxArrayDeque <Integer>obj1=new MaxArrayDeque<>();
    }




}