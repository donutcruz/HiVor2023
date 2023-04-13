import edu.princeton.cs.algs4.StdOut;

public class sp2 {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();

        // Setja gögn inn í BinarySearchST hlutinn
        st.put("A", 1);
        st.put("B", 2);
        st.put("C", 3);
        st.put("D", 4);
        st.put("E", 5);
        st.put("F", 6);
        st.put("G", 7);
        st.put("H", 8);

        // Skila breytta fallinu put()
        BinarySearchST<String, Integer> stNew = putNew(st, "I", 9);

        // Birta öll gögnin í BinarySearchST hlutnum
        for (String s : stNew.keys())
            StdOut.println(s + " " + stNew.get(s));
    }

    // Breitt fall til að bæta við lykli á föstu tíma ef hann er stærri en allir lyklarnir í töflunni
    public static BinarySearchST<String, Integer> putNew(BinarySearchST<String, Integer> st, String key, Integer val) {
        String max = st.max();

        if (max != null && key.compareTo(max) > 0) {
            st.put(max, val);
            return st;
        } else {
            st.put(key, val);
            return st;
        }
    }

}
