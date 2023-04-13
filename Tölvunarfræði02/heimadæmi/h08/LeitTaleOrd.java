import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.LinearProbingHashST;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.TreeMap;


public class LeitTaleOrd {

    public static void main(String[] args) {
        String urlWarAndPeace = "https://introcs.cs.princeton.edu/java/data/war+peace.txt";
        String urlTaleOfTwoCities = "https://introcs.cs.princeton.edu/java/data/tale.txt";
        ArrayList<String> warAndPeaceWords = new ArrayList<String>();
        ArrayList<String> taleOfTwoCitiesWords = new ArrayList<String>();

        try {
            // Lesa inn "war+peace.txt"
            URL warAndPeaceUrl = new URL(urlWarAndPeace);
            HttpURLConnection warAndPeaceConnection = (HttpURLConnection) warAndPeaceUrl.openConnection();
            warAndPeaceConnection.setRequestMethod("GET");

            BufferedReader warAndPeaceReader = new BufferedReader(new InputStreamReader(warAndPeaceConnection.getInputStream()));
            String warAndPeaceLine = warAndPeaceReader.readLine();
            while (warAndPeaceLine != null) {
                String[] warAndPeaceLineWords = warAndPeaceLine.split(" ");
                for (String word : warAndPeaceLineWords) {
                    warAndPeaceWords.add(word);
                }
                warAndPeaceLine = warAndPeaceReader.readLine();
            }
            warAndPeaceReader.close();

            // Lesa inn "tale.txt"
            URL taleOfTwoCitiesUrl = new URL(urlTaleOfTwoCities);
            HttpURLConnection taleOfTwoCitiesConnection = (HttpURLConnection) taleOfTwoCitiesUrl.openConnection();
            taleOfTwoCitiesConnection.setRequestMethod("GET");

            BufferedReader taleOfTwoCitiesReader = new BufferedReader(new InputStreamReader(taleOfTwoCitiesConnection.getInputStream()));
            String taleOfTwoCitiesLine = taleOfTwoCitiesReader.readLine();
            while (taleOfTwoCitiesLine != null) {
                String[] taleOfTwoCitiesLineWords = taleOfTwoCitiesLine.split(" ");
                for (String word : taleOfTwoCitiesLineWords) {
                    taleOfTwoCitiesWords.add(word);
                }
                taleOfTwoCitiesLine = taleOfTwoCitiesReader.readLine();
            }
            taleOfTwoCitiesReader.close();
        } catch (IOException ex) {
            System.out.println("Villa við að lesa skrá frá URL: " + ex.getMessage());
        }

        // Búa til og fylla gagnagrindirnar með orðunum
        TreeMap<String, Integer> bst = new TreeMap<String, Integer>();
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<String, Integer>();
        SeparateChainingHashST<String, Integer> separateChainingHashST = new SeparateChainingHashST<String, Integer>();
        LinearProbingHashST<String, Integer> linearProbingHashST = new LinearProbingHashST<String, Integer>();

        // Setja allar orð í gagnagrindurnar
        for (String word : warAndPeaceWords) {
            // BST
            if (!bst.containsKey(word)) {
                bst.put(word, 1);
            } else {
                bst.put(word, bst.get(word) + 1);
            }

            // RedBlackBST
            if (!redBlackBST.contains(word)) {
                redBlackBST.put(word, 1);
            } else {
                redBlackBST.put(word, redBlackBST.get(word) + 1);
            }

            // SeparateChainingHashST
            if (!separateChainingHashST.contains(word)) {
                separateChainingHashST.put(word, 1);
            } else {
                separateChainingHashST.put(word, separateChainingHashST.get(word) + 1);
            }

            // MinnLinear
            if (!linearProbingHashST.contains(word)) {
                linearProbingHashST.put(word, 1);
            } else {
                linearProbingHashST.put(word, linearProbingHashST.get(word) + 1);
            }
        }


    }
}