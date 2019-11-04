package counter;

import java.util.*;
import java.io.*;

public class DuplicateCounter {
    Map<String, Integer> wordCounter;
    boolean error = false;

    //hash map to store words of file. holds word and int
    public DuplicateCounter() {

        this.wordCounter = new HashMap<String, Integer>();
    }

    public void count(String dataFile) {
        File inputFile = new File(dataFile);

        if (dataFile.isEmpty()) {
            System.out.println("Error: input file is empty");
            error = true;
            return;//not found, exit method
        }

        try {//attempt to open and write to file
            InputStream inFile = new FileInputStream(inputFile);
            Scanner in = new Scanner(inFile);

            //scan in
            while (in.hasNext()) {
                //as long as a line exists, get
                String getLine;
                getLine = in.nextLine();

                //then split between spaces, periods, commas, and other. regular expression, can match multiple.
                String[] line = getLine.split("[\\s.,!?]+");

                //for each, traverse collection
                for (String from: line) {
                    String noSpaces;
                    noSpaces = from.trim();
                    if(wordCounter.get(noSpaces) != null){//when not empty
                        Integer position = wordCounter.get(noSpaces);
                        position ++;
                        wordCounter.replace(noSpaces, position);
                    }
                    else {
                        wordCounter.put(noSpaces, 1);
                    }
                }
            }

            //done reading, close
            inFile.close();
            in.close();
        } catch (IOException ex) {
            System.out.println("Error: input file does not exist");
        }
    }//end count



    public void write(String outputFile) {
        File outFile = new File(outputFile);

        try {
            OutputStream out = new FileOutputStream(outFile, false);

            //begin writing to file, for each
            for (Object obj: this.wordCounter.keySet()) {
                out.write(((String) obj).getBytes());

                //get and write data from map. getOrDefault gets val from map found
                out.write(("        ").getBytes());
                Integer occurrences = wordCounter.getOrDefault(obj, 0);
                out.write(String.valueOf(occurrences).getBytes());
                //go to new line
                out.write((System.lineSeparator()).getBytes());
            }
            if(!error)
                System.out.println("***finished successfully***");
            else
                System.out.println("re: Output file exists, though nothing to write");

            //done writing, close
            out.close();
        } catch (IOException ex) {//file not found
            System.out.println("Error: output file could not be written to");
        }
    }
}//end write
