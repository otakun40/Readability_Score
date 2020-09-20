package readability;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            TextProperties textProperties = new TextProperties(args[0]);
            ReadabilityIndex index = new ReadabilityIndex(textProperties);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
