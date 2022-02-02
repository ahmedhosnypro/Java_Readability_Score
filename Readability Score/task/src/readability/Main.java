package readability;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static readability.ReadabilityScoreAnalyzer.*;


public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        File inFile = new File(filePath);

        try (Scanner fileScanner = new Scanner(inFile)) {
            StringBuilder in = new StringBuilder();
            while (fileScanner.hasNext()) {
                in.append(fileScanner.nextLine());
            }
            ReadabilityScore score = new ReadabilityScore(in.toString());
            Analyze(score);
            PrintScore(score);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}