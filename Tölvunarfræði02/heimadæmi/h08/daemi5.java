import java.util.List; import java.util.ArrayList;
public class daemi5 {
    public int hashCode(String string) {
        int hash = 0;
        for (int i = 0; i < string.length(); i ++)
            hash = (hash * 31) + string.charAt(i); return hash;
    }
    private List<String> generateStringsInput(int n) {
        String[] values = {"Aa", "BB"}; List<String> strings = new ArrayList<>();
        generateStrings(n, 0, strings, "", values); return strings;
    }
    private void generateStrings(int n, int currentIndex, List<String> strings, String currentString, String[] values) {
        if (currentIndex == n) { strings.add(currentString); return;
        }
        for (String value : values) {
            String newValue = currentString + value; int newIndex = currentIndex + 1;
            generateStrings(n, newIndex, strings, newValue, values); }
    }
    public static void main(String[] args) {
        daemi5 hashAttack = new daemi5();
        List<String> hashAttackInput = hashAttack.generateStringsInput(3);
        for (String string : hashAttackInput) { System.out.println(string); System.out.println(string.hashCode());
        } }
}