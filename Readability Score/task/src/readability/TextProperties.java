package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextProperties {
    private final String text;
    private int chars;
    private int syllables;
    private int polySyllablesWords;
    private int words;
    private int sentences;

    public TextProperties(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        text = scanner.useDelimiter("\\A").next();
        scanner.close();

        charsCount(text);
        wordsCount(text);
        sentencesCount(text);
        syllablesCount(text);

    }

    private void charsCount(String text) {
        chars = text.replaceAll("[\\s+]", "").length();
    }

    private void wordsCount(String text) {
        words = text.split("\\s+").length;
    }

    private void sentencesCount(String text) {
        sentences = text.trim().split("[.!?]").length;
    }

    private void syllablesCount(String text) {
        int count = 0;
        int polySylWordsCount = 0;
        var words = text.trim().
                toLowerCase().
                replaceAll("[.,?!:;]", "").
                split("\\s+");

        for (String word : words) {
            int sylAtWord = word.
                    replaceAll("e\\b", "").
                    replaceAll("\\bth\\b", " a ").
                    replaceAll("[aeiouy]{3}", "a").
                    replaceAll("[aeiouy]{2}", " a").
                    replaceAll("[^aeiouy]", "").length();
            sylAtWord = sylAtWord == 0 ? 1 : sylAtWord;
            count += sylAtWord;
            polySylWordsCount += sylAtWord > 2 ? 1 : 0;
        }
        polySyllablesWords = polySylWordsCount;
        syllables = count;
    }

    public String toString() {
        return text;
    }

    public int getChars() {
        return chars;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolySyllablesWords() {
        return polySyllablesWords;
    }

    public int getWords() {
        return words;
    }

    public int getSentences() {
        return sentences;
    }
}
