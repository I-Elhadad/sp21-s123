package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        // YOUR TESTS HERE
        AListNoResizing<Integer> good = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        good.addLast(4);
        good.addLast(5);
        good.addLast(6);
        buggy.addLast(4);
        buggy.addLast(5);
        buggy.addLast(6);
        assertEquals(good.removeLast(),buggy.removeLast());
    }
    @Test
    public void randomizedTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggy.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
            else if(operationNumber==2)
            {
                if(L.size()>0)
                {
                    System.out.println(L.getLast());
                }
            }
            else if(operationNumber==3)
            {
                if(L.size()>0)
                {
//                    System.out.println(L.removeLast());
//                    buggy.removeLast();
                    assertEquals(L.removeLast(),buggy.removeLast());
                }
            }
        }
    }

}
