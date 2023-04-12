import java.util.Stack;

public class HanB {

    private static Stack<Integer> stackInit = new Stack<>();
    private static Stack<Integer> stackHelp = new Stack<>();
    private static Stack<Integer> stackDestin = new Stack<>();
    static char a = 'A';
    static char b = 'B';
    static char c = 'C';

    public static void main(String[] args) {
        stackInit.push(5);
        stackInit.push(4);
        stackInit.push(3);
        stackInit.push(2);
        stackInit.push(1);
        System.out.println("Первый стержень A : " + stackInit);

        System.out.println("Описание, как переложить n  дисков со стержня А на В через промежуточный С");
        moveDisksStack(stackInit.size(), stackInit, a, stackDestin, b, stackHelp, c);
        System.out.println("Финальнальный стержень B : " + stackDestin);
    }
    public static void moveDisksStack(int n, Stack<Integer> stackInit, char A, Stack <Integer> stackDestin, char B, Stack<Integer> stackHelp, char C){
        if (n == 1){
            System.out.println(A + " " + stackInit + " " + B + " " + stackDestin + " " + C + " " + stackHelp);
            System.out.println("диск, " + n + " с стержня " + A + " " + stackInit + ", на стержень, " + B + " " + stackDestin);

            int last = stackInit.pop();
            stackDestin.push(last);
        }
        else{
            moveDisksStack(n-1, stackInit, A, stackHelp, C, stackDestin, B);
            System.out.println(A + " " + stackInit + " " + B + " " + stackDestin + " " + C + " " + stackHelp);
            System.out.println("диск, " + n + " с стержня " + A + " " + stackInit + ", на стержень, " + B + " " + stackDestin);

            int last = stackInit.pop();
            stackDestin.push(last);
            moveDisksStack(n-1, stackHelp, C,  stackDestin, B, stackInit, A);
        }
    }
}
