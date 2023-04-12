import java.util.Scanner;
import java.util.Stack;

public class HanBashneaImperativ {

    private static Stack<Integer> stackInit = new Stack<>();
    private static Stack<Integer> stackHelp = new Stack<>();
    private static Stack<Integer> stackFinal = new Stack<>();

    public static void main(String[] args) {

        System.out.println(fillStack(stackInit));
        System.out.println(stackInit.empty());
        moveDisc(stackInit.size(), stackInit, stackHelp, stackFinal);
        System.out.println();
        System.out.println("Init Stack " + stackInit);
        System.out.println("Helper stack " + stackHelp);
        System.out.println("Final Stack " + stackFinal);

    }

    // Метод, который создает stack дисков
    private static Stack<Integer> fillStack(Stack<Integer> stackInit) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of disks : ");
        int n = scanner.nextInt();
        for (int i = n; i >= 1; i--) {
            stackInit.push(i);
        }
        scanner.close();
        return stackInit;
    }

    /**
     * Метод для переноса элементов в stackFinal
     */

    public static void moveDisc(int countOfDisk, Stack<Integer> stackA, Stack<Integer> stackB, Stack<Integer> stackFinal) {

        int moves = (int) (Math.pow(2, countOfDisk)) - 1;   // Количество операций необходимых для переноса всех дисков
        String a = "stackA";                           // Название стеков
        String b = "stackB";
        String c = "stackFinal";

        for (int i = 1; i <= moves; i++) {         // Рассматриваем каждый ход. Определяем какой элемент с какого в какой стек перенести
            System.out.println("----------------");
            if (i % 3 == 1) { //
                moveHelp(stackA, stackFinal, a, c);
            } else if (i % 3 == 2) {
                moveHelp(stackA, stackB, a, b);
            } else if (i % 3 == 0) {
                moveHelp(stackB, stackFinal, b, c);
            }
        }
    }

    public static void moveHelp(Stack stackCurrent, Stack to, String poleSrc, String poleDest) {
        int sourceTopDisk = stackCurrent.empty() ? 0 : (int) stackCurrent.pop();
        int destinationTopDisk = to.empty() ? 0 : (int) to.pop();

        if (sourceTopDisk == 0) {
            stackCurrent.push(destinationTopDisk);
            printSteps(destinationTopDisk, poleDest, poleSrc);
        } else if (destinationTopDisk == 0) {
            to.push(sourceTopDisk);
            printSteps(sourceTopDisk, poleSrc, poleDest);
        } else if (sourceTopDisk > destinationTopDisk) {
            stackCurrent.push(sourceTopDisk);
            stackCurrent.push(destinationTopDisk);
            printSteps(destinationTopDisk, poleDest, poleSrc);
        } else if (sourceTopDisk < destinationTopDisk) {
            to.push(destinationTopDisk);
            to.push(sourceTopDisk);
            printSteps(sourceTopDisk, poleSrc, poleDest);
        }
    }

    private static void printSteps(int nDisk, String init, String dest) {
        System.out.println("Move the disk " + nDisk + " from " + init + " to " + dest);
        System.out.println(stackInit + " " + " " + stackHelp + " " + stackFinal);
    }
}
