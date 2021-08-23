import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(scanner.next());
        }
        int cnt = 0;
        int longestSeq = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (array[i] > min) {
                min = array[i];
                cnt++;
            } else {
                min = array[i];
                if (longestSeq < cnt) {
                    longestSeq = cnt;
                }
                cnt = 1;
            }
        }

        if (longestSeq < cnt) {
            longestSeq = cnt;
        }
        System.out.println(longestSeq);


    }
}