package readability;

import java.util.Scanner;

public class ReadabilityScoreAnalyzer {
    public static void Analyze(ReadabilityScore score) {
        System.out.print("Words: " + score.getWords() + "\n" +
                "Sentences: " + score.getSentences() + "\n" +
                "Characters: " + score.getChars() + "\n" +
                "Syllables: " + score.getSyllables() + "\n" +
                "Polysyllables: " + score.getPolysyllables() + "\n" +
                "Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
    }

    public static void PrintScore(ReadabilityScore score) {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();
        StringBuilder out = new StringBuilder();
        double ARI = score.getAutomatedReadabilityIndex();
        double FK = score.getFlesch_Kincaid();
        double SMOG = score.getSMOG();
        double CL = score.getColeman_Liau();
        double averageScore;

        switch (choice) {
            case "ARI":
                out.append(String.format("Automated Readability Index: %.2f (about %s-year-olds).\n\n", ARI, calcScore(ARI)));
                break;
            case "FK":
                out.append(String.format("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n\n", FK, calcScore(FK)));
                break;
            case "SMOG":
                out.append(String.format("Simple Measure of Gobbledygook:  %.2f (about %s-year-olds).\n\n", SMOG, calcScore(SMOG)));
                break;
            case "CL":
                out.append(String.format("Coleman–Liau index: %.2f (about %s-year-olds).\n\n", CL, calcScore(CL)));
                break;
            case "all":
                out.append(String.format("Automated Readability Index: %.2f (about %s-year-olds).\n", ARI, calcScore(ARI)));
                out.append(String.format("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n", FK, calcScore(FK)));
                out.append(String.format("Simple Measure of Gobbledygook:  %.2f (about %s-year-olds).\n", SMOG, calcScore(SMOG)));
                out.append(String.format("Coleman–Liau index: %.2f (about %s-year-olds).\n\n", CL, calcScore(CL)));
                averageScore = (ARI + FK + SMOG + CL) / 4;
                out.append(String.format("This text should be understood in average by %.2f-year-olds.", averageScore));
                break;
            default:
                System.err.println("try again");
                PrintScore(score);
        }
        System.out.println("\n" + out);
    }

    private static String calcScore(double index) {
        index = Math.round(index);
        String age = "";
        if (index >= 14)
            age = "24+";
        else if (index >= 13)
            age = "24";
        else if (index >= 12)
            age = "18";
        else if (index >= 11)
            age = "17";
        else if (index >= 10)
            age = "16";
        else if (index >= 9)
            age = "15";
        else if (index >= 8)
            age = "14";
        else if (index >= 7)
            age = "13";
        else if (index >= 6)
            age = "12";
        else if (index >= 5)
            age = "11";
        else if (index >= 4)
            age = "10";
        else if (index >= 3)
            age = "9";
        else if (index >= 2)
            age = "7";
        else if (index > 1)
            age = "6";

        return age;
    }
}