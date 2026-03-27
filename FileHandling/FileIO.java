package FileHandling;

import java.io.*;

public class FileIO {

    private static final String BASE_PATH = "C:\\Users\\ishan\\OneDrive\\Documents\\Java-Dsa\\FileHandling\\";

    public static void main(String[] args) throws Exception{
        writeSampleInput();
        processFile();
    }

    // writes input file (practice only)
    private static void writeSampleInput() throws Exception{
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(BASE_PATH + "sampleInput.txt"));
            int[] nums = {8, 7, 6, 9, 2, 7, 1, -10};

            for (int num : nums) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // reads input file and writes output file
    private static void processFile() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(BASE_PATH + "sampleInput.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(BASE_PATH + "sampleOutput.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                //reading input
                int num = Integer.parseInt(line.trim());

                //processing / finding output
                int square = num * num;

                //writing output to file
                writer.write(String.valueOf(square));
                writer.newLine();
            }

            reader.close();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
