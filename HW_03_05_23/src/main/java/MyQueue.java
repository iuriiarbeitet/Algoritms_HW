import java.util.Arrays;

public class MyQueue implements QueueInterface {
    private int[] arr;      // массив для хранения элементов queue
    private int head;      // head указывает на передний элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    public MyQueue(int size)
    {
        arr = new int[size];
        capacity = size;
        count = 0;
    }

    @Override
    public void addHead(int a) {
        count++;
        int[] newArr = new int[count];
        newArr[0] = a;
        for (int i = 1; i < count; i++) {
             newArr[i] = arr[i-1];
        }
        arr = newArr;
        head = arr[0];
        tail = arr[count-1];
        capacity = count;
    }

    @Override
    public void addTail(int a) {
        int[] newArr = new int[count+1];
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[i];
        }
        newArr[count] = a;
        arr = newArr;
        count++;
        head = arr[0];
        tail = arr[count-1];
        capacity = count;
    }

//удаляет элемент из начала queue
    @Override
    public void remove() {
        if(count > 0) {
            count--;
            int[] newArr = new int[count];
            for (int i = 0; i < count; i++) {
                newArr[i] = arr[i + 1];
            }
            arr = newArr;
            head = arr[0];
            tail = arr[count-1];
            capacity = count;
        }
    }

    @Override
    public int peek() {
        return count > 0 ? arr[0] : -1;
    }

    @Override
    public boolean isEmpty() {
        return count == 0 ? true : false;
    }

    @Override
    public int size() {
        return count;
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
