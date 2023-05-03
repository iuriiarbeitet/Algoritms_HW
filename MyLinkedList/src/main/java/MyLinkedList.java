public class MyLinkedList implements  InterfaceLinkedList {

        private Node last;
        private Node first;
        private int size;
    public MyLinkedList() {
        this.last = null;
        this.first = null;
        this.size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            add(data);
        } else if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
            size++;
        } else {
            Node newNode = new Node(data);
            Node current = getNode(index);
            newNode.previous = current.previous;
            current.previous.next = newNode;
            newNode.next = current;
            current.previous = newNode;
            size++;
        }
    }

    public void remove(int data) {
        Node current = first;
        while (current != null) {
            if (current.data == data) {
                if (current == first && current == last) {
                    first = null;
                    last = null;
                } else if (current == first) {
                    first = current.next;
                    first.previous = null;
                } else if (current == last) {
                    last = current.previous;
                    last.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                break;
            }
            current = current.next;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            if (size == 1) {
                first = null;
                last = null;
            } else {
                first = first.next;
                first.previous = null;
            }
        } else if (index == size-1) {
            last = last.previous;
            last.next = null;
        } else {
            Node current = getNode(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }

    public void set(int index, int data) {
        Node current = getNode(index);
        current.data = data;
    }

    public int get(int index) {
        return getNode(index).data;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean contains(int data) {
        Node current = first;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i=0; i<index; i++) {
            current = current.next;
        }
        return current;

    }

    private class Node {
        Node next;
        Node previous;
        int data;

        Node(int data) {
            this.next = null;
            this.previous = null;
            this.data = data;
        }
    }

}

