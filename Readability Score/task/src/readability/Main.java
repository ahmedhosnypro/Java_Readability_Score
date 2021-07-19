package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] sentences = line.split("[.!?]");

        double numbOfSentence = sentences.length;
        double numbOfWords = 0;
        for (var s : sentences) {
            String[] words = s.trim().split("\\s");
            numbOfWords += words.length;
        }

        double average = numbOfWords / numbOfSentence;

        if (average > 10)
            System.out.println("HARD");
        else
            System.out.println("EASY");

    }
}
