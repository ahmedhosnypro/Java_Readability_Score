package readability;

public class ReadabilityScore {
    String text;
    String lowerCaseString;
    double sentences;
    double chars;
    double words;
    double syllables;
    double polysyllables;
    double S; //S is the average number of sentences per 100 words.
    double L; //L is the average number of characters per 100 words
    double automatedReadabilityIndex;
    double Flesch_Kincaid;
    double SMOG;
    double Coleman_Liau;

    public ReadabilityScore(String input) {
        text = input;
        this.lowerCaseString = input.toLowerCase();
        analyze();
    }

    public double getSentences() {
        return sentences;
    }

    public double getChars() {
        return chars;
    }

    public double getWords() {
        return words;
    }

    public double getSyllables() {
        return syllables;
    }

    public double getPolysyllables() {
        return polysyllables;
    }

    public double getAutomatedReadabilityIndex() {
        return automatedReadabilityIndex;
    }

    public double getFlesch_Kincaid() {
        return Flesch_Kincaid;
    }

    public double getSMOG() {
        return SMOG;
    }

    public double getColeman_Liau() {
        return Coleman_Liau;
    }

    private void analyze() {
        String[] Sentences = lowerCaseString.split("[.!?]");

        //number of sentences
        sentences = Sentences.length;

        //number of chars
        chars = lowerCaseString.replaceAll("\\s", "").length();

        //analyzing words
        for (var s : Sentences) {
            String[] Words = s.trim().split("\\s");

            //number of words
            words += Words.length;

            //number of syllables and polysyllables
            for (String word : Words) {
                int vowels = countVowels(word);
                syllables += vowels;
                if (vowels > 2) {
                    polysyllables++;
                }
            }
        }

        automatedReadabilityIndex();
        Flesch_Kincaid();
        SMOG();
        Coleman_Liau();
    }

    private void automatedReadabilityIndex() {
        automatedReadabilityIndex = 4.71 * (chars / words) + 0.5 * (words / sentences) - 21.43;
    }

    private void Flesch_Kincaid() {
        Flesch_Kincaid = 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
    }

    private void SMOG() {
        SMOG = 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
    }

    private void Coleman_Liau() {
        L = chars / words * 100;
        S = sentences / words * 100;

        Coleman_Liau = 0.0588 * L - 0.296 * S - 15.8;
    }

    private static int countVowels(String s) {
        //use letters a, e, i, o, u, y as vowels.

        // Do not count double-vowels (for example, "rain" has 2 vowels but only 1 syllable).
        String removedDoubleVowel = s.replaceAll("[aeiouy]{2}", "a");

        //Count the number of vowels in the word.
        String removedNonVowel = removedDoubleVowel.replaceAll("[^aeiouy]", "");

        // If at the end it turns out that the word contains 0 vowels, then consider this word as a 1-syllable one.
        if (removedNonVowel.length() == 0)
            return 1;

        // 3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" has 1 syllable).
        else if (s.endsWith("e") && removedNonVowel.length() != 1)
            return removedNonVowel.length() - 1;
        else
            return removedNonVowel.length();
    }

}
