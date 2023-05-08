import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @org.junit.jupiter.api.Test
    void addHead() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(1);
        myQueue.addHead(1);
        myQueue.addHead(1);
        assertEquals(3, myQueue.size());
    }

    @org.junit.jupiter.api.Test
    void addTail() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addTail(1);
        myQueue.addTail(1);
        assertEquals(2, myQueue.size());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(1);
        myQueue.addHead(1);
        myQueue.addHead(1);
        myQueue.remove();
        assertEquals(2, myQueue.size());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        MyQueue myQueue = new MyQueue(10);
        assertEquals(-1, myQueue.peek());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(1);
        assertEquals(false, myQueue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(1);
        myQueue.addHead(1);
        myQueue.addHead(1);
        assertEquals(3, myQueue.size());
    }

    @org.junit.jupiter.api.Test
    void testGetHead() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(3);
        myQueue.addHead(33);
        myQueue.addHead(43);
        myQueue.addTail(1);
        myQueue.addTail(11);
        myQueue.addTail(15);
        assertEquals(43, myQueue.getHead());
    }

    @org.junit.jupiter.api.Test
    void testGetTail() {
        MyQueue myQueue = new MyQueue(10);
        myQueue.addHead(3);
        myQueue.addHead(33);
        myQueue.addHead(43);
        myQueue.addTail(1);
        myQueue.addTail(11);
        myQueue.addTail(15);
        assertEquals(15, myQueue.getTail());
    }
}