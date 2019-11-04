package remover;

import java.util.*;
import java.io.*;

public class DuplicateRemover {
    //create a set of strings
    private Set<String> uniqueWords;
    private boolean error = false;

    public DuplicateRemover() {
        this.uniqueWords = new HashSet<>();
    }

    public void remove(String dataFile) {
        File inputFile = new File(dataFile);

        if (dataFile.isEmpty()) {
            System.out.println("Error: input file is empty");
            error = true;
            return;//not found, exit method
        }

        try {
            InputStream inFile = new FileInputStream(inputFile);
            Scanner in = new Scanner(inFile);

            //scan in words from file
            while (in.hasNext()) {
                String getLine;
                getLine = in.nextLine();
                //split between spaces, periods, commas, and other. regular expression, can match multiple.
                String[] line = getLine.split("[\\s.,!?]+");

                //load in line, collection. Trim and remove spaces.

                //use for each loop
                for (String from: line) {
                    String noSpaces;
                    noSpaces = from.trim();
                    this.uniqueWords.add(noSpaces);
                }
                /*
                for (int i = 0; i < line.length; i++) {
                    String word =
                 */
            }

            //done reading files, close
            in.close();
            inFile.close();
        } catch (IOException ex) {
            System.out.println("Error: input file does not exist");
        }
    }//end remove

    public void write(String outputFile) {
        File outFile = new File(outputFile);

        try {//attempt to open and write to file
            OutputStream out = new FileOutputStream(outFile, false);

            //get and print to file, for each in collection
            this.uniqueWords.toArray();
            for (Object word: this.uniqueWords.toArray()) {
                //this.uniqueWords.toArray();
                //for (int i = 0; i < uniqueWords.toArray().length; i++)
                //print unique word
                out.write(((String) word).getBytes());
                //go to next line
                out.write((System.lineSeparator()).getBytes());
            }
            if(!error)
                System.out.println("***finished successfully***");
            else
                System.out.println("re: Output file exists, though nothing to write");

            //done writing, close outfile
            out.close();
        } catch (IOException ex) {
            System.out.println("Error: output file could not be written to");
        }
    }
}//end write
