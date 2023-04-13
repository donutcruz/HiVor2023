import java.util.LinkedList;
import java.util.Queue;

public class MyQueueExample {
    public static void main(String[] args) {
        Queue<String> myQueue = new LinkedList<String>();
        myQueue.add("A");
        myQueue.add("B");
        myQueue.add("C");
        System.out.println(myQueue); // prints [A, B, C]
    }
}
