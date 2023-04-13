import edu.princeton.cs.algs4.Queue;

public class SeperateChaningHashST<Key, Value> {
    private int n;  // fjöldi staka í töflunni
    private int m;  // fjöldi hash gilda
    private Node[] st;  // hakkatöflan

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeperateChaningHashST() {
        this(997);
    }

    public SeperateChaningHashST(int m) {
        this.m = m;
        st = new Node[m];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        st[i] = new Node(key, val, st[i]);
        n++;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
