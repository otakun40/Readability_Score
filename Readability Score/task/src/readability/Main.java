package readability;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            ReadabilityScore score = new ReadabilityScore(args[0]);
            score.getReadability();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
