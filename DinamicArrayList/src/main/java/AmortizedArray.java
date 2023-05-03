import java.util.ArrayList;

public class AmortizedArray {
    public static DynamicArray dynamicArray = new DynamicArray();

    public static void main(String[] args) {
        fillFromLast(10_000);

        System.out.println("Time ns removeLast: " + removeLast(dynamicArray));
        fillFromFirst(10_000);
        System.out.println("Time ns removeFirst: " + removeFirst(dynamicArray));
        fillFromMid(10_000);
        System.out.println("Time ns removeMid: " + removeMid(dynamicArray));


    }

    public static long removeLast(DynamicArray dynamicArray) {
        long start = System.nanoTime();
        while (!dynamicArray.isEmpty()) {
            dynamicArray.removeAt(dynamicArray.count - 1);
        }
        return System.nanoTime() - start;
    }

    public static long removeFirst(DynamicArray dynamicArray) {
        long start = System.nanoTime();
        while (!dynamicArray.isEmpty()) {
            dynamicArray.removeAt(0);
        }
        return System.nanoTime() - start;
    }

    public static long removeMid(DynamicArray dynamicArray) {
        long start = System.nanoTime();
        while (!dynamicArray.isEmpty()) {
            dynamicArray.removeAt(dynamicArray.count / 2);
        }
        return System.nanoTime() - start;
    }

    public static DynamicArray fillFromLast(int size) {
        dynamicArray = new DynamicArray();
        long start = System.nanoTime();
        for (int i = 1; i <= size; i++) {
            dynamicArray.addAt(i);
        }
        dynamicArray.shrinkSize();
        System.out.println("Time ns fillFromLast : " + (System.nanoTime() - start));
        return dynamicArray;
    }

    public static DynamicArray fillFromFirst(int size) {
        dynamicArray = new DynamicArray();
        long start = System.nanoTime();
        for (int i = 1; i <= size; i++) {
            dynamicArray.add(0, i);
        }
        dynamicArray.shrinkSize();
        System.out.println("Time ns fillFromFirst : " + (System.nanoTime() - start));
        return dynamicArray;
    }

    public static DynamicArray fillFromMid(int size) {
        dynamicArray = new DynamicArray();
        long start = System.nanoTime();
        for (int i = 1; i <= size; i++) {
            dynamicArray.add(dynamicArray.count / 2, i);
        }
        dynamicArray.shrinkSize();
        System.out.println("Time ns fillFromMid : " + (System.nanoTime() - start));
        return dynamicArray;
    }
}
