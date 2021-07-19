import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        N /= 10;
        int tensDigit = N % 10;
        System.out.println(tensDigit);
    }
}