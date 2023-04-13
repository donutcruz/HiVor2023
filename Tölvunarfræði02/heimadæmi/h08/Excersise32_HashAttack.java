import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;
import java.util.List;

public class Excersise32_HashAttack {

    public int hashCode(String string) {
        int hash = 0;

        for (int i = 0; i < string.length(); i++) {
            hash = (hash * 31) + string.charAt(i);
        }

        return hash;
    }

    private List<String> generateStringsInput(int n) {
        String[] values = {"Aa", "BB"};

        List<String> strings = new ArrayList<>();
        generateStrings(n, 0, strings, "", values);

        return strings;
    }

    private void generateStrings(int n, int currentIndex, List<String> strings, String currentString, String[] values) {
        if (currentIndex == n) {
            strings.add(currentString);
            return;
        }

        for (String value : values) {
            String newValue = currentString + value;
            int newIndex = currentIndex + 1;

            generateStrings(n, newIndex, strings, newValue, values);
        }
    }

    public static void main(String[] args) {
        Excersise32_HashAttack hashAttack = new Excersise32_HashAttack();
        List<String> hashAttackInput = hashAttack.generateStringsInput(32);

        Out out = new Out("hashes.txt");

        for (String string : hashAttackInput) {
            int hashCode = hashAttack.hashCode(string);
            out.println(hashCode + " " + string);
        }

        out.close();
    }
}
