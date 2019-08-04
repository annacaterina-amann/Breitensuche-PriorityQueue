import java.io.*;


/**
 * Class that handles all necessary input/output operations.
 * <p>
 * Recommendation: Do not change this.
 *
 * @author Koitz-Hristov
 */
public class IOHandler {
    /**
     * Reads the input file and parses it such the line containing the input is returned as a String array
     *
     * @param filename the input file.
     * @return input as a String
     */
    public String readInput(String filename) {
        String lines = "";
        String line = "";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            while ((line= in.readLine()) != null) {
                lines+=line+"\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }


    /**
     * Prints the result to an output file that has the same name as the input file but instead of the extension ".in"
     * the extension ".out".
     *
     * @param result         String representing the result of the calculation to be stored in an output file.
     * @param input_filename Name of the input file.
     */
    public void printResultToOutputFile(String result, String input_filename) {
        String output_filename = input_filename.replace(".in", ".out").replace("input", "output");
        File outputFile = new File(output_filename);
        FileWriter fw;
        try {
            fw = new FileWriter(outputFile);
            fw.write(result);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.err.println("Error: Could not write to file " + outputFile.getAbsolutePath());
            System.exit(-1);
        }
    }

}
