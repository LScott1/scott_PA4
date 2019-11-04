package counter;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        //created new instance method
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        //file names
        String inputFile = "problem2.txt";
        String outputFile = "unique_word_counts.txt";
        //use methods on files
        duplicateCounter.count(inputFile);
        duplicateCounter.write(outputFile);
    }
}
