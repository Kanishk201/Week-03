package inputstreamreader.readandwritetofile;

import java.io.*;

public class ReadAndWriteToFile {


    public static void readInputAndWriteToFile(String filePath) {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String input;

            System.out.println("Enter text to write to the file (type 'exit' to stop):");


            while (true) {
                input = bufferedReader.readLine();


                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }


                writer.write(input);
                writer.newLine();
            }

            System.out.println("User input has been written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error while reading input or writing to the file.");
        } finally {
            try {
                // Close the BufferedReader
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Error closing BufferedReader.");
            }
        }
    }

    public static void readAndWriteToFile() {
        String filePath = "file.txt";

        readInputAndWriteToFile(filePath);
    }
}

