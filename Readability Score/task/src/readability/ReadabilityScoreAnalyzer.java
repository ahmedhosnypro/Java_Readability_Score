package readability;

import java.util.Scanner;

public class ReadabilityScoreAnalyzer {
    public static void Analyze(ReadabilityScore score) {
        System.out.print("Words: " + (int) score.getWords() + "\n" +
                "Sentences: " + (int) score.getSentences() + "\n" +
                "Characters: " + (int) score.getChars() + "\n" +
                "Syllables: " + (int) score.getSyllables() + "\n" +
                "Polysyllables: " + (int) score.getPolysyllables() + "\n" +
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

        String ARI_Out = String.format("Automated Readability Index: %.2f (about %s-year-olds).", ARI, calcScore(ARI));
        String FK_Out = String.format("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).", FK, calcScore(FK));
        String SMOG_Out = String.format("Simple Measure of Gobbledygook:  %.2f (about %s-year-olds).", SMOG, calcScore(SMOG));
        String CL_Out = String.format("Coleman–Liau index: %.2f (about %s-year-olds).", CL, calcScore(CL));
        switch (choice) {
            case "ARI":
                out.append(ARI_Out);
                break;
            case "FK":
                out.append(FK_Out);
                break;
            case "SMOG":
                out.append(SMOG_Out);
                break;
            case "CL":
                out.append(CL_Out);
                break;
            case "all":
                out.append(ARI_Out).append('\n');
                out.append(FK_Out).append('\n');
                out.append(SMOG_Out).append('\n');
                out.append(CL_Out).append("\n\n");
                double averageScore = (ARI + FK + SMOG + CL) / 4;
                out.append(String.format("This text should be understood in average by %.2f-year-olds.", averageScore));
                break;
            default:
                System.err.println("try again");
                PrintScore(score);
        }
        System.out.println("\n" + out);
    }

    private static String calcScore(double index) {
        // To calculate the age use the upper bound of the range.
        index = Math.round(index);

        switch ((int) index) {
            case 1:
                return "6";
            case 2:
                return "7";
            case 3:
                return "9";
            case 4:
                return "10";
            case 5:
                return "11";
            case 6:
                return "12";
            case 7:
                return "13";
            case 8:
                return "14";
            case 9:
                return "15";
            case 10:
                return "16";
            case 11:
                return "17";
            case 12:
                return "18";
            case 13:
                return "24";
            case 14:
                return "24+";
            default:
                return "Error";
        }
    }
}