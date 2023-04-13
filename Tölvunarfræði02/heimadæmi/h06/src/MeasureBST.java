import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MeasureBST {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double sumHeight = 0.0;

        for (int t = 0; t < trials; t++) {
            BST<Double, Integer> bst = new BST<Double, Integer>();

            // Setja n slembnar double tölur inn í tréið
            for (int i = 0; i < n; i++) {
                double key = StdRandom.uniform();
                bst.put(key, i);
            }

            // Finna hæð trésins
            int height = bst.height();
            sumHeight += height;
        }

        double avgHeight = sumHeight / trials;
        int optimalHeight = (int) Math.ceil(Math.log(n) / Math.log(2));
        double ratio = avgHeight / optimalHeight;

        StdOut.printf("For n = %d, optimal height is %d\n", n, optimalHeight);
        StdOut.printf("Average height in %d trials is %.2f, %.2f times optimal\n", trials, avgHeight, ratio);
    }
}
