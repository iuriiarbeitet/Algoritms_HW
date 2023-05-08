/**
 *  pushToEnd(int data) - вставляет элемент в конец queue
 *     remove() - удаляет элемент из начала queue
 *     peek() - возвращает элемент из начала не удаляя его
 *     isEmpty() - boolean
 *     size() - int
 */

public interface QueueInterface {
    void remove();
    int peek();
    boolean isEmpty();
    int size();
   void addHead(int a);
    void addTail(int a);
}
