public class Tasks1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 10, 15, 25, 6, 9, 10, 4, 5, 5};

        getMin(arr);
        sum(arr);
    }

    public static void getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int min2 = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= min) {
                    min2 = min; // 22
                    min = arr[i];  //11
                } else if (arr[i] > min && arr[i] < min2) {
                    min2 = arr[i];
                }
            }
            System.out.println("MIN 1: " + min);
            System.out.println("MIN 2: " + min2);
    }

    private static void sum(int[] arr) {
        int sum = 0;
        int j = arr.length;
            for (int i = 0; i < arr.length; i++) {
                j--;
                if (i != j && i < j) {
                    sum = sum + (arr[i] + arr[j]);
                } else if (i == j) {
                    sum = sum + arr[i];
                    break;
                }
            }
        /* тут пример как я думал изночально:
        int conter = arr.length;
        for (int i = 0; i < arr.length; i++) {
            conter--;
            for (int j = arr.length-1; j >= 0; j--) {
                if (i != conter && i < conter){
                    sum = sum + (arr[i] + arr[conter]);
                    break;
                } else if (i == conter) {
                    sum = sum + arr[i];
                    break;
                }
            }
        }
        */
        System.out.println(sum);
    }
}

