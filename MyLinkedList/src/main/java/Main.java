import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.addAt(4, 6);
        myLinkedList.addAt(5, 7);
        myLinkedList.addAt(6, 8);
        myLinkedList.addAt(7, 9);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.contains(5));
        System.out.println(myLinkedList.isEmpty());

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }


    }

}
