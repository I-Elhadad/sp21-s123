package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {

        SLList<Integer>obj1=new SLList<>();
        AList<Integer> Ns=new AList<>();
        AList<Double> times=new AList<>();
        AList<Integer> opCounts=new AList<>();
        for(int i=1000;i<=128000;i=obj1.size())
        {

            for(int j=0;j<i;j++)
                obj1.addLast(j);
            Stopwatch time=new Stopwatch();
            for(int j=0;j<10000;j++)
                obj1.getLast();
            double left_time=time.elapsedTime();
            Ns.addLast(obj1.size());
            times.addLast(left_time);
            opCounts.addLast(10000);

        }
        printTimingTable(Ns,times,opCounts);







    }

}
