import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.insert(5);
        medianFinder.insert(10);
        medianFinder.insert(15);
        int median = medianFinder.findMedian();
        System.out.println("Median: " + median);
    }

    private final MinPQ<Integer> minPQ;
    private final MaxPQ<Integer> maxPQ;

    public MedianFinder() {
        minPQ = new MinPQ<Integer>();
        maxPQ = new MaxPQ<Integer>(Comparator.reverseOrder());
    }

    public void insert(int key) {
        if (maxPQ.isEmpty() || key <= maxPQ.max()) {
            maxPQ.insert(key);
        } else {
            minPQ.insert(key);
        }

        // Balance the sizes of the two heaps
        if (maxPQ.size() > minPQ.size() + 1) {
            minPQ.insert(maxPQ.delMax());
        } else if (minPQ.size() > maxPQ.size() + 1) {
            maxPQ.insert(minPQ.delMin());
        }
    }

    public int findMedian() {
        if (maxPQ.isEmpty() && minPQ.isEmpty()) {
            throw new IllegalStateException("MedianFinder is empty");
        }

        if (maxPQ.size() > minPQ.size()) {
            return maxPQ.max();
        } else if (minPQ.size() > maxPQ.size()) {
            return minPQ.min();
        } else {
            return (maxPQ.max() + minPQ.min()) / 2;
        }
    }

    public int deleteMedian() {
        if (maxPQ.isEmpty() && minPQ.isEmpty()) {
            throw new IllegalStateException("MedianFinder is empty");
        }

        int median;
        if (maxPQ.size() > minPQ.size()) {
            median = maxPQ.delMax();
        } else if (minPQ.size() > maxPQ.size()) {
            median = minPQ.delMin();
        } else {
            median = (maxPQ.delMax() + minPQ.delMin()) / 2;
        }

        // Re-balance the two heaps
        if (maxPQ.size() > minPQ.size()) {
            minPQ.insert(maxPQ.delMax());
        } else if (minPQ.size() > maxPQ.size()) {
            maxPQ.insert(minPQ.delMin());
        }

        return median;
    }

}
