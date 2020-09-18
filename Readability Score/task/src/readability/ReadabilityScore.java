package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadabilityScore {
    private final int chars;
    private final int words;
    private final int sentences;
    private final String text;
    private final double score;
    private final String[] agesByScore = {"5-6", "6-7", "7-9", "9-10", "10-11", "11-12", "12-13",
                            "13-14", "14-15", "15-16", "16-17", "17-18", "18-24", "24+"};

    public ReadabilityScore(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        text = scanner.useDelimiter("\\A").next();
        scanner.close();

        chars = charsCount(text);
        words = wordsCount(text);
        sentences = sentencesCount(text);
        score = 4.71 * chars / words + 0.5 * words / sentences - 21.43;
    }

    private int charsCount(String text) {
        return text.replaceAll("[\\s+]", "").length();
    }

    private int wordsCount(String text) {
        return text.split("\\s+").length;
    }

    private int sentencesCount(String text) {
        return text.trim().split("[.!?]").length;
    }

    public void getReadability() {

        System.out.println("The text is:");
        System.out.println(text);
        System.out.println("\nWords: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + chars);
        System.out.printf("The score is: %.2f\n", score);
        System.out.printf("This text should be understood by %s year olds.", agesByScore[(int) score]);
    }
}
