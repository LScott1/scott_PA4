package remover;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        //created new instance method
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        //file names
        String inputFile = "problem1.txt";
        String outputFile = "unique_words.txt";
        //use methods on files
        duplicateRemover.remove(inputFile);
        duplicateRemover.write(outputFile);
    }
}
