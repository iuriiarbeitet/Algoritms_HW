import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(0, 11);
        dynamicArray.add(1, 22);
        dynamicArray.add(2, 33);
        dynamicArray.add(3, 44);
        dynamicArray.add(4, 55);
        dynamicArray.add(2, 88);

        System.out.println(dynamicArray);
    }
}
