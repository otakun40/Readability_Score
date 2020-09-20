package readability;

import java.util.Scanner;

public class ReadabilityIndex {
    private TextProperties text;
    private final String[] agesByScore = {"6", "7", "9", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "24", "24+"};
    private double sumOfYears;

    public ReadabilityIndex(TextProperties text) {
        this.text = text;
        sumOfYears = 0;
        showTextProperties();
        selectIndex();
    }

    private String indexARI() {
        double score = 4.71 * text.getChars() / text.getWords() + 0.5 * text.getWords() / text.getSentences() - 21.43;
        sumOfYears += Integer.parseInt(
                agesByScore[(int) (Math.round(score) == 14 ? Math.round(score) - 2 : Math.round(score) - 1)]);
        return String.format(
                "Automated Readability Index: %.2f (about %s year olds).", score, agesByScore[(int) Math.round(score) - 1]);
    }

    private String indexFK() {
        double score = 0.39 * text.getWords() / text.getSentences()
                        + 11.8 * text.getSyllables() / text.getWords() - 15.59;
        sumOfYears += Integer.parseInt(
                agesByScore[(int) (Math.round(score) == 14 ? Math.round(score) - 2 : Math.round(score) - 1)]);
        return String.format(
                "Flesch–Kincaid readability tests: %.2f (about %s year olds).",
                score, agesByScore[(int) Math.round(score) - 1]);
    }

    private String indexSMOG() {
        double score = 1.043 * Math.sqrt((double) text.getPolySyllablesWords() * 30 / text.getSentences()) + 3.1291;
        sumOfYears += Integer.parseInt(
                agesByScore[(int) (Math.round(score) == 14 ? Math.round(score) - 2 : Math.round(score) - 1)]);
        return String.format(
          "Simple Measure of Gobbledygook: %.2f (about %s year olds).", score, agesByScore[(int) Math.round(score) - 1]);
    }

    private String indexCL() {
        double l = (double) text.getChars() / text.getWords() * 100;
        double s = (double) text.getSentences() / text.getWords() * 100;
        double score = 0.0588 * l - 0.296 * s -15.8;
        sumOfYears += Integer.parseInt(
                agesByScore[(int) (Math.round(score) == 14 ? Math.round(score) - 2 : Math.round(score) - 1)]);
        return String.format(
                "Coleman–Liau index: %.2f (about %s year olds).", score, agesByScore[(int) Math.round(score) - 1]);
    }

    public void selectIndex() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String index = scanner.next().toLowerCase();
        System.out.println();
        switch (index) {
            case "ari":
                System.out.println(indexARI());
                break;
            case "fk":
                System.out.println(indexFK());
                break;
            case "smog":
                System.out.println(indexSMOG());
                break;
            case "cl":
                System.out.println(indexCL());
                break;
            case "all":
                System.out.println(indexARI());
                System.out.println(indexFK());
                System.out.println(indexSMOG());
                System.out.println(indexCL());
                System.out.printf("\nThis text should be understood in average by %.2f year olds.", sumOfYears / 4);
                break;
            default:break;
        }
    }

    public void showTextProperties() {
        System.out.println("The text is:");
        System.out.println(text);
        System.out.println("Words: " + text.getWords());
        System.out.println("Sentences: " + text.getSentences());
        System.out.println("Characters: " + text.getChars());
        System.out.println("Syllables: " + text.getSyllables());
        System.out.println("Polysyllables: " + text.getPolySyllablesWords());
    }

    public void setText(TextProperties text) {
        this.text = text;
    }
}