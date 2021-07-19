package readability;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static readability.readabilityAnalyzer.analyze;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        File inFile = new File(filePath);

        try (Scanner scanner = new Scanner(inFile)) {
            StringBuilder in = new StringBuilder();
            while (scanner.hasNext()) {
                in.append(scanner.nextLine());
            }
            System.out.println(analyze(in.toString()));
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
