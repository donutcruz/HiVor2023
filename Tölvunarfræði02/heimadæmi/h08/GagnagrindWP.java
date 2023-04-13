import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class GagnagrindWP {
    public static void main(String[] args) throws IOException {
        String url = "https://introcs.cs.princeton.edu/java/data/war+peace.txt";
        Scanner scanner = new Scanner(new URL(url).openStream());
        BST<String, Integer> bst = new BST<>();
        RedBlackBST<String, Integer> rbbst = new RedBlackBST<>();
        SeparateChainingHashST<String, Integer> schst = new SeparateChainingHashST<>();
        MinnLinear<String, Integer> lphst = new MinnLinear<>();
        long bstInsertTime = 0;
        long rbbstInsertTime = 0;
        long schstInsertTime = 0;
        long lphstInsertTime = 0;
        long bstSearchTime = 0;
        long rbbstSearchTime = 0;
        long schstSearchTime = 0;
        long lphstSearchTime = 0;
        long start, end;
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
            if (word.length() > 0) {
                start = System.currentTimeMillis();
                bst.put(word, bst.get(word) == null ? 1 : bst.get(word) + 1);
                end = System.currentTimeMillis();
                bstInsertTime += (end - start);

                start = System.currentTimeMillis();
                rbbst.put(word, rbbst.get(word) == null ? 1 : rbbst.get(word) + 1);
                end = System.currentTimeMillis();
                rbbstInsertTime += (end - start);

                start = System.currentTimeMillis();
                schst.put(word, schst.get(word) == null ? 1 : schst.get(word) + 1);
                end = System.currentTimeMillis();
                schstInsertTime += (end - start);

                start = System.currentTimeMillis();
                lphst.put(word, lphst.get(word) == null ? 1 : lphst.get(word) + 1);
                end = System.currentTimeMillis();
                lphstInsertTime += (end - start);
            }
        }
        scanner.close();
        scanner = new Scanner(new URL(url).openStream());
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
            if (word.length() > 0) {
                start = System.currentTimeMillis();
                bst.get(word);
                end = System.currentTimeMillis();
                bstSearchTime += (end - start);

                start = System.currentTimeMillis();
                rbbst.get(word);
                end = System.currentTimeMillis();
                rbbstSearchTime += (end - start);

                start = System.currentTimeMillis();
                schst.get(word);
                end = System.currentTimeMillis();
                schstSearchTime += (end - start);

                System.currentTimeMillis();
                scanner.close();

                System.out.println("BST Insertion Time: " + bstInsertTime + " ms");
                System.out.println("RedBlackBST Insertion Time: " + rbbstInsertTime + " ms");
                System.out.println("SeparateChainingHashST Insertion Time: " + schstInsertTime + " ms");
                System.out.println("MinnLinear Insertion Time: " + lphstInsertTime + " ms");

            }
        }
    }
}
