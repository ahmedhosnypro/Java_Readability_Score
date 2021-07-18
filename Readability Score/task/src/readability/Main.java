package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() > 100){
            System.out.println("HARD");
        }
        else {
            System.out.println("EASY");
        }
    }
}
