package readability;

public class readabilityAnalyzer {
    public static String analyze(String input) {
        String[] sentences = input.split("[.!?]");

        double Sentences = sentences.length;

        double Words = 0;
        for (var s : sentences) {
            String[] words = s.trim().split("\\s");
            Words += words.length;
        }

        //number of chars
        double Chars = input.replaceAll("\\s", "").length();

        double score = 4.71 * (Chars / Words) + 0.5 * (Words / Sentences) - 21.43;

        String age = "";
        if (score >=13)
            age = "24+";
        else if (score >=12)
            age = "18-24";
        else if (score >=11)
            age = "17-18";
        else  if (score >=10)
            age = "16-17";
        else if (score >=9)
            age = "15-16";
        else if (score >=8)
            age = "14-15";
        else if (score >=7)
            age = "13-14";
        else if (score >=6)
            age = "12-13";
        else if (score >=5)
            age = "11-12";
        else if (score >=4)
            age = "10-11";
        else if (score >=3)
            age = "9-10";
        else if (score >=2)
            age = "7-9";
        else if (score >=1)
            age = "6-7";
        else if (score >0)
            age = "5-6";

        return "Words: " + Words + "\n" +
                "Sentences: " + Sentences + "\n" +
                "Characters: " + Chars + "\n" +
                (String.format("The score is: %.2f", score)) + "\n" +
                "This text should be understood by " + age + "-year-olds. ";
    }

}
