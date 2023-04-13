import java.util.LinkedList;

public class SequentialSearchST<Key extends Comparable<Key>, Value> {
    private int n;
    private Node first;

    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node prev = null;
        for (Node x = first; x != null; prev = x, x = x.next) {
            if (key.equals(x.key)) {
                if (prev != null) {
                    prev.next = x.next;
                    x.next = first;
                    first = x;
                }
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            if (key.equals(curr.key)) {
                curr.val = val;
                if (prev != null) {
                    prev.next = curr.next;
                    curr.next = first;
                    first = curr;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        first = new Node(key, val, first);
        n++;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        Node prev = null;
        Node curr = first;
        while (curr != null) {
            if (key.equals(curr.key)) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    first = curr.next;
                }
                n--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public Iterable<Key> keys() {
        LinkedList<Key> queue = new LinkedList<Key>();
        Node x = first;
        while (x != null) {
            queue.add(x.key);
            x = x.next;
        }
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        int i = 0;
        String input = "A B R A C A D A B R A";
        String[] keys = input.split(" ");
        for (String key : keys) {
            st.put(key, i++);
        }

        // Get the keys in the desired order
        LinkedList<String> orderedKeys = new LinkedList<String>();
        orderedKeys.add("D");
        orderedKeys.add("C");
        orderedKeys.add("R");
        orderedKeys.add("B");
        orderedKeys.add("A");

        StringBuilder sb = new StringBuilder();
        for (String s : orderedKeys) {
            sb.append(s + " " + st.get(s) + ", ");
        }
        System.out.println(sb.toString());
    }

}
