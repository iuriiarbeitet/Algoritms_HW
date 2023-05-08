import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
       // Queue<String> queue = new ArrayDeque<>();


        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(2);
        myQueue.addHead(23);
        myQueue.addHead(12);
        myQueue.addHead(22);

        myQueue.addTail(1);
        myQueue.addTail(10);
        myQueue.addTail(1);
        myQueue.addTail(10);
        myQueue.addTail(11);
        System.out.println(myQueue.size());
        System.out.println(myQueue.isEmpty());
        myQueue.print();
        myQueue.remove();
        myQueue.remove();
        myQueue.remove();
        myQueue.print();
        System.out.println(myQueue.size());
        System.out.println(myQueue.getHead());
        System.out.println(myQueue.getTail());
    }
}
