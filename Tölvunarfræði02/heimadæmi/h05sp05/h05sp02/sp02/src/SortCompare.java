import edu.princeton.cs.algs4.MergeBU;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.QuickX;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            InsertionSort.sort(a);
        }
        if (alg.equals("Selection")) {
            SelectionSort.sort(a);
        }
        if (alg.equals("Shell")) {
            ShellSort.sort(a);
        }
        if (alg.equals("Merge")) {
            MergeSort.sort(a);
        }
        if (alg.equals("MergeBU")) {
            MergeBU.sort(a);
        }
        if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        if (alg.equals("QuickX")) {
            QuickX.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int n, int trials) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int t = 0; t < trials; t++) {
            for (int i = 0; i < n; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Quick";
        String alg2 = "QuickX";
        int n = 1000000;
        int trials = 10;
        double time1 = timeRandomInput(alg1, n, trials);
        double time2 = timeRandomInput(alg2, n, trials);
        StdOut.printf("For %d random Doubles\n  %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s\n", time2/time1, alg2);
    }
}
